# simple-service
Simple spring boot REST service.

Basic REST service with all actuator endpoints.

## Usage

```bash
# actuator
curl -v http://localhost:8080/simple-service/actuator

# no parameters
curl -v http://localhost:8080/simple-service/noParametersEndpoint

# path variables
curl -v http://localhost:8080/simple-service/pathVariableStringEndpoint
curl -v http://localhost:8080/simple-service/pathVariableStringEndpoint/stringValue
curl -v http://localhost:8080/simple-service/pathVariableNumberEndpoint
curl -v http://localhost:8080/simple-service/pathVariableNumberEndpoint/12.67
curl -v http://localhost:8080/simple-service/pathVariableLocalDateTimeEndpoint
curl -v http://localhost:8080/simple-service/pathVariableLocalDateTimeEndpoint/2021-12-12T06:00:12

# path parameters
curl -v http://localhost:8080/simple-service/pathParameterStringEndpoint
curl -v http://localhost:8080/simple-service/pathParameterStringEndpoint?stringParam=stringValue
curl -v http://localhost:8080/simple-service/pathParameterNumberEndpoint
curl -v http://localhost:8080/simple-service/pathParameterNumberEndpoint?numberParam=12.67
curl -v http://localhost:8080/simple-service/pathParameterLocalDateTimeEndpoint
curl -v http://localhost:8080/simple-service/pathParameterLocalDateTimeEndpoint?localDateTimeParam=2021-12-12T06:00:12

# logging endpoint
curl -v http://localhost:8080/simple-service/loggingEndpoint

# person endpoint - invoke from simple-service directory !
curl -v http://localhost:8080/simple-service/persons/12
curl -v POST -H "Content-Type: application/json" -d "{\"firstName\": \"John\", \"lastName\": \"Fruciante\", \"birthDate\": \"2010-01-01T20:00:02\", \"heightInCentimeters\": 190 }" http://localhost:8080/simple-service/persons
curl -v POST -H "Content-Type: application/json" http://localhost:8080/simple-service/persons -d @src/test/resources/kluszynski/example/simpleservice/controller/person.json
```bash