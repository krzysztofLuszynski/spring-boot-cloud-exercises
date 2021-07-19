package kluszynski.example.simpleservice.controller;

import kluszynski.example.simpleservice.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PersonRESTControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void personsGet() throws Exception {
        final ResponseEntity<Person> response = restTemplate.getForEntity(
                getServiceUrl("persons/12"), Person.class);

        assertThat(response.getBody())
                .hasFieldOrPropertyWithValue("firstName", "Jack")
                .hasFieldOrPropertyWithValue("lastName", "White")
                .hasFieldOrPropertyWithValue("birthDate", LocalDateTime.parse("2010-01-01T20:00:02"))
                .hasFieldOrPropertyWithValue("heightInCentimeters", 186L);

    }

    @Test
    public void personsPost() throws Exception {
        final Person person = new Person(
                "John",
                "Fruciante",
                LocalDateTime.parse("2010-01-01T20:00:02"),
                190L
        );

        final ResponseEntity<Person> response = restTemplate.postForEntity(
                getServiceUrl("persons"), person, Person.class);

        assertThat(response.getBody()).isEqualTo(person);

    }

    private String getServiceUrl(final String endpointPath) throws MalformedURLException {
        return new URL("http://localhost:" + port + "/simple-service/" + endpointPath).toString();
    }
}
