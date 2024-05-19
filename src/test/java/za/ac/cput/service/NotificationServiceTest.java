package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.*;
import za.ac.cput.factory.*;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class NotificationServiceTest {

    @Autowired
    NotificationService notificationService;
    private DisplayImage image = DisplayImageFactory.createDisplayImage(1L,"myProfileImage");

    private User user = UserFactory.buildNewUser("322", "Leon225", "Langa@02",
            "221069054@mycput.ac.za", "Leonard", "Langa", Gender.MALE, image);

    private Location location = LocationFactory.createLocation(2L,"Cape Town",
            "Western Cape", "WoodStock", 1800);

    private Preference preference = PreferenceFactory.buildPreference(3,"20-30",
            "10km", Gender.FEMALE.toString());

    private Like likes = LikeFactory.buildLike("4", LocalDateTime.now());

    private UserProfile userProfile = UserprofileFactory.createUserProfile("232", user,
            "Movies, Soccer, Video Games", true, LocalDateTime.now(),location, preference, likes);

    private Notification notification = NotificationFactory.buildNotification(121L,
            "You received a like from user123", NotificationType.SMS, userProfile);

    @Test
    @Order(1)
    void create() {
        Notification created = notificationService.create(notification);
        assertNotNull(created);
        System.out.println(created);
    }

    @Test
    @Order(2)
    void read() {
        Notification read = notificationService.read(notification.getNotificationId());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    @Order(3)
    void update() {
        Notification newNotification = new Notification.Builder().copy(notification)
                .setType(NotificationType.EMAIL)
                .build();
        Notification updated = notificationService.update(newNotification);
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    @Order(4)
    void delete() {
        notificationService.delete(notification.getNotificationId());
    }

    @Test
    @Order(5)
    void getAll() {
        System.out.println(notificationService.getAll());
    }
}