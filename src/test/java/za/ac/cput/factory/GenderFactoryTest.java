package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Gender;
import za.ac.cput.util.Helper;

import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

class GenderFactoryTest {

    private Gender gender;

    @BeforeEach
    void setUp() {
        gender = GenderFactory.buildGender("11", "Male");
    }

    @Test
    void testBuildGenderWithParams() {
        assertNotNull(gender);
        assertEquals("11", gender.getGenderId());
        assertEquals("Male", gender.getDescription());
    }

    @Test
    void testBuildGenderWithRandomValues() {
        Gender randomGender = GenderFactory.buildGender(" ", " ");
        assertNotNull(randomGender);
        assertNotNull(randomGender.getGenderId());
        assertNotNull(randomGender.getDescription());
    }

    @Test
    void testBuildGenderWithNullId() {
        Gender nullIdGender = GenderFactory.buildGender(null, "Female");
        assertNull(nullIdGender);
    }

    @Test
    void testBuildGenderWithNullDescription() {
        Gender nullDescGender = GenderFactory.buildGender("22", null);
        assertNull(nullDescGender);
    }

    @Test
    void testBuildGenderWithEmptyValues() {
        Gender emptyValuesGender = GenderFactory.buildGender("", "");
        assertNull(emptyValuesGender);
    }
}