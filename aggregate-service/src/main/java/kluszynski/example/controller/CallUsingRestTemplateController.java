package kluszynski.example.controller;

import kluszynski.example.dto.CallResultDto;
import kluszynski.example.dto.PersonDto;
import kluszynski.example.dto.PhoneDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.validation.constraints.NotNull;
import javax.websocket.server.PathParam;

@RestController
@Validated
public class CallUsingRestTemplateController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CallUsingRestTemplateController.class);

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/rest-template/call")
    public CallResultDto call(
            @PathParam("personId") @NotNull(message = "is mandatory") final Long personId,
            @PathParam("phoneId") @NotNull(message = "is mandatory") final Long phoneId) {
        LOGGER.info("Call using rest template");

        final PersonDto personDto = callForPersonDto(personId);
        final PhoneDto phoneDto = callForPhoneDto(phoneId);

        return new CallResultDto(personDto, phoneDto);
    }

    private PersonDto callForPersonDto(final Long personId) {
        LOGGER.info("personId: {}", personId);

        final ResponseEntity<PersonDto> response = restTemplate.getForEntity(
                "http://localhost:8082/phones-and-persons/persons/" + personId, PersonDto.class);

        if (response.getStatusCode() != HttpStatus.OK) {
            LOGGER.info("status from call to person: {}", response.getStatusCode());
        }

        return response.getBody();
    }

    private PhoneDto callForPhoneDto(final Long phoneId) {
        LOGGER.info("phoneId: {}", phoneId);

        final ResponseEntity<PhoneDto> response = restTemplate.getForEntity(
                "http://localhost:8082/phones-and-persons/phones/" + phoneId, PhoneDto.class);

        if (response.getStatusCode() != HttpStatus.OK) {
            LOGGER.info("status from call to phone: {}", response.getStatusCode());
        }

        return response.getBody();
    }
}
