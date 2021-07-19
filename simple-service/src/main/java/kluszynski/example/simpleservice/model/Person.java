package kluszynski.example.simpleservice.model;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class Person {
    String firstName;
    String lastName;
    LocalDateTime birthDate;
    Long heightInCentimeters;
}
