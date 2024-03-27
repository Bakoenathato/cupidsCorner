package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.User;
import za.ac.cput.util.Helper;

import static org.junit.jupiter.api.Assertions.*;
/*UserFactoryTest.java
UserFactoryTest class
Author Mihle Sivuyise Bontsi (222406917)
Date: 27 March 2024
 */

class UserFactoryTest {


    @Test
    void buildUser() {
        User user = UserFactory.buildUser("123", "mihlebonts99@gmail.com", "sivu55");
        assertNotNull(user);
        System.out.println(user);
    }

    @Test
    void testBuildUserWithFail() {
        User user = UserFactory.buildUser("mihlebontsi99@gmail.com", "sivu55");
        assertNotNull(user);
        System.out.println(user);
    }
}