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
public class SimpleRESTControllerTest {
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


    private String getServiceUrl(final String endpointPath) throws MalformedURLException {
        return new URL("http://localhost:" + port + "/simple-service/" + endpointPath).toString();
    }
}
