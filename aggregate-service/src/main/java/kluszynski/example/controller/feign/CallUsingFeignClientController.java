package kluszynski.example.controller.feign;

import kluszynski.example.dto.CallResultDto;
import kluszynski.example.dto.PersonDto;
import kluszynski.example.dto.PhoneDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import javax.websocket.server.PathParam;

@RestController
@Validated
public class CallUsingFeignClientController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CallUsingFeignClientController.class);

    @Autowired
    private PhonesAndPersons phonesAndPersons;

    @GetMapping("/feign-client/call")
    public CallResultDto call(
            @PathParam("personId") @NotNull(message = "is mandatory") final Long personId,
            @PathParam("phoneId") @NotNull(message = "is mandatory") final Long phoneId) {
        LOGGER.info("Call using rest template");

        final PersonDto personDto = phonesAndPersons.getPersonById(personId);
        final PhoneDto phoneDto = phonesAndPersons.getPhoneById(phoneId);

        return new CallResultDto(personDto, phoneDto);
    }
}
