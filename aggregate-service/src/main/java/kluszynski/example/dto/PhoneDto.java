package kluszynski.example.dto;

import lombok.Value;

@Value
public class PhoneDto {
    String countryPrefix;
    String number;
}
