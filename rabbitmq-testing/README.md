# RabbitMQ Testing Tools

Scripts contained in this directory helps to test various RabbitMQ functionalities.

## Producer script

Constantly publishes messages to the RabbitMQ queue.

An example execution:

```bash
python publisher.py \
    --username=test \
    --password=test \
    --address=127.0.0.1 \
    --port=5672 \
    --delay=1 \
    --exchange=exchange.exchange \
    --queue=queue.queue \
    --vhost=test
```

## Consumer script

Constantly consumes messages from the RabbitMQ queue.

An example execution:

```bash
python consumer.py \
    --username=test \
    --password=test \
    --address=127.0.0.1 \
    --port=5672 \
    --queue=queue.queue \
    --vhost=test
```
