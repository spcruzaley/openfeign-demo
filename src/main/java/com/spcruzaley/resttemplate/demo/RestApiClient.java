package com.spcruzaley.resttemplate.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@Slf4j
public class RestApiClient {

    private final RestTemplate restTemplate;

    public RestApiClient() {
        this.restTemplate = new RestTemplate();
    }

    public String getUsers() {
        String url = "https://gorest.co.in/public/v2/users";
        ResponseEntity<String> response =
                restTemplate.getForEntity(url, String.class);

        if (!response.getStatusCode().equals(HttpStatus.OK)) {
            log.error("Error al invocar url: {}", url);
        }

        return response.getBody();
    }

}
