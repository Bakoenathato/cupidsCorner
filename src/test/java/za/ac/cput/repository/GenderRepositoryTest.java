package za.ac.cput.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import za.ac.cput.domain.Gender;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class GenderRepositoryTest {

    @Autowired
    private GenderRepository repository;

    @Test
    public void testCreateGender() {
        Gender gender = new Gender.Builder()
                .setGenderId(1L)
                .setDescription("Male")
                .build();

        Gender savedGender = repository.save(gender);
        assertNotNull(savedGender);
        assertEquals(gender.getGenderId(), savedGender.getGenderId());
    }

    @Test
    public void testReadGender() {
        Gender gender = new Gender.Builder()
                .setGenderId(2L)
                .setDescription("Female")
                .build();

        repository.save(gender);

        Optional<Gender> foundGender = repository.findById(2L);
        assertTrue(foundGender.isPresent());
        assertEquals(gender.getDescription(), foundGender.get().getDescription());
    }

    @Test
    public void testUpdateGender() {
        Gender gender = new Gender.Builder()
                .setGenderId(3L)
                .setDescription("Non-Binary")
                .build();

        repository.save(gender);

        Gender updatedGender = new Gender.Builder()
                .copy(gender)
                .setDescription("Updated Description")
                .build();

        Gender savedUpdatedGender = repository.save(updatedGender);
        assertEquals("Updated Description", savedUpdatedGender.getDescription());
    }

    @Test
    public void testDeleteGender() {
        Gender gender = new Gender.Builder()
                .setGenderId(4L)
                .setDescription("To Be Deleted")
                .build();

        repository.save(gender);
        repository.deleteById(4L);

        Optional<Gender> deletedGender = repository.findById(4L);
        assertFalse(deletedGender.isPresent());
    }

    @Test
    public void testGetAllGenders() {
        Gender gender1 = new Gender.Builder()
                .setGenderId(5L)
                .setDescription("Gender 1")
                .build();

        Gender gender2 = new Gender.Builder()
                .setGenderId(6L)
                .setDescription("Gender 2")
                .build();

        repository.save(gender1);
        repository.save(gender2);

        List<Gender> genders = repository.findAll();
        assertEquals(2, genders.size());
    }
}