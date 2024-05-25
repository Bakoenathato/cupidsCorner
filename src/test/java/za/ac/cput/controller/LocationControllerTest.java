package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Location;
import za.ac.cput.factory.LocationFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.MethodName.class)
class LocationControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private final String BASE_URL = "http://localhost:8080/cupidsCorner";

    private static Location location;

    @BeforeAll
    public static void setup() {
        location = LocationFactory.buildLocation(12345L, "City", "Province", "Area");
    }

    @Test
    void a_create() {
        String url = BASE_URL + "/create";
        ResponseEntity<Location> postResponse = restTemplate.postForEntity(url, location, Location.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Location createdLocation = postResponse.getBody();
        assertEquals(location.getPostalCode(), createdLocation.getPostalCode());
        System.out.println("Created location: " + createdLocation);
    }

    @Test
    void b_read() {
        String url = BASE_URL + "/read/" + location.getPostalCode();
        ResponseEntity<Location> getResponse = restTemplate.getForEntity(url, Location.class);
        assertEquals(location.getPostalCode(), getResponse.getBody().getPostalCode());
        System.out.println("Read location: " + getResponse.getBody());
    }

    @Test
    void c_update() {
        String url = BASE_URL + "/update";
        Location updatedLocation = new Location.Builder().copy(location).setCity("UpdatedCity").build();
        ResponseEntity<Location> postResponse = restTemplate.postForEntity(url, updatedLocation, Location.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Location updatedLocationResponse = postResponse.getBody();
        assertEquals(location.getPostalCode(), updatedLocationResponse.getPostalCode());
        System.out.println("Updated location: " + updatedLocationResponse);
    }

    @Test
    void d_delete() {
        String url = BASE_URL + "/delete/" + location.getPostalCode();
        restTemplate.delete(url);
        System.out.println("Deleted location with postalCode: " + location.getPostalCode());
    }

    @Test
    void e_getAll() {
        String url = BASE_URL + "/getall";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Get All Locations: ");
        System.out.println(response.getBody());
    }
}