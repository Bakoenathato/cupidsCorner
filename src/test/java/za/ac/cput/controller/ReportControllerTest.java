package za.ac.cput.controller;
/* ReportControllerTest.java
ReportControllerTest Class
Author: Leonard Gabriel Langa (221069054)
Date: 26 May 2024
*/

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
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

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ReportControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    private final String BASE_URL = "http://localhost:8080/cupidsCorner_ADP372S_Capstone_Assignment/report";

    private DisplayImage image1 = DisplayImageFactory.createDisplayImage(1L,"myProfileImage1");
    private User user1 = UserFactory.buildNewUser("322", "Leon225", "Langa@02",
            "221069054@mycput.ac.za", "Leonard", "Langa", Gender.MALE, image1);
    private Location location1 = LocationFactory.createLocation(2L,"Cape Town",
            "Western Cape", "WoodStock", 1800);
    private Preference preference1 = PreferenceFactory.buildPreference(3,"20-30",
            "10km", Gender.FEMALE.toString());
    private Like likes1 = LikeFactory.buildLike("4", LocalDateTime.now());
    private UserProfile userProfileReporter = UserprofileFactory.createUserProfile("232", user1,
            "Movies, Soccer, Video Games", true, LocalDateTime.now(),location1, preference1, likes1);
    // End of UserProfile 1


    // UserProfile 2
    private DisplayImage image2 = DisplayImageFactory.createDisplayImage(2L,"myProfileImage2");
    private User user2 = UserFactory.buildNewUser("323", "GhostRider77", "Ghost@225",
            "lindastevenson97@gmail.com", "Linda", "Stevenson", Gender.FEMALE, image2);
    private Location location2 = LocationFactory.createLocation(2L,"Cape Town",
            "Western Cape", "WoodStock", 1800);
    private Preference preference2 = PreferenceFactory.buildPreference(3,"20-30",
            "10km", Gender.MALE.toString());
    private Like likes2 = LikeFactory.buildLike("5", LocalDateTime.now());
    private UserProfile userProfileReported = UserprofileFactory.createUserProfile("231", user2,
            "Swimming, Biking, Weight Lifting", true, LocalDateTime.now(), location2, preference2, likes2);

    private Report report = ReportFactory.buildReport(500L,"In appropriate comments", LocalDateTime.now(),
            userProfileReporter, userProfileReported);

    @Test
    @Order(1)
    void create() {
        String url = BASE_URL + "/create";
        ResponseEntity<Report> postResponse = testRestTemplate.postForEntity(url, report, Report.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        Report reportSaved = postResponse.getBody();
        assertEquals(report.getReportId(), reportSaved.getReportId());
        System.out.println("Saved data: " + reportSaved);

    }

    @Test
    @Order(2)
    void read() {
        String url = BASE_URL + "/read/" + report.getReportId();

        ResponseEntity<Report> getResponse = testRestTemplate.getForEntity(url, Report.class);
        assertEquals(report.getReportId(), getResponse.getBody().getReportId());
        System.out.println("Read: " + getResponse.getBody());

    }

    @Test
    @Order(3)
    void update() {
        String url = BASE_URL + "/update";
        Report newReport = new Report.Builder().copy(report)
                .setReason("Sending Inappropriate Images").build();
        ResponseEntity<Report> postResponse = testRestTemplate.postForEntity(url, newReport, Report.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        Report reportUpdated = postResponse.getBody();
        assertEquals(newReport.getReportId(), reportUpdated.getReportId());
        System.out.println("Updated data: " + reportUpdated);

    }

    @Test
    @Order(4)
    void delete(){
        String url = BASE_URL + "/delete/" + report.getReportId();
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