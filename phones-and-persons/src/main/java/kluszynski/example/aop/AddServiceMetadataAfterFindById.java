package kluszynski.example.aop;

import kluszynski.example.model.AbstractEntity;
import kluszynski.example.repository.PersonJpaRepository;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Aspect
public class AddServiceMetadataAfterFindById {
    private Logger LOGGER = LoggerFactory.getLogger(AddServiceMetadataAfterFindById.class);

    @Value("${server.servlet.contextPath}:${server.port}")
    private String description;

    @Pointcut("execution(* kluszynski.example.repository.*.findById*(..))")
    public void findById() {}

    @Autowired
    private PersonJpaRepository personJpaRepository;

    @AfterReturning(value = "findById()", returning = "abstractEntity")
    public void addServiceMetadata(final Object abstractEntity) {
        if (abstractEntity instanceof Optional) {
            final Optional<AbstractEntity> person = (Optional<AbstractEntity>) abstractEntity;
            (person.get()).setServiceMetadata(description);

            LOGGER.info("Updated serviceMetadata: {} on {}",  description, person.get());
        }
    }
}