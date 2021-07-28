package kluszynski.example.controller.feign;

import kluszynski.example.dto.PersonDto;
import kluszynski.example.dto.PhoneDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="phones-and-persons", url="localhost:8082/phones-and-persons")
public interface PhonesAndPersons {
    @GetMapping("/persons/{personId}")
    PersonDto getPersonById(@PathVariable("personId") Long personId);

    @GetMapping("/phones/{phoneId}")
    PhoneDto getPhoneById(@PathVariable("phoneId") Long phoneId);
}
