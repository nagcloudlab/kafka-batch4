```bash
bin/kafka-topics.sh \
--create \
--topic topic1 \
--partitions 3 \
--replication-factor 3 \
--config retention.ms=86400000 \
--config min.insync.replicas=1 \
--bootstrap-server 20.204.154.238:9092
```

producer performance test: ( throughput)

```bash
bin/kafka-producer-perf-test.sh \
--topic topic1 \
--num-records 1000000 \
--record-size 1024 \
--throughput -1 \
--producer-props \
    bootstrap.servers=20.204.154.238:9092
```
