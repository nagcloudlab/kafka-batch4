get all consumer groups

```bash
bin/kafka-consumer-groups.sh --bootstrap-server localhost:9092 --list
```

describe a consumer group

```bash
bin/kafka-consumer-groups.sh --bootstrap-server localhost:9092 --describe --group my-group
```
