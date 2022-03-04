package com.spcruzaley.resttemplate.demo;

import org.junit.Test;

public class RestTemplateDemoTest {

    @Test
    public void testGetUsers() {
        RestTemplateDemo restTemplateDemo = new RestTemplateDemo();
        String users = restTemplateDemo.getUsers();

        System.out.println(users);
    }

}