import json
from argparse import ArgumentParser
from logging import getLogger
from logging.config import dictConfig

import os

USERNAME = 'guest'
PASSWORD = 'guest'
PORT = 5672
ADDRESS = '127.0.0.1'
DELAY = 1
QUEUE = 'queue.queue'
EXCHANGE = 'exchange.exchange'
VHOST = 'vhost'

LOGGER = getLogger("common")
LOGGING_CONFIG = "logging.json"


def prepare_simple_parser():
    parser = ArgumentParser(description='Constantly publishes messages to RabbitMQ service.')
    parser.add_argument(
        '-a', '--address', type=str, metavar='ADDRESS', default=ADDRESS,
        help='Connect to the RabbitMQ service at this address (default: {})'.format(ADDRESS)
    )
    parser.add_argument(
        '-P', '--port', type=int, metavar='PORT', default=PORT,
        help='RabbitMQ service port number (default: {})'.format(PORT)
    )
    parser.add_argument(
        '-u', '--username', type=str, metavar='USERNAME', default=USERNAME,
        help='RabbitMQ login credential (default: {})'.format(PORT)
    )
    parser.add_argument(
        '-p', '--password', type=str, metavar='PASSWORD', default=PASSWORD,
        help='RabbitMQ password credential (default: {})'.format(PASSWORD)
    )
    parser.add_argument(
        '-q', '--queue', type=str, metavar='QUEUE', default=QUEUE,
        help='Queue name to connect to (default: {})'.format(QUEUE)
    )
    parser.add_argument(
        '-v', '--vhost', type=str, metavar='VHOST', default=VHOST,
        help='Vhost name to connect to (default: {})'.format(VHOST)
    )
    return parser


def prepare_extended_parser():
    parser = prepare_simple_parser()
    parser.add_argument(
        '-d', '--delay', type=float, metavar='DELAY', default=DELAY,
        help='Delay (in seconds) between publication of consecutive messages (default: {} sec)'.format(DELAY)
    )
    parser.add_argument(
        '-e', '--exchange', type=str, metavar='EXCHANGE', default=EXCHANGE,
        help='Exchange name to connect to (default: {})'.format(EXCHANGE)
    )
    return parser


def init_logger_configuration():
    logger_conf = get_config_file(LOGGING_CONFIG)
    configuration = load_configuration(logger_conf)
    dictConfig(configuration)


def get_config_file(config_name):
    file_path = os.path.join(get_config_directory(), config_name)
    return open(file_path, 'r')


def get_config_directory():
    return os.path.join(os.path.dirname(__file__), 'config')


def load_configuration(json_file):
    try:
        return json.load(json_file)
    except (ValueError, TypeError) as e:
        raise ValueError('Invalid logger configuration file: {}'.format(e))
