package com.example.spring.eureka.client.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@RestController
@RequiredArgsConstructor
public class ConsumerController {

    private final RestTemplate restTemplate;


    private static HttpEntity<?> getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        return new HttpEntity<>(headers);
    }

    @GetMapping("/message")
    public String getMessage() throws RestClientException {

        String baseUrl = "http://SPRING-BOOT-EUREKA-CLIENT-REST-API/hello";
        ResponseEntity<String> response = null;
        try {
            response = restTemplate.getForEntity(baseUrl, String.class);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return Objects.requireNonNull(response).getBody();
    }
}
