package za.ac.cput.factory;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.*;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ReportFactoryTest {

    // UserProfile 1
    private DisplayImage image1 = DisplayImageFactory.createDisplayImage(1L,"myProfileImage1");
    private User user1 = UserFactory.buildNewUser("322", "Leon225", "Langa@02",
            "221069054@mycput.ac.za", "Leonard", "Langa", Gender.MALE, image1);
    private Location location1 = LocationFactory.createLocation(2L,"Cape Town",
            "Western Cape", "WoodStock", 1800);
    private Preference preference1 = PreferenceFactory.buildPreference(3,"20-30",
            "10km", Gender.FEMALE.toString());
    private Like likes1 = LikeFactory.buildLike("4", LocalDateTime.now());
    private UserProfile userProfileReporter = UserprofileFactory.createUserProfile("232", user1,
            "Movies, Soccer, Video Games", true, LocalDateTime.now(),location1, preference1, likes1);
    // End of UserProfile 1


    // UserProfile 2

    private DisplayImage image2 = DisplayImageFactory.createDisplayImage(2L,"myProfileImage2");
    private User user2 = UserFactory.buildNewUser("323", "GhostRider77", "Ghost@225",
            "lindastevenson97@gmail.com", "Linda", "Stevenson", Gender.FEMALE, image2);
    private Location location2 = LocationFactory.createLocation(2L,"Cape Town",
            "Western Cape", "WoodStock", 1800);
    private Preference preference2 = PreferenceFactory.buildPreference(3,"20-30",
            "10km", Gender.MALE.toString());
    private Like likes2 = LikeFactory.buildLike("5", LocalDateTime.now());
    private UserProfile userProfileReported = UserprofileFactory.createUserProfile("231", user2,
            "Swimming, Biking, Weight Lifting", true, LocalDateTime.now(), location2, preference2, likes2);

    // End of UserProfile 2
    @Test
    @Order(1)
    void testBuildReport() {
        Report report = ReportFactory.buildReport(500L,"In appropriate comments", LocalDateTime.now(),
                userProfileReporter, userProfileReported);
        assertNotNull(report);
        System.out.println(report);
    }

    @Test
    @Order(2)
    void testBuildReportWithFail() {
        Report report = ReportFactory.buildReport(0,"In appropriate comments", LocalDateTime.now(),
                userProfileReporter, userProfileReported);
        assertNotNull(report);
        System.out.println(report);
    }
}