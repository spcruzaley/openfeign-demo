package com.spcruzaley.resttemplate.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestTemplateDemo {

    private String url = "https://gorest.co.in/public/v2/users";

    public String getUsers() {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        if(!responseEntity.getStatusCode().equals(HttpStatus.OK)) {
            System.out.println("Error al invocar la url " + url);
            return "";
        }

        return responseEntity.getBody();
    }

}
