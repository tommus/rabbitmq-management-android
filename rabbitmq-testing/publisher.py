from logging import getLogger
from time import sleep

from rabbitpy import (
    Exchange,
    Message
)
from rabbitpy.exceptions import (
    AMQPException,
    ConnectionResetException,
    RabbitpyException
)

from common import init_logger_configuration, prepare_extended_parser
from worker import Worker

LOGGER = getLogger('consumer')


class Publisher(Worker):
    def __init__(self, args):
        super().__init__(args)
        self.channel = None
        self.exchange = None

    def start(self):
        try:
            self.channel, self.exchange = self._try_connect_channel()

            while self._keep_going:
                self._try_send_message()
                LOGGER.info('Message has been published.')
                sleep(self.args.delay)

        except ConnectionError:
            pass

    def _try_create_channel(self, connection):
        try:
            return connection.channel()
        except (RabbitpyException, AMQPException):
            pass

        raise ConnectionError('An error occurred while trying to create a channel.')

    def _try_create_exchange(self, channel, exchange):
        try:
            return Exchange(channel=channel, name=exchange)
        except RabbitpyException:
            pass

        raise ConnectionError('An error occurred while trying to create an exchange.')

    def _try_connect_channel(self):
        address = self._prepare_address(
            self.args.address,
            self.args.port,
            self.args.username,
            self.args.password,
            self.args.vhost
        )
        connection = self._try_open_connection(address=address)
        channel = self._try_create_channel(connection=connection)
        exchange = self._try_create_exchange(channel=channel, exchange=self.args.exchange)
        exchange.declare()
        queue = self._try_create_queue(channel=channel, queue=self.args.queue)
        queue.declare()
        queue.bind(exchange)
        return channel, exchange

    def _try_send_message(self):
        message = self._prepare_message()
        body = Message(channel=self.channel, body_value=message)

        try:
            body.publish(exchange=self.exchange)
        except ConnectionResetException:
            pass

    def _prepare_message(self):
        return {
            'foo': 'bar',
            'baz': 1
        }


if __name__ == '__main__':
    init_logger_configuration()
    args = prepare_extended_parser().parse_args()
    publisher = Publisher(args)
    publisher.start()
