from logging import getLogger

from common import init_logger_configuration, prepare_simple_parser
from worker import Worker

LOGGER = getLogger('consumer')


class Consumer(Worker):
    def __init__(self, args):
        super().__init__(args)
        self.channel = None
        self.queue = None

    def start(self):
        try:
            self.channel, self.queue = self._try_connect_channel()

            for message in self._try_receive_message():
                LOGGER.info(message.json())

                # TODO: This will block until the next message receive.
                if not self._keep_going:
                    break

        except ConnectionError:
            pass

    def _try_connect_channel(self):
        address = self._prepare_address(
            self.args.address,
            self.args.port,
            self.args.username,
            self.args.password,
            self.args.vhost
        )
        connection = self._try_open_connection(address=address)
        channel = connection.channel()
        queue = self._try_create_queue(channel=channel, queue=self.args.queue)
        return channel, queue

    def _try_receive_message(self):
        message = self.queue.consume()
        return message


if __name__ == '__main__':
    init_logger_configuration()
    args = prepare_simple_parser().parse_args()
    consumer = Consumer(args)
    consumer.start()
