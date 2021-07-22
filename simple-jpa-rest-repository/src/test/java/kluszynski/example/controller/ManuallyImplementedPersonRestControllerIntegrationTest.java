package kluszynski.example.controller;

import kluszynski.example.model.Person;
import kluszynski.example.repository.PersonJpaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ManuallyImplementedPersonRestControllerIntegrationTest {
    private final Person JACK_WHITE = new Person("Jack", "White",
            LocalDateTime.parse("2010-01-01T20:00:02"), 186L);
    private final Person JOHN_FRUCIANTE = new Person("John", "Fruciante",
            LocalDateTime.parse("2000-01-01T20:00:02"), 190L);

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private PersonJpaRepository personJpaRepository;

    @BeforeEach
    void cleanDatabase() {
        personJpaRepository.deleteAll();
    }

    @Test
    void getPersonByIdNonExisting() throws MalformedURLException {
        final ResponseEntity<Person> response = restTemplate.getForEntity(
                getServiceUrl("persons/1000"), Person.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
        assertThat(response.getBody())
                .hasFieldOrPropertyWithValue("firstName", null)
                .hasFieldOrPropertyWithValue("lastName", null)
                .hasFieldOrPropertyWithValue("birthDate", null)
                .hasFieldOrPropertyWithValue("heightInCentimeters", null);
    }

    @Test
    void getPersonById() throws MalformedURLException {
        personJpaRepository.save(JACK_WHITE);
        final Long id = JACK_WHITE.getId();

        final ResponseEntity<Person> response = restTemplate.getForEntity(
                getServiceUrl("persons/" + id), Person.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody())
                .hasFieldOrPropertyWithValue("firstName", JACK_WHITE.getFirstName())
                .hasFieldOrPropertyWithValue("lastName", JACK_WHITE.getLastName())
                .hasFieldOrPropertyWithValue("birthDate", JACK_WHITE.getBirthDate())
                .hasFieldOrPropertyWithValue("heightInCentimeters", JACK_WHITE.getHeightInCentimeters());
    }

    @Test
    void addPerson() throws MalformedURLException {
        final Person person = JACK_WHITE;

        final ResponseEntity<Person> postResponse = restTemplate.postForEntity(
                getServiceUrl("persons"), person, Person.class);

        assertThat(postResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(postResponse.getBody())
                .hasFieldOrPropertyWithValue("firstName", person.getFirstName())
                .hasFieldOrPropertyWithValue("lastName", person.getLastName())
                .hasFieldOrPropertyWithValue("birthDate", person.getBirthDate())
                .hasFieldOrPropertyWithValue("heightInCentimeters", person.getHeightInCentimeters());
    }

    @Test
    void getAllPersonsEmptyDatabase() throws Exception {
        final ResponseEntity<Person[]> getAllResponse = restTemplate.getForEntity(
                getServiceUrl("persons"), Person[].class);

        assertThat(getAllResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(getAllResponse.getBody()).isEmpty();
    }

    @Test
    void getAllPersonsTwoPersons() throws Exception {
        personJpaRepository.saveAll(Arrays.asList(JACK_WHITE, JOHN_FRUCIANTE));

        final ResponseEntity<Person[]> getAllResponse = restTemplate.getForEntity(
                getServiceUrl("persons"), Person[].class);

        assertThat(getAllResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(getAllResponse.getBody()).hasSize(2);

        assertThat(Objects.requireNonNull(getAllResponse.getBody())[0])
                .hasFieldOrPropertyWithValue("firstName", JACK_WHITE.getFirstName())
                .hasFieldOrPropertyWithValue("lastName", JACK_WHITE.getLastName())
                .hasFieldOrPropertyWithValue("birthDate", JACK_WHITE.getBirthDate())
                .hasFieldOrPropertyWithValue("heightInCentimeters", JACK_WHITE.getHeightInCentimeters());

        assertThat(getAllResponse.getBody()[1])
                .hasFieldOrPropertyWithValue("firstName", JOHN_FRUCIANTE.getFirstName())
                .hasFieldOrPropertyWithValue("lastName", JOHN_FRUCIANTE.getLastName())
                .hasFieldOrPropertyWithValue("birthDate", JOHN_FRUCIANTE.getBirthDate())
                .hasFieldOrPropertyWithValue("heightInCentimeters", JOHN_FRUCIANTE.getHeightInCentimeters());
    }

    @Test
    void updatePersonByIdNonExistingId() throws MalformedURLException {
        final HttpEntity<Person> request = new HttpEntity<>(new Person("", "", null, 0L));

        final ResponseEntity<Person> putResponse =
                restTemplate.exchange(getServiceUrl("persons/1000"),
                        HttpMethod.PUT, request, Person.class);

        assertThat(putResponse.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
        assertThat(putResponse.getBody())
                .hasFieldOrPropertyWithValue("firstName", null)
                .hasFieldOrPropertyWithValue("lastName", null)
                .hasFieldOrPropertyWithValue("birthDate", null)
                .hasFieldOrPropertyWithValue("heightInCentimeters", null);
    }

    @Test
    void updatePersonById() throws MalformedURLException {
        personJpaRepository.save(JACK_WHITE);
        final Long id = JACK_WHITE.getId();

        final HttpEntity<Person> request = new HttpEntity<>(JOHN_FRUCIANTE);

        final ResponseEntity<Person> putResponse =
                restTemplate.exchange(getServiceUrl("persons/" + id),
                        HttpMethod.PUT, request, Person.class);

        restTemplate.put(getServiceUrl("persons/" + id), JOHN_FRUCIANTE);

        assertThat(putResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(putResponse.getBody())
                .hasFieldOrPropertyWithValue("firstName", JOHN_FRUCIANTE.getFirstName())
                .hasFieldOrPropertyWithValue("lastName", JOHN_FRUCIANTE.getLastName())
                .hasFieldOrPropertyWithValue("birthDate", JOHN_FRUCIANTE.getBirthDate())
                .hasFieldOrPropertyWithValue("heightInCentimeters", JOHN_FRUCIANTE.getHeightInCentimeters());
    }

    private String getServiceUrl(final String endpointPath) throws MalformedURLException {
        return new URL("http://localhost:" + port + "/simple-jpa-rest-repository/manually-implemented/" + endpointPath).toString();
    }
}
