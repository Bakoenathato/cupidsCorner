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
import za.ac.cput.domain.DisplayImage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DisplayImageControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/cupidsCorner_ADP372S_Capstone_Assignment/displayimage";

    private static DisplayImage displayImage;

    @BeforeAll
    public static void setup() {
        displayImage = DisplayImageFactory.buildDisplayImage(5, "microsoft");

    }

    @Test
    void a_create() {
        String url = BASE_URL + "/create";
        ResponseEntity<DisplayImage> postResponse = restTemplate.postForEntity(url, displayImage, DisplayImage.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        //assertEquals(postResponse.getStatusCode(), HttpStatus.OK);
        DisplayImage displayImageSaved = postResponse.getBody();
        assertNotNull(displayImage.getDisplayImageId(), displayImageSaved.getDisplayImageID());
        System.out.println("Saved data: " + displayImageSaved);
    }

    @Test
    void b_read() {
        String url = BASE_URL + "/read" + displayImage.getDisplayImageId();
        System.out.println("URL: " + url);
        ResponseEntity<DisplayImage> response = restTemplate.getForEntity(url, DisplayImage.class);
        assertEquals(displayImage.getDisplayImageId(), response.getBody().getDisplayImageId());
        System.out.println("Read: " + response.getBody());
    }

    @Test
    void c_update(){
        String url = BASE_URL + "/update";
        DisplayImage newDisplayImage = new DisplayImage.Builder().copy(displayImage).setImage("microsoft2").build();
        ResponseEntity<DisplayImage> postResponse = restTemplate.postForEntity(url, newDisplayImage, DisplayImage.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        DisplayImage displayImageUpdated = postResponse.getBody();
        assertEquals(newDisplayImage.getDisplayImageId(), displayImageUpdated.getDisplayImageId());
        System.out.println("Updated data: " + displayImageUpdated);
    }

    @Test
    void d_delete(){
        String url = BASE_URL + "/delete" + displayImage.getDisplayImageId();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
        System.out.println("Success: Deleted displayImage");
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