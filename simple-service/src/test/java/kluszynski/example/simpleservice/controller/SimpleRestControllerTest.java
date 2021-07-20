package kluszynski.example.simpleservice.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.net.MalformedURLException;
import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SimpleRestControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void noParametersEndpoint() throws Exception {
        final ResponseEntity<String> response = restTemplate.getForEntity(
                getServiceUrl("noParametersEndpoint"), String.class);

        assertThat(response.getBody()).isEqualTo("OK");
    }

    @Test
    public void pathVariableStringEndpointNoVariable() throws Exception {
        final ResponseEntity<String> response = restTemplate.getForEntity(
                getServiceUrl("pathVariableStringEndpoint"), String.class);

        assertThat(response.getBody()).isEqualTo("Path variable (String): null");
    }

    @Test
    public void pathVariableStringEndpoint() throws Exception {
        final ResponseEntity<String> response = restTemplate.getForEntity(
                getServiceUrl("pathVariableStringEndpoint/stringValue"), String.class);

        assertThat(response.getBody()).isEqualTo("Path variable (String): stringValue");
    }

    @Test
    public void pathVariableNumberEndpointNoVariable() throws Exception {
        final ResponseEntity<String> response = restTemplate.getForEntity(
                getServiceUrl("pathVariableNumberEndpoint"), String.class);

        assertThat(response.getBody()).isEqualTo("Path variable (Number): null");
    }

    @Test
    public void pathVariableNumberEndpoint() throws Exception {
        final ResponseEntity<String> response = restTemplate.getForEntity(
                getServiceUrl("pathVariableNumberEndpoint/12.67"), String.class);

        assertThat(response.getBody()).isEqualTo("Path variable (Number): 12.67");
    }

    @Test
    public void pathVariableLocalDateTimeEndpointNoVariable() throws Exception {
        final ResponseEntity<String> response = restTemplate.getForEntity(
                getServiceUrl("pathVariableLocalDateTimeEndpoint"), String.class);

        assertThat(response.getBody()).isEqualTo("Path variable (LocalDateTime): null");
    }

    @Test
    public void pathVariableLocalDateTimeEndpoint() throws Exception {
        final ResponseEntity<String> response = restTemplate.getForEntity(
                getServiceUrl("pathVariableLocalDateTimeEndpoint/2021-12-12T06:00:12"), String.class);

        assertThat(response.getBody()).isEqualTo("Path variable (LocalDateTime): 2021-12-12T06:00:12");
    }

    @Test
    public void pathParameterStringEndpointNoVariable() throws Exception {
        final ResponseEntity<String> response = restTemplate.getForEntity(
                getServiceUrl("pathParameterStringEndpoint"), String.class);

        assertThat(response.getBody()).isEqualTo("Path parameter (String): null");
    }

    @Test
    public void pathParameterStringEndpoint() throws Exception {
        final ResponseEntity<String> response = restTemplate.getForEntity(
                getServiceUrl("pathParameterStringEndpoint?stringParam=stringValue"), String.class);

        assertThat(response.getBody()).isEqualTo("Path parameter (String): stringValue");
    }

    @Test
    public void pathParameterNumberEndpointNoVariable() throws Exception {
        final ResponseEntity<String> response = restTemplate.getForEntity(
                getServiceUrl("pathParameterNumberEndpoint"), String.class);

        assertThat(response.getBody()).isEqualTo("Path parameter (Number): null");
    }

    @Test
    public void pathParameterNumberEndpoint() throws Exception {
        final ResponseEntity<String> response = restTemplate.getForEntity(
                getServiceUrl("pathParameterNumberEndpoint?numberParam=12.67"), String.class);

        assertThat(response.getBody()).isEqualTo("Path parameter (Number): 12.67");
    }

    @Test
    public void pathParameterLocalDateTimeEndpointNoVariable() throws Exception {
        final ResponseEntity<String> response = restTemplate.getForEntity(
                getServiceUrl("pathParameterLocalDateTimeEndpoint"), String.class);

        assertThat(response.getBody()).isEqualTo("Path parameter (LocalDateTime): null");
    }

    @Test
    public void pathParameterLocalDateTimeEndpoint() throws Exception {
        final ResponseEntity<String> response = restTemplate.getForEntity(
                getServiceUrl("pathParameterLocalDateTimeEndpoint?localDateTimeParam=2021-12-12T06:00:12"), String.class);

        assertThat(response.getBody()).isEqualTo("Path parameter (LocalDateTime): 2021-12-12T06:00:12");
    }

    @Test
    public void loggingEndpoint() throws Exception {
        final ResponseEntity<String> response = restTemplate.getForEntity(
                getServiceUrl("loggingEndpoint"), String.class);

        assertThat(response.getBody()).isEqualTo("OK");
    }


    private String getServiceUrl(final String endpointPath) throws MalformedURLException {
        return new URL("http://localhost:" + port + "/simple-service/" + endpointPath).toString();
    }
}
