package za.ac.cput.controller;
/*
    MatchingControllerTest.java
    MatchingControllerTest class
    Author: Thato Mokoena (222667087)
    Date 25 May 2024
*/

import org.glassfish.jaxb.runtime.v2.runtime.output.SAXOutput;
import org.junit.jupiter.api.Disabled;
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
class MatchControllerTest {

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
        String url = "http://localhost:8080/cupidscorner/match";
        ResponseEntity<Match> response = restTemplate.postForEntity(url, match, Match.class);
        assertNotNull(response);
        assertNotNull(response.getBody());
        Match matchSaved = response.getBody();
        assertEquals(match.getMatchId(), matchSaved.getMatchId());
        System.out.println("Match created: " + matchSaved);
    }

    @Test
    void b_read() {
        String url = BASE_URL + "/read/" + match.getMatchId();
        System.out.println("URL: " + url);
        ResponseEntity<Match> postMatch = restTemplate.getForEntity(url, Match.class);
        assertEquals(match.getMatchId(), postMatch.getBody().getMatchId());
        System.out.println("Read: " + postMatch.getBody());
    }

    @Test
    void c_update() {
        String url = BASE_URL + "/update";

        UserProfile newUserProfile = new UserProfile.Builder().copy(match.getProfile1()).setProfile_visibility(false)
                .build();

        Match editMatch = new Match.Builder().copy(match).setProfile1(newUserProfile).build();

        ResponseEntity<Match> postResponse = restTemplate.postForEntity(url, editMatch, Match.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Match matchUpdated = postResponse.getBody();
        assertEquals(newUserProfile.getProfileID(), matchUpdated.getMatchId());
        System.out.println("Updated match: " + matchUpdated);
    }


    @Test
    void e_delete() {
        String url = BASE_URL + "/delete/" + match.getMatchId();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
        System.out.println("Success: profile Hidden");
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