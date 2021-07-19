package kluszynski.example.simpleservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
public class SimpleRESTController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleRESTController.class);

    private static final String OK = "OK";

    @GetMapping("/noParametersEndpoint")
    public String noParametersEndpoint() {
        return OK;
    }

    @GetMapping({"/pathVariableStringEndpoint", "/pathVariableStringEndpoint/{id}"})
    public String pathVariableStringEndpoint(@PathVariable(required = false) final String id) {
        LOGGER.info("PathVariable id value {}", id);

        return "Path variable (String): " + id;
    }

    @GetMapping({"/pathVariableNumberEndpoint", "/pathVariableNumberEndpoint/{number}"})
    public String pathVariableNumberEndpoint(@PathVariable(required = false) final Number number) {
        LOGGER.info("PathVariable number value {}", number);

        return "Path variable (Number): " + number;
    }

    @GetMapping({"/pathVariableLocalDateTimeEndpoint", "/pathVariableLocalDateTimeEndpoint/{localDateTime}"})
    public String pathVariableLocalDateTimeEndpoint(
            @PathVariable(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) final LocalDateTime localDateTime) {
        LOGGER.info("PathVariable localDateTime value {}", localDateTime);

        return "Path variable (LocalDateTime): " + localDateTime;
    }

    @GetMapping({"/pathParameterStringEndpoint", "/pathParameterStringEndpoint"})
    public String pathParameterStringEndpoint(@PathParam("stringParam") final String stringParam) {
        LOGGER.info("PathParameter stringParam value {}", stringParam);

        return "Path parameter (String): " + stringParam;
    }


    @GetMapping("/loggingEndpoint")
    public String loggingEndpoint() {
        LOGGER.trace("This is a trace message");
        LOGGER.debug("This is a debug message");
        LOGGER.info("This is a info message");
        LOGGER.warn("This is a warn message");
        LOGGER.error("This is a  error message");

        return OK;
    }
}
