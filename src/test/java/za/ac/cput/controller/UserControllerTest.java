package za.ac.cput.controller;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.User;
import za.ac.cput.factory.UserFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/cupidsCorner_ADP372S_Capstone_Assignment/user";

    private static User user;

    @BeforeAll
    public static void setup(){
        user = UserFactory.buildUser("134", "Sanelisiwe", "2222", "234699872@mycput.ac.za", "Sanelisiwe", "Bontsi", "M", "14");
    }

    @Test
    void a_create(){
        String url = BASE_URL + "/create";
        ResponseEntity<User> postResponse = restTemplate.postForEntity(url, user, User.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        //assertEquals(postResponse.getStatusCode(), HttpStatus.OK);
        User userSaved = postResponse.getBody();
        assertNotNull(user.getUserId(), userSaved.getUserId());
        System.out.println("Saved data: " + userSaved);
    }

    @Test
    void b_read() {
        String url = BASE_URL + "/read" + user.getUserId();
        System.out.println("URL: " + url);
        ResponseEntity<User> response = restTemplate.getForEntity(url, User.class);
        assertEquals(user.getUserId(), response.getBody().getUserId());
        System.out.println("Read: " + response.getBody());
    }

    @Test
    void c_update(){
        String url = BASE_URL + "/update";
        User newUser = new User.Builder().copy(user).setUserName("Sanelisiwe Lisakhanya").build();
        ResponseEntity<User> postResponse = restTemplate.postForEntity(url, newUser, User.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        User userUpdated = postResponse.getBody();
        assertEquals(newUser.getUserId(), userUpdated.getUserId());
        System.out.println("Updated data: " + userUpdated);
    }

    @Test
    void d_delete(){
        String url = BASE_URL + "/delete" + user.getUserId();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
        System.out.println("Success: Deleted user");
    }

    @Test
    void getAll() {
        String url = BASE_URL + "/getall";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> getResponse = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show ALL:");
        System.out.println(getResponse);
        System.out.println(getResponse.getBody());
    }

}
