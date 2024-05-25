package za.ac.cput.factory;

/* LocationFactoryTest.java
   LocationFactoryTest class
   Author: Uzzaih Phumelela Ngogela 222135654
   Date: 26 March 2024
*/

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Location;

import static org.junit.jupiter.api.Assertions.*;

class LocationFactoryTest {

    @Test
    void testCreateLocation() {
        Location location = LocationFactory.createLocation("Cape Town", "Western Cape", "Bellville");
        assertNotNull(location);
        assertEquals("Cape Town", location.getCity());
        assertEquals("Western Cape", location.getProvince());
        assertEquals("Bellville", location.getCity());
    }

    @Test
    void testCreateLocationWithEmptyValues() {
        Location location = LocationFactory.createLocation("", "", "");
        assertNull(location);
    }

    @Test
    void testCreateLocationWithNullValues() {
        Location location = LocationFactory.createLocation(null, null, null);
        assertNull(location);
    }
}