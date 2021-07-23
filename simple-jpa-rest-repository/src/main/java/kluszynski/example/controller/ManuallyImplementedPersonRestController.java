package kluszynski.example.controller;

import kluszynski.example.model.Person;
import kluszynski.example.repository.PersonJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class ManuallyImplementedPersonRestController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ManuallyImplementedPersonRestController.class);

    @Autowired
    private PersonJpaRepository personJpaRepository;

    @PostMapping("/manually-implemented/persons")
    public Person addPerson(@RequestBody Person person) {
        LOGGER.info("Adding person {}", person);

        personJpaRepository.save(person);

        return person;
    }

    @GetMapping("/manually-implemented/persons")
    public List<Person> getAllPersons() {
        LOGGER.info("Getting all persons");

        return personJpaRepository.findAll();
    }

    @GetMapping("/manually-implemented/persons/{id}")
    public Person getPerson(@PathVariable Long id) {
        LOGGER.info("get person with id {}", id);

        return personJpaRepository.getById(id);
    }

    @PutMapping("/manually-implemented/persons/{id}")
    public Person updatePerson(@RequestBody Person person, @PathVariable Long id) {
        LOGGER.info("update person with id {}", id);

        final Person oldPerson = personJpaRepository.getById(id);
        oldPerson.setFirstName(person.getFirstName());
        oldPerson.setLastName(person.getLastName());
        oldPerson.setBirthDate(person.getBirthDate());
        oldPerson.setHeightInCentimeters(person.getHeightInCentimeters());

        return personJpaRepository.save(oldPerson);
    }

    @DeleteMapping("/manually-implemented/persons/{id}")
    public void deletePerson(@PathVariable Long id) {
        LOGGER.info("delete person with id {}", id);

        personJpaRepository.deleteById(id);
    }

    @ExceptionHandler({EntityNotFoundException.class, EmptyResultDataAccessException.class})
    void handleBadRequests(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.NOT_FOUND.value());
    }
}
