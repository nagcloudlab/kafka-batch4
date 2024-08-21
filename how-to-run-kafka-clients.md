install maven

```bash
sudo apt-get install maven
```

run the producer

```bash
cd /path/to/kafka-java-clients
mvn clean compile exec:java -Dexec.mainClass="com.example.producer.Producer"
```
