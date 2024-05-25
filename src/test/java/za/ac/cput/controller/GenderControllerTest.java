package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Gender;
import za.ac.cput.factory.GenderFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.MethodName.class)
class GenderControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private final String BASE_URL = "http://localhost:8080/gender";

    private static Gender gender;

    @BeforeAll
    public static void setup() {
        gender = GenderFactory.buildGender(1L, "Male");
    }

    @Test
    void a_create() {
        String url = BASE_URL + "/create";
        ResponseEntity<Gender> postResponse = restTemplate.postForEntity(url, gender, Gender.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Gender createdGender = postResponse.getBody();
        assertEquals(gender.getGenderId(), createdGender.getGenderId());
        System.out.println("Created gender: " + createdGender);
    }

    @Test
    void b_read() {
        String url = BASE_URL + "/read/" + gender.getGenderId();
        ResponseEntity<Gender> getResponse = restTemplate.getForEntity(url, Gender.class);
        assertEquals(gender.getGenderId(), getResponse.getBody().getGenderId());
        System.out.println("Read gender: " + getResponse.getBody());
    }

    @Test
    void c_update() {
        String url = BASE_URL + "/update";
        Gender updatedGender = new Gender.Builder().copy(gender).setDescription("UpdatedMale").build();
        ResponseEntity<Gender> postResponse = restTemplate.postForEntity(url, updatedGender, Gender.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Gender updatedGenderResponse = postResponse.getBody();
        assertEquals(gender.getGenderId(), updatedGenderResponse.getGenderId());
        System.out.println("Updated gender: " + updatedGenderResponse);
    }

    @Test
    void d_delete() {
        String url = BASE_URL + "/delete/" + gender.getGenderId();
        restTemplate.delete(url);
        System.out.println("Deleted gender with id: " + gender.getGenderId());
    }

    @Test
    void e_getAll() {
        String url = BASE_URL + "/getall";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Get All Genders: ");
        System.out.println(response.getBody());
    }
}