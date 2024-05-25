package za.ac.cput.controller;
/* NotificationControllerTest.java
NotificationControllerTest Class
Author: Leonard Gabriel Langa (221069054)
Date: 26 May 2024
*/

import org.junit.jupiter.api.*;
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

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class NotificationControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    private final String BASE_URL = "http://localhost:8080/cupidsCorner_ADP372S_Capstone_Assignment/notification";

    private DisplayImage image = DisplayImageFactory.createDisplayImage(1L,"myProfileImage");

    private User user = UserFactory.buildNewUser("322", "Leon225", "Langa@02",
            "221069054@mycput.ac.za", "Leonard", "Langa", Gender.MALE, image);

    private Location location = LocationFactory.createLocation(2L,"Cape Town",
            "Western Cape", "WoodStock", 1800);

    private Preference preference = PreferenceFactory.buildPreference(3,"20-30",
            "10km", Gender.FEMALE.toString());

    private Like likes = LikeFactory.buildLike("4", LocalDateTime.now());

    private UserProfile userProfile = UserprofileFactory.createUserProfile("232", user,
            "Movies, Soccer, Video Games", true, LocalDateTime.now(),location, preference, likes);

    private Notification notification = NotificationFactory.buildNotification(121L,
            "You received a like from user123", NotificationType.SMS, userProfile);

    @Test
    @Order(1)
    void create() {
        String url = BASE_URL + "/create";
        ResponseEntity<Notification> postResponse = testRestTemplate.postForEntity(url, notification, Notification.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        Notification notificationSaved = postResponse.getBody();
        assertEquals(notification.getNotificationId(), notificationSaved.getNotificationId());
        System.out.println("Saved data: " + notificationSaved);

    }

    @Test
    @Order(2)
    void read() {
        String url = BASE_URL + "/read/" + notification.getNotificationId();

        ResponseEntity<Notification> getResponse = testRestTemplate.getForEntity(url, Notification.class);
        assertEquals(notification.getNotificationId(), getResponse.getBody().getNotificationId());
        System.out.println("Read: " + getResponse.getBody());

    }

    @Test
    @Order(3)
    void update() {
        String url = BASE_URL + "/update";
        UserProfile newUserProfile = new UserProfile.Builder().copy(notification.getUserProfile())
                .setInterests("Mountain Biking, Swimming").build();
        Notification editedNotification = new Notification.Builder().copy(notification)
                .setUserProfile(newUserProfile).build();
        ResponseEntity<Notification> postResponse = testRestTemplate.postForEntity(url, editedNotification, Notification.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        Notification employeeUpdated = postResponse.getBody();
        assertEquals(editedNotification.getNotificationId(), employeeUpdated.getNotificationId());
        System.out.println("Updated data: " + employeeUpdated);

    }

    @Test
    @Order(4)
    void delete(){
        String url = BASE_URL + "/delete/" + notification.getNotificationId();
        System.out.println("URL: " + url);
        testRestTemplate.delete(url);
        System.out.println("Success: Deleted contact");
    }

    @Test
    @Order(5)
    void getAll() {
        String url = BASE_URL + "/getall";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> getResponse = testRestTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show ALL:");
        System.out.println(getResponse);
        System.out.println(getResponse.getBody());
    }
}