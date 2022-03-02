package com.spcruzaley.resttemplate.demo;

import org.junit.Test;

public class RestApiClientTest {

    @Test
    public void testJsonResponse() {
        RestApiClient restApiClient = new RestApiClient();
        String output = restApiClient.getUsers();

        System.out.println(output);
    }
}