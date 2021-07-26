package kluszynski.example.dto;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class PersonDto {
    String firstName;
    String lastName;
    LocalDateTime birthDate;
    Long heighInCentimeters;
}
