package kluszynski.example.controller;

import kluszynski.example.model.Person;
import kluszynski.example.repository.PersonJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class PersonRestController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PersonRestController.class);

    @Autowired
    private PersonJpaRepository personJpaRepository;

    @PostMapping("/persons")
    public Person addPerson(@RequestBody Person person) {
        LOGGER.info("Adding person {}", person);

        personJpaRepository.save(person);

        return person;
    }

    @GetMapping("/persons")
    public List<Person> getAllPersons() {
        LOGGER.info("Getting all persons");

        return personJpaRepository.findAll();
    }

    @GetMapping("/persons/{id}")
    public Person getPerson(@PathVariable Long id) {
        LOGGER.info("person id {}", id);

        return personJpaRepository.getById(id);
    }

    @ExceptionHandler({EntityNotFoundException.class})
    void handleBadRequests(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.NOT_FOUND.value());
    }
}
