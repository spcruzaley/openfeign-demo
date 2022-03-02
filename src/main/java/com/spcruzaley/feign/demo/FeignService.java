package com.spcruzaley.feign.demo;

import feign.Feign;

public class FeignService {

    private String url = "https://gorest.co.in/public/v2";

    public String getUsers() {
        FeignApiClient feignApiClient = Feign.builder()
                .target(FeignApiClient.class, url);
        return feignApiClient.getUsers();
    }

}
