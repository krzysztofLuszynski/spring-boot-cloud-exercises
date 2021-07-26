package kluszynski.example.controller;

import kluszynski.example.dto.CallResultDto;
import kluszynski.example.dto.PersonDto;
import kluszynski.example.dto.PhoneDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class CallUsingRestTemplateController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CallUsingRestTemplateController.class);

    @GetMapping("/rest-template/call")
    public CallResultDto call() {
        LOGGER.info("Call using rest template");

        final PersonDto personDto = new PersonDto("firstName", "lastName",
                LocalDateTime.parse("2010-01-01T20:00:02"), 120L);

        final PhoneDto phoneDto = new PhoneDto("20", "12131231");

        return new CallResultDto(personDto, phoneDto);
    }
}
