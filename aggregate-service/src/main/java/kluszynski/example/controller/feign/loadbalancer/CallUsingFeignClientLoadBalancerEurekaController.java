package kluszynski.example.controller.feign.loadbalancer;

import kluszynski.example.dto.CallResultDto;
import kluszynski.example.dto.PersonDto;
import kluszynski.example.dto.PhoneDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import javax.websocket.server.PathParam;

@RestController
@Validated
public class CallUsingFeignClientLoadBalancerEurekaController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CallUsingFeignClientLoadBalancerEurekaController.class);

    @Autowired
    private PhonesAndPersonsLoadBalanced phonesAndPersons;

    @GetMapping("/feign-client-load-balancer-eureka/call")
    public CallResultDto call(
            @PathParam("personId") @NotNull(message = "is mandatory") final Long personId,
            @PathParam("phoneId") @NotNull(message = "is mandatory") final Long phoneId) {
        LOGGER.info("Call using rest template");

        final PersonDto personDto = phonesAndPersons.getPersonById(personId);
        final PhoneDto phoneDto = phonesAndPersons.getPhoneById(phoneId);

        return new CallResultDto(personDto, phoneDto);
    }
}
