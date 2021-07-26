package kluszynski.example.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PhoneDto {
    String countryPrefix;
    String number;
}
