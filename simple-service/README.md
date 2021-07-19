# simple-service
Simple spring boot REST service.

Basic REST service with all actuator endpoints.

## Usage
http://localhost:8080/simple-service/actuator

http://localhost:8080/simple-service/noParametersEndpoint

http://localhost:8080/simple-service/pathVariableStringEndpoint
http://localhost:8080/simple-service/pathVariableStringEndpoint/12
http://localhost:8080/simple-service/pathVariableNumberEndpoint
http://localhost:8080/simple-service/pathVariableNumberEndpoint/12.67
http://localhost:8080/simple-service/pathVariableLocalDateTimeEndpoint
http://localhost:8080/simple-service/pathVariableLocalDateTimeEndpoint/2021-12-12T06:00:12

http://localhost:8080/simple-service/pathParameterStringEndpoint
http://localhost:8080/simple-service/pathParameterStringEndpoint?stringParam=hello
http://localhost:8080/simple-service/pathParameterNumberEndpoint
http://localhost:8080/simple-service/pathParameterNumberEndpoint?numberParam=12.67
http://localhost:8080/simple-service/pathParameterLocalDateTimeEndpoint
http://localhost:8080/simple-service/pathParameterLocalDateTimeEndpoint?localDateTimeParam=2021-12-12T06:00:12

http://localhost:8080/simple-service/loggingEndpoint
