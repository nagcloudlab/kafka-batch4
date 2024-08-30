https://nagcloudlab.notion.site/Redis-81969281b87a4c75846ee38c1ee11409?pvs=4

install redis-server in ubuntu

```bash
sudo apt update
sudo apt install redis-server
```

stop redis-server

```bash
sudo systemctl stop redis
```

start on foreground

```bash
redis-server
```

redis-cli

```bash
redis-cli
```

spring boot with redis

```bash
cd demo-service
mvn spring-boot:run -Dspring-boot.run.arguments="--server.port=8080"
curl -w "\n" -X GET http://localhost:8080/hello/foo
```
