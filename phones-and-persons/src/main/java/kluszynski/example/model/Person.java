package kluszynski.example.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@ToString
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Person extends AbstractEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "BIRTH_DATE")
    private LocalDateTime birthDate;

    @Column(name = "HEIGHT_IN_CENTIMETERS")
    private Long heightInCentimeters;

    // for JPA only
    protected Person() {}

    public Person(final String firstName, final String lastName,
                  final LocalDateTime birthDate, final Long heightInCentimeters) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.heightInCentimeters = heightInCentimeters;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(final LocalDateTime birthDate) {
        this.birthDate = birthDate;
    }

    public Long getHeightInCentimeters() {
        return heightInCentimeters;
    }

    public void setHeightInCentimeters(final Long heightInCentimeters) {
        this.heightInCentimeters = heightInCentimeters;
    }
}
