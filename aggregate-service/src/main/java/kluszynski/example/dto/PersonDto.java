package kluszynski.example.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class PersonDto {
    String firstName;
    String lastName;
    LocalDateTime birthDate;
    Long heightInCentimeters;
}
