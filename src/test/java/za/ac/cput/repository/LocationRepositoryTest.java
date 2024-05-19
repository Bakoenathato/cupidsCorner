package za.ac.cput.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import za.ac.cput.domain.Location;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class LocationRepositoryTest {

    @Autowired
    private LocationRepository repository;

    @Test
    public void testCreateLocation() {
        Location location = new Location.Builder()
                .setPostalCode(7700)
                .setCity("Cape Town")
                .setProvince("Western Cape")
                .setArea("Central")
                .build();

        Location savedLocation = repository.save(location);
        assertNotNull(savedLocation);
        assertEquals(location.getPostalCode(), savedLocation.getPostalCode());
    }

    @Test
    public void testReadLocation() {
        Location location = new Location.Builder()
                .setPostalCode(4311)
                .setCity("Johannesburg")
                .setProvince("Gauteng")
                .setArea("Sandton")
                .build();

        repository.save(location);

        Optional<Location> foundLocation = repository.findById(67890L);
        assertTrue(foundLocation.isPresent());
        assertEquals(location.getCity(), foundLocation.get().getCity());
    }

    @Test
    public void testUpdateLocation() {
        Location location = new Location.Builder()
                .setPostalCode(54321L)
                .setCity("Durban")
                .setProvince("KwaZulu-Natal")
                .setArea("Beachfront")
                .build();

        repository.save(location);

        Location updatedLocation = new Location.Builder()
                .copy(location)
                .setCity("Updated City")
                .build();

        Location savedUpdatedLocation = repository.save(updatedLocation);
        assertEquals("Updated City", savedUpdatedLocation.getCity());
    }

    @Test
    public void testDeleteLocation() {
        Location location = new Location.Builder()
                .setPostalCode(4311)
                .setCity("Pretoria")
                .setProvince("Gauteng")
                .setArea("Arcadia")
                .build();

        repository.save(location);
        repository.deleteById(4311);

        Optional<Location> deletedLocation = repository.findById(98765L);
        assertFalse(deletedLocation.isPresent());
    }

    @Test
    public void testGetAllLocations() {
        Location location1 = new Location.Builder()
                .setPostalCode(1111)
                .setCity("Johannesburg")
                .setProvince("Gauteng")
                .setArea("Daveyton")
                .build();

        Location location2 = new Location.Builder()
                .setPostalCode(7041)
                .setCity("Port Elizabeth")
                .setProvince("Eastern Cape")
                .setArea("Summerstrand")
                .build();

        repository.save(location1);
        repository.save(location2);

        List<Location> locations = repository.findAll();
        assertEquals(2, locations.size());
    }
}