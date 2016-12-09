from signal import (
    SIGABRT,
    SIGINT,
    SIGTERM,
    signal
)

from rabbitpy import (
    Connection,
    Queue
)
from rabbitpy.exceptions import (
    AMQPException,
    RabbitpyException,
    RemoteCancellationException,
    RemoteClosedChannelException
)


class Worker(object):
    def __init__(self, args):
        self.args = args
        signal(SIGABRT, self._signal_handler)
        signal(SIGINT, self._signal_handler)
        signal(SIGTERM, self._signal_handler)
        self._keep_going = True

    def _signal_handler(self, signum, _):
        if signum in (SIGABRT, SIGINT, SIGABRT):
            self._keep_going = False

    def _prepare_address(self, address, port, username, password, vhost):
        if username == 'guest' and password == 'guest':
            return 'amqp://{}:{}/{}'.format(address, port, vhost)
        else:
            return 'amqp://{}:{}@{}:{}/{}'.format(username, password, address, port, vhost)

    def _try_open_connection(self, address):
        try:
            return Connection(address)
        except (RabbitpyException, AMQPException):
            pass

        raise ConnectionError('An error occurred while trying to connect to the service.')

    def _try_create_queue(self, channel, queue):
        try:
            return Queue(channel=channel, name=queue)
        except (RemoteClosedChannelException, RemoteCancellationException):
            pass

        raise ConnectionError('An error occurred while trying to create a queue.')
