package kluszynski.example;

import kluszynski.example.model.Person;
import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;

public class FillInitialData {
    private static final int PORT = 8081;

    private final RestTemplate restTemplate = new RestTemplate();

    public static void main(String[] args) throws Exception {
        final FillInitialData fillInitialData = new FillInitialData();
        fillInitialData.createPersons();
    }

    private void createPersons() throws MalformedURLException{
        createPerson(new Person("Jack",  "White", LocalDateTime.parse("2010-01-01T20:00:02"), 186L));
        createPerson(new Person("John",  "Fruciante", LocalDateTime.parse("2000-01-01T20:00:02"), 190L));
        createPerson(new Person("Jimmy",  "Page", LocalDateTime.parse("1950-01-01T20:00:02"), 179L));
        createPerson(new Person("John",  "Bohnam", LocalDateTime.parse("1952-01-01T20:00:02"), 169L));
        createPerson(new Person("Robby",  "Williams", LocalDateTime.parse("1980-01-01T20:00:02"), 185L));
        createPerson(new Person("John",  "Zorn", LocalDateTime.parse("1955-01-01T20:00:02"), 183L));
        createPerson(new Person("Anna",  "Van Lare", LocalDateTime.parse("1978-01-01T20:00:02"), 187L));
        createPerson(new Person("Edith",  "Piath", LocalDateTime.parse("1930-01-01T20:00:02"), 150L));
    }

    private void createPerson(final Person person) throws MalformedURLException {
        restTemplate.postForEntity(getServiceUrl("persons"), person, Person.class);
    }

    private String getServiceUrl(final String endpointPath) throws MalformedURLException {
        return new URL("http://localhost:" + PORT + "/simple-jpa-rest-repository/data-rest/" + endpointPath).toString();
    }
}
