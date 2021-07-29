# config-service
Config service.


## Usage

Run from the upper folder.

```
gradle :config-service:bootRun
```

```
# config service
curl -v http://localhost:8888/phones-and-persons/default
curl -v http://localhost:8888/phones-and-persons/dev
curl -v http://localhost:8888/phones-and-persons/qa

curl -v http://localhost:8888/aggregate-service/default
curl -v http://localhost:8888/aggregate-service/dev
curl -v http://localhost:8888/aggregate-service/qa

```