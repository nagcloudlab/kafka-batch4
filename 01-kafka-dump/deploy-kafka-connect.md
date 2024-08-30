start worker-1 in distributed mode

```bash
bin/connect-distributed.sh config/connect-distributed-worker-1.properties
```

start worker-2 in distributed mode

```bash
bin/connect-distributed.sh config/connect-distributed-worker-2.properties
```

manage connectors

get list of connectors

```bash
curl http://localhost:8083/connectors
```

deploy file source connector

```bash
curl -X POST -H "Content-Type: application/json" --data '{
  "name": "file-source-connector",
  "config": {
    "connector.class": "org.apache.kafka.connect.file.FileStreamSourceConnector",
    "tasks.max": "1",
    "file": "/Users/nag/kafka-batch4/file1.txt",
    "topic": "test-topic"
  }
}' http://localhost:8083/connectors
```

check status of connector

```bash
curl http://localhost:8083/connectors/file-source-connector/status
```

delete connector

```bash
curl -X DELETE http://localhost:8083/connectors/file-source-connector
```

pause connector

```bash
curl -X PUT http://localhost:8083/connectors/file-source-connector/pause
```

resume connector

```bash
curl -X PUT http://localhost:8083/connectors/file-source-connector/resume
```

deploy file sink connector

```bash
curl -X POST -H "Content-Type: application/json" --data '{
  "name": "file-sink-connector",
  "config": {
    "connector.class": "org.apache.kafka.connect.file.FileStreamSinkConnector",
    "tasks.max": "1",
    "topics": "test-topic",
    "file": "/Users/nag/kafka-batch4/file2.txt"

  }
}' http://localhost:8083/connectors
```
