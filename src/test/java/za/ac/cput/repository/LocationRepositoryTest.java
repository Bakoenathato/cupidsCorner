package za.ac.cput.repository;

/* LocationRepositoryTest.java
   LocationRepositoryTest class
   Author: Uzzaih Phumelela Ngogela 222135654
   Date: 26 March 2024
*/

import org.junit.jupiter.api.*;
import za.ac.cput.domain.Location;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class LocationRepositoryTest {

    private final ILocationRepository locationRepository = LocationRepository.getRepository();

    private Location location = new Location.Builder()
            .setCity("Cape Town")
            .setProvince("Western Cape")
            .setArea("Bellville")
            .build();

    @Test
    @Order(1)
    void create() {
        Location created = locationRepository.create(location);
        assertNotNull(created);
        assertEquals(location, created);
        System.out.println(created);
    }

    @Test
    @Order(2)
    void read() {
        Location readLocation = locationRepository.read("Cape Town");
        assertNotNull(readLocation);
        assertEquals(location, readLocation);
        System.out.println(readLocation);
    }

    @Test
    @Order(3)
    void update() {
        Location updatedLocation = new Location.Builder()
                .setCity("Cape Town")
                .setProvince("Western Cape")
                .setArea("Langa")
                .build();

        Location updated = locationRepository.update(updatedLocation);
        assertNotNull(updated);
        assertEquals(updatedLocation, updated);
        System.out.println(updated);
    }

//    @Test
//    @Order(4)
//    void getAll() {
//        /*List<Location> allLocations = locationRepository.getAll();
//        assertNotNull(allLocations);
//        assertTrue(allLocations.contains(location));
//        System.out.println(allLocations);*/
//            System.out.println(repository.getAll());
//    }

    @Test
    @Order(4)
   void getAll() {
        System.out.println(locationRepository.getAll());
    }

    @Test
    @Order(5)
    void delete() {
        assertTrue(locationRepository.delete("Cape Town"));
        assertNull(locationRepository.read("Cape Town"));
        System.out.println("Success: Location deleted");
    }
}