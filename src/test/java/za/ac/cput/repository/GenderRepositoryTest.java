package za.ac.cput.repository;

import org.junit.jupiter.api.*;
import za.ac.cput.domain.Gender;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class GenderRepositoryTest {

    private final GenderRepository genderRepository = new GenderRepository();

    private final Gender gender = new Gender.Builder()
            .setGenderId("1")
            .setDescription("Male")
            .build();

    @Test
    @Order(1)
    void create() {
        Gender createdGender = genderRepository.create(gender);
        assertNotNull(createdGender);
        assertEquals(gender, createdGender);
        System.out.println("Created Gender: " + createdGender);
    }

    @Test
    @Order(2)
    void read() {
        Gender readGender = genderRepository.read("1");
        assertNotNull(readGender);
        assertEquals(gender, readGender);
        System.out.println("Read Gender: " + readGender);
    }

    @Test
    @Order(3)
    void update() {
        Gender updatedGender = new Gender.Builder()
                .setGenderId("1")
                .setDescription("Female")
                .build();

        Gender updated = genderRepository.update(updatedGender);
        assertNotNull(updated);
        assertEquals(updatedGender, updated);
        System.out.println("Updated Gender: " + updated);
    }

    @Test
    @Order(4)
    void getAll() {
        List<Gender> allGenders = genderRepository.getAll();
        assertNotNull(allGenders);
        assertFalse(allGenders.isEmpty());
        System.out.println("All Genders: " + allGenders);
    }

    @Test
    @Order(5)
    void delete() {
        assertTrue(genderRepository.delete("1"));
        assertNull(genderRepository.read("1"));
        System.out.println("Success: Gender deleted");
    }
}