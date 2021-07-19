package kluszynski.example.simpleservice.controller;

import kluszynski.example.simpleservice.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
public class PersonRESTController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PersonRESTController.class);

    @GetMapping("/persons/{id}")
    public Person newPerson(@PathVariable String id) {
        LOGGER.info("person {}", id);

        // returns mocked person
        return new Person(
                "Jack",
                "White",
                LocalDateTime.parse("2010-01-01T20:00:02"),
                186L
        );
    }

    @PostMapping("/persons")
    public Person newPerson(@RequestBody Person person) {
        LOGGER.info("person {}", person);

        return person;
    }
}
