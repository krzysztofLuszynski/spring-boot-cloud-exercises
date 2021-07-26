# aggregate-service
Service calling phones-and-persons.

## Usage

### Actuator
```
curl -v http://localhost:8083/aggregate-service/actuator
```

### CallUsingRestTemplateController
```
curl -v http://localhost:8083/aggregate-service/rest-template/call?personId=1000&phoneId=3
curl -v http://localhost:8083/aggregate-service/rest-template/call?personId=4&phoneId=3

```