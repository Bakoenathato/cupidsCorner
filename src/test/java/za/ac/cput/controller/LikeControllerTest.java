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
import za.ac.cput.domain.Like;
import za.ac.cput.domain.UserProfile;
import za.ac.cput.factory.LikeFactory;
import za.ac.cput.factory.LocationFactory;
import za.ac.cput.factory.UserFactory;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.MethodName.class)
class LikeControllerTest {
    private static LocalDateTime x;
    @Autowired
    private TestRestTemplate restTemplate;

    private final String BASE_URL = "http://localhost:8080/userprofile";

    private static Like like;
    @BeforeAll
    public static void setup() {

        x= LocalDateTime.now();
        like= LikeFactory.buildLike("1","01","001",LocalDateTime.now());
    }

    @Test
    void a_create() {
        String url = BASE_URL + "/create";
        ResponseEntity<Like> postResponse = restTemplate.postForEntity(url, like, Like.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Like created = postResponse.getBody();
        assertEquals(like.getLikedID(), created.getLikedID());
        System.out.println("Created Like: " + created);
    }

    @Test
    void b_read() {
        String url = BASE_URL + "/read/" + like.getLikedID();
        ResponseEntity<Like> getResponse = restTemplate.getForEntity(url, Like.class);
        assertEquals(like.getLikedID(), getResponse.getBody().getLikedID());
        System.out.println("Read Like: " + getResponse.getBody());
    }

    @Test
    void c_update() {
        String url = BASE_URL + "/update";
        Like updated = new Like.Builder().copy(like).setLiked_at(LocalDateTime.now()).build();
        ResponseEntity<Like> postResponse = restTemplate.postForEntity(url, updated, Like.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Like updatedResponse = postResponse.getBody();
        assertEquals(like.getLikedID(), updatedResponse.getLikedID());
        System.out.println("Updated: " + updatedResponse);
    }

    @Test
    void d_delete() {
        String url = BASE_URL + "/delete/" + like.getLikedID();
        restTemplate.delete(url);
        System.out.println("Deleted gender with id: " + like.getLikedID());
    }

    @Test
    void e_getAll() {
        String url = BASE_URL + "/getall";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Get All UserProfiles: ");
        System.out.println(response.getBody());
    }

}