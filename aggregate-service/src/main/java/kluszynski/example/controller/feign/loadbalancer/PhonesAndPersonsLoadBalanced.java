package kluszynski.example.controller.feign.loadbalancer;

import kluszynski.example.dto.PersonDto;
import kluszynski.example.dto.PhoneDto;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="phones-and-persons")
@LoadBalancerClient(name = "phones-and-persons",
        configuration = LoadBalancerConfiguration.class)
public interface PhonesAndPersonsLoadBalanced {
    @GetMapping("phones-and-persons/persons/{personId}")
    PersonDto getPersonById(@PathVariable("personId") Long personId);

    @GetMapping("phones-and-persons/phones/{phoneId}")
    PhoneDto getPhoneById(@PathVariable("phoneId") Long phoneId);
}
