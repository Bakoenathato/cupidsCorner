package za.ac.cput.factory;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.*;

import java.time.LocalDateTime;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class NotificationFactoryTest {

    private  DisplayImage image = DisplayImageFactory.createDisplayImage(1L,"myProfileImage");
    private User user = UserFactory.buildNewUser("322", "Leon225", "Langa@02",
            "221069054@mycput.ac.za", "Leonard", "Langa", Gender.MALE, image);
    private Location location = LocationFactory.createLocation(2L,"Cape Town",
            "Western Cape", "WoodStock", 1800);
    private Preference preference = PreferenceFactory.buildPreference(3,"20-30",
            "10km", Gender.FEMALE.toString());
    private Like likes = LikeFactory.buildLike("4", LocalDateTime.now());
    private UserProfile userProfile = UserprofileFactory.createUserProfile("232", user,
            "Movies, Soccer, Video Games", true, LocalDateTime.now(),location, preference, likes);

    @Test
    @Order(1)
    void testBuildNotification1() {
        Notification notification = NotificationFactory.buildNotification(121L,
                "You received a like from user123", NotificationType.SMS, userProfile);
        assertNotNull(notification);
        System.out.println(notification);
    }

    @Test
    @Order(2)
    void testBuildNotification1WithFail() {
        Notification notification = NotificationFactory.buildNotification(0,
                "You received a like from user123", NotificationType.SMS, userProfile);
        assertNotNull(notification);
        System.out.println(notification);
    }


}