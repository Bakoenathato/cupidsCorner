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
import za.ac.cput.domain.*;
import za.ac.cput.factory.*;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.MethodName.class)
class UserProfileControllerTest {
    private static UserProfile e=new UserProfile();
    private static User users;
    private static Location location;
    private static LocalDateTime x;
    // private Preference preference;
    private static Like like;
    @Autowired
    private TestRestTemplate restTemplate;

    private final String BASE_URL = "http://localhost:8080/userprofile";

    private static UserProfile userProfile;

    @BeforeAll
    public static void setup() {
        users= UserFactory.buildUser("BraedonMullisn01@gmail.com","1");
        location= LocationFactory.createLocation("","","");
        x= LocalDateTime.now();
        //prefernce=PrefernceFactory.createPrefernce();
        Like like= LikeFactory.buildLike("1","01","001",LocalDateTime.now());
    }

    @Test
    void a_create() {
        String url = BASE_URL + "/create";
        ResponseEntity<UserProfile> postResponse = restTemplate.postForEntity(url, userProfile, UserProfile.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        UserProfile created = postResponse.getBody();
        assertEquals(userProfile.getProfileID(), created.getProfileID());
        System.out.println("Created UserProfile: " + created);
    }

    @Test
    void b_read() {
        String url = BASE_URL + "/read/" + userProfile.getProfileID();
        ResponseEntity<UserProfile> getResponse = restTemplate.getForEntity(url, UserProfile.class);
        assertEquals(userProfile.getProfileID(), getResponse.getBody().getProfileID());
        System.out.println("Read UserProfile: " + getResponse.getBody());
    }

    @Test
    void c_update() {
        String url = BASE_URL + "/update";
        UserProfile updated = new UserProfile.Builder().copy(userProfile).setInterests("no").build();
        ResponseEntity<UserProfile> postResponse = restTemplate.postForEntity(url, updated, UserProfile.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        UserProfile updatedResponse = postResponse.getBody();
        assertEquals(userProfile.getProfileID(), updatedResponse.getProfileID());
        System.out.println("Updated: " + updatedResponse);
    }

    @Test
    void d_delete() {
        String url = BASE_URL + "/delete/" + userProfile.getProfileID();
        restTemplate.delete(url);
        System.out.println("Deleted gender with id: " + userProfile.getProfileID());
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