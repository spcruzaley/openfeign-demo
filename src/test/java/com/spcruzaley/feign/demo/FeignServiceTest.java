package com.spcruzaley.feign.demo;

import org.junit.Test;

public class FeignServiceTest {

    @Test
    public void testGetUsers() {
        FeignService feignService = new FeignService();
        String users = feignService.getUsers();

        System.out.println(users);
    }

}