package za.ac.cput.controller;
/*
    PreferenceControllerTest.java
    PreferenceControllerTest class
    Author: Thato Mokoena (222667087)
    Date 25 May 2024
*/

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
public class PreferenceControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private final String BASE_URL = "http://localhost:8080/cupidscorner/match";

    private DisplayImage image = DisplayImageFactory.createDisplayImage(1,"myProfileImage");

    private User user1 = UserFactory.buildUser("123", "ColourStrings", "Strings",
            "thato@gmail.com", "Thato", "Mokoena", "male", "image");

    private User user2 = UserFactory.buildUser("321", "Nicky", "m!m1",
            "nicky@gmail.com", "Lannike", "Msitho", "FEMALE", "image");

    private Location location = LocationFactory.createLocation("Cape Town",
            "Western Cape", "ParkLands");

    private Preference preference1 = PreferenceFactory.buildPreference(7,"20-30",
            "10km", Gender.MALE);

    private Preference preference2 = PreferenceFactory.buildPreference(1,"20-30",
            "10km", Gender.MALE);

    private Like likes = LikeFactory.buildLike("3", "8", "4", LocalDateTime.now());

    private UserProfile profile1 = UserprofileFactory.createUser("123", user1,
            "Movies, Anime, Video Games", true, LocalDateTime.now(),location, preference1, likes);

    private UserProfile profile2 = UserprofileFactory.createUser("321", user2,
            "Movies, Soccer, Video Games", true, LocalDateTime.now(),location, preference2, likes);

    private Match match = MatchFactory.buildMatch(1, profile1, profile2);

    @Test
    void a_create() {
        String url = "http://localhost:8080/cupidscorner/preference";
        ResponseEntity<Preference> response = restTemplate.postForEntity(url, preference1, Preference.class);
        assertNotNull(response);
        assertNotNull(response.getBody());
        Preference preferenceSaved = response.getBody();
        assertEquals(preference1.getPreferenceId(), preferenceSaved.getPreferenceId());
        System.out.println("Preference created: " + preferenceSaved);
    }

    @Test
    void b_read() {
        String url = BASE_URL + "/read/" + preference1.getPreferenceId();
        System.out.println("URL: " + url);
        ResponseEntity<Preference> postMatch = restTemplate.getForEntity(url, Preference.class);
        assertEquals(preference1.getPreferenceId(), postMatch.getBody().getPreferenceId());
        System.out.println("Read: " + postMatch.getBody());
    }

    @Test
    void c_update() {
        String url = BASE_URL + "/read/" + preference1.getPreferenceId();

        Preference newPreference = new Preference.Builder().copy(preference1.getProfile().getPreferenceID())
                .setDistance("25km-30km").build();

        ResponseEntity<Preference> postPreference = restTemplate.postForEntity(url, newPreference, Preference.class);
        assertNotNull(postPreference);
        assertNotNull(postPreference.getBody());
        Preference preferenceUpdated = postPreference.getBody();
        assertEquals(newPreference.getProfile(), preferenceUpdated.getPreferenceId());
        System.out.println("Update Preference: " + postPreference.getBody());
    }

    @Test
    void e_delete() {
        String url = BASE_URL + "/delete/" + preference1.getPreferenceId();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
        System.out.println("Success: preference removed");
    }

    @Test
    void d_getAll() {
        String url = BASE_URL + "/getall";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Long> entity = new HttpEntity<>(headers);
        ResponseEntity<Long> response = restTemplate.exchange(url, HttpMethod.GET, entity, Long.class);
        System.out.println("Get All Employee: ");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}