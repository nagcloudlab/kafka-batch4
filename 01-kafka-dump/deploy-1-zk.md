## deploy 1 zookeeper server

```bash
bin/zookeeper-server-start.sh config/zookeeper.properties
```

```bash
bin/zookeeper-shell.sh localhost:2181
ls /
ls /brokers
ls /brokers/ids
```
