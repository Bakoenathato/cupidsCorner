package za.ac.cput.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.*;
import za.ac.cput.factory.*;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class MatchServiceTest {

    @Autowired
    private MatchService matchService;


    private DisplayImage image = DisplayImageFactory.createDisplayImage(1,"myProfileImage");

    private User user1 = UserFactory.buildUser("123", "ColourStrings", "Strings",
            "thato@gmail.com", "Thato", "Mokoena", "male", "image");

    private User user2 = UserFactory.buildUser("321", "Nicky", "m!m1",
            "nicky@gmail.com", "Lannike", "Msitho", "FEMALE", "image");

    private Location location = LocationFactory.createLocation("Cape Town",
            "Western Cape", "ParkLands");

    private Preference preference1 = PreferenceFactory.buildPreference(7,"20-30",
            "10km", Gender.MALE);

    private Preference preference2 = PreferenceFactory.buildPreference(1,"20-30",
            "10km", Gender.MALE);

    private Like likes = LikeFactory.buildLike("3", "8", "4", LocalDateTime.now());

    private UserProfile profile1 = UserprofileFactory.createUser("123", user1,
            "Movies, Anime, Video Games", true, LocalDateTime.now(),location, preference1, likes);

    private UserProfile profile2 = UserprofileFactory.createUser("321", user2,
            "Movies, Soccer, Video Games", true, LocalDateTime.now(),location, preference2, likes);

    private Match match = MatchFactory.buildMatch(1, profile1, profile2);


    @Test
    void a_create() {
        Match createdMatch = matchService.create(match);
        assertNotNull(createdMatch);
        System.out.println(createdMatch);
    }

    @Test
    void b_read() {
        Match readMatch = matchService.read(match.getMatchId());
        assertNotNull(readMatch);
        System.out.println(readMatch);
    }

    @Test
    void c_update() {
        Match newMatch = new Match.Builder().copy(match)
                .setMatchId(3)
                .build();
        Match updatedMatch = matchService.update(newMatch);
        assertNotNull(updatedMatch);
        System.out.println(updatedMatch);
    }

    @Test
    void d_getAll() {
        System.out.println(matchService.getAll());
    }
}