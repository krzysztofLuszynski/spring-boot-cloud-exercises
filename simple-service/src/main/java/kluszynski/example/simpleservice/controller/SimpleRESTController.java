package kluszynski.example.simpleservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleRESTController {

    @GetMapping(path = "/noParametersEndpoint")
    public String noParametersEndpoint() {
        return "noParametersEndpoint - OK";
    }
}
