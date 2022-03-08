package com.spcruzaley.feign.demo;

import com.spcruzaley.feign.demo.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j
public class FeignService {

    public final FeignApiClient feignApiClient;

    public final String apiUrl;

    private final String token;

    @Autowired
    public FeignService(FeignApiClient FeignApiClient, String apiUrl, String token) {
        this.feignApiClient = FeignApiClient;
        this.apiUrl = apiUrl;
        this.token = token;
    }

    public List<User> getUsers() {
        log.info("Obteniendo usuarios desde la api {}", apiUrl);

        return feignApiClient.getUsers();
    }

    public User getUserById(int id) {
        log.info("Obteniendo usuario con id {}", id);

        try {
            return feignApiClient.getUserById(id);
        } catch (Exception e) {
            return null;
        }
    }

    public User createUser(User user) {
        log.info("Creando usuario {}", user);

        return feignApiClient.createUser(token, user);
    }

    public User updateUser(int id, User user) {
        log.info("Actualizando usuario {}", user.getName());

        return feignApiClient.updateUser(token, id, user);
    }

    public void deleteUser(int id) {
        log.info("Eliminando usuario con id {}", id);

        feignApiClient.deleteUser(token, id);
    }

}
