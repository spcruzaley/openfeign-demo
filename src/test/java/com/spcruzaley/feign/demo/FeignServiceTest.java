package com.spcruzaley.feign.demo;

import com.spcruzaley.feign.demo.model.Gender;
import com.spcruzaley.feign.demo.model.StatusType;
import com.spcruzaley.feign.demo.model.User;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class FeignServiceTest {

    public static FeignService feignService;

    public static FeignApiClient feignApiClient;

    @BeforeClass
    public static void setUp() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.spcruzaley.feign.demo");
        context.refresh();

        feignApiClient = (FeignApiClient) context.getBean("feignApiClient");
        String apiUrl = (String) context.getBean("apiUrl");
        String token = (String) context.getBean("token");

        feignService = new FeignService(feignApiClient, apiUrl, token);
    }

    @Test
    public void testGetUsers() {
        List<User> userList = feignService.getUsers();

        assertNotNull(userList);
        assertTrue(userList.size() > 0);
    }

    @Test
    public void testGetUserById() {
        int id = 1500;
        User actualUser = feignService.getUserById(id);

        assertNotNull(actualUser);
        assertEquals(id, actualUser.getId());
    }

    @Test
    public void testCreateUser() {
        String randomEmail = UUID.randomUUID().toString().concat("@server.com");
        User expectedUser = User.builder()
                .name("spcruzaley")
                .email(randomEmail)
                .gender(Gender.male)
                .status(StatusType.active)
                .build();

        User actualUser = feignService.createUser(expectedUser);

        assertNotNull(actualUser);
        assertEquals(expectedUser.getEmail(), actualUser.getEmail());
    }

    @Test
    public void testUpdateUser() {
        User userCreated = createTestUser(UUID.randomUUID());

        User userModified = feignService.createUser(userCreated);
        userModified.setName("updated");

        User userUpdated = feignService.updateUser(userModified.getId(), userModified);

        assertNotNull(userUpdated);
        assertNotEquals(userCreated, userUpdated);
        assertEquals(userModified, userUpdated);
    }

    @Test
    public void testDeleteUser() {
        User userCreated = feignService.createUser(createTestUser(UUID.randomUUID()));
        assertNotNull(userCreated);

        feignService.deleteUser(userCreated.getId());
        assertNull(feignService.getUserById(userCreated.getId()));
    }

    private User createTestUser(UUID uuid) {
        return User.builder()
                .id(1)
                .name("spcruzaley")
                .email(uuid.toString().concat("@server.com"))
                .gender(Gender.male)
                .status(StatusType.active)
                .build();
    }

}