# aggregate-service
Service calling phones-and-persons.

## Usage

Run from the upper folder.

```
gradle :eureka-service:bootRun
gradle :phones-and-persons:bootRun --args="--server.port=8082"
gradle :phones-and-persons:bootRun --args="--server.port=9082"
gradle :phones-and-persons:bootRun --args="--server.port=10082"
gradle :aggregated-service:bootRun
```

### Actuator
```
curl -v http://localhost:8083/aggregate-service/actuator
```

### CallUsingRestTemplateController
```
curl -v http://localhost:8083/aggregate-service/rest-template/call?personId=1000&phoneId=3
curl -v http://localhost:8083/aggregate-service/rest-template/call?personId=4&phoneId=3
curl -v http://localhost:8083/aggregate-service/feign-client/call?personId=1&phoneId=4
curl -v http://localhost:8083/aggregate-service/rest-template-load-balancer-eureka/call?personId=1&phoneId=4
curl -v http://localhost:8083/aggregate-service/feign-client-load-balancer-eureka/call?personId=1&phoneId=4

```