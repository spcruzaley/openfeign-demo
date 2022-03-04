package com.spcruzaley.feign.demo;

import feign.RequestLine;

public interface FeignApiClient {

    @RequestLine("GET /users")
    String getUsers();

}
