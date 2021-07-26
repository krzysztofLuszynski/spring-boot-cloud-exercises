package kluszynski.example.repository;

import kluszynski.example.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneJpaRepository extends JpaRepository<Phone, Long> {
}
