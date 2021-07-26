package kluszynski.example.repository;

import kluszynski.example.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonJpaRepository extends JpaRepository<Person, Long> {
}
