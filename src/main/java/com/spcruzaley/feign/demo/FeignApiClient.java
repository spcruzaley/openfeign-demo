package com.spcruzaley.feign.demo;

import com.spcruzaley.feign.demo.model.User;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

import java.util.List;

public interface FeignApiClient {

    @RequestLine("GET /users")
    List<User> getUsers();

    @RequestLine("GET /users/{id}")
    User getUserById(@Param("id") int id);

    @RequestLine("POST /users")
    @Headers({"Content-Type: application/json",
            "Authorization: Bearer {token}"})
    User createUser(@Param("token") String token,
                    User user);

    @RequestLine("PUT /users/{id}")
    @Headers({"Content-Type: application/json",
            "Authorization: Bearer {token}"})
    User updateUser(@Param("token") String token,
                    @Param("id") int id, User user);

    @RequestLine("DELETE /users/{id}")
    @Headers("Authorization: Bearer {token}")
    void deleteUser(@Param("token") String token,
                    @Param("id") int id);

}
