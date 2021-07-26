# phones-and-persons
Phones and persons api.

Basic REST service with all repository methods and H2 database.
Will be called from another REST services.

## Database logging

To login into H2 database use link: http://localhost:8081/phones-and-persons/h2-console

Use JDBC URL from spring-boot logs (attaching example log):
```
2021-07-22 17:21:19.966  INFO 14816 --- [  restartedMain] o.s.b.a.h2.H2ConsoleAutoConfiguration    : H2 console available at '/h2-console'. Database available at 'jdbc:h2:mem:985670a5-5b69-4df0-bc98-e258a40ed9cb'
```

## Usage

### Actuator
```
curl -v http://localhost:8081/phones-and-persons/actuator
```

###PersonRestController from spring-boot-data-rest
```
curl -v POST -H "Content-Type: application/json" -d "{\"firstName\": \"Jack\", \"lastName\": \"White\", \"birthDate\": \"2010-01-01T20:00:02\", \"heightInCentimeters\": 186 }" http://localhost:8081/phones-and-persons/data-rest/persons
curl -v POST -H "Content-Type: application/json" -d "{\"firstName\": \"John\", \"lastName\": \"Fruciante\", \"birthDate\": \"2000-01-01T20:00:02\", \"heightInCentimeters\": 190 }" http://localhost:8081/phones-and-persons/data-rest/persons
curl -v http://localhost:8081/phones-and-persons/data-rest/persons
curl -v http://localhost:8081/phones-and-persons/data-rest/persons/1
curl -v http://localhost:8081/phones-and-persons/data-rest/persons/2
curl -v http://localhost:8081/phones-and-persons/data-rest/persons/1000
curl -v -X PUT -H "Content-Type: application/json" -d "{\"firstName\": \"Jack1\", \"lastName\": \"White1\", \"birthDate\": \"2010-01-01T20:00:02\", \"heightInCentimeters\": 186 }" http://localhost:8081/phones-and-persons/data-rest/persons/1
curl -v -X DELETE -H "Content-Type: application/json" http://localhost:8081/phones-and-persons/data-rest/persons/1
curl -v -X DELETE -H "Content-Type: application/json" http://localhost:8081/phones-and-persons/data-rest/persons/1000
```bash