## create a new topic

```bash
bin/kafka-topics.sh --bootstrap-server localhost:9092 --create --topic topic1 --partitions 3
```

## list all topics

```bash
bin/kafka-topics.sh --bootstrap-server localhost:9092 --list
```

## describe a topic

```bash
bin/kafka-topics.sh --bootstrap-server localhost:9092 --describe --topic topic1
```

## delete a topic

```bash
bin/kafka-topics.sh --bootstrap-server localhost:9092 --delete --topic topic1
```
