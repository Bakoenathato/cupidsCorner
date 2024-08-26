package za.ac.cput.testData;

import za.ac.cput.domain.DisplayImage;
import za.ac.cput.domain.Gender;
import za.ac.cput.domain.User;
import za.ac.cput.factory.DisplayImageFactory;
import za.ac.cput.factory.UserFactory;

public class UserTestData {
    public static User getTestUser1() {
        // display image
        DisplayImage displayImage = DisplayImageFactory.createDisplayImage(new byte[0]);

        // return user obj
        return UserFactory.buildUser(
                "RainBow-",
                "1stSonicBoom",
                "dash.boom@pony.com",
                "Rainbow",
                "Dash",
                Gender.FEMALE,
                displayImage
        );
    }

    public static User getTestUser2() {
        // display image
        DisplayImage displayImage = DisplayImageFactory.createDisplayImage(new byte[0]);

        // return user obj
        return UserFactory.buildUser(
                "StarGazer-",
                "2ndSonicWave",
                "star.gazer@universe.com",
                "Luna",
                "Star",
                Gender.FEMALE,
                displayImage
        );
    }

    public static User getTestUser3() {
        // display image
        DisplayImage displayImage = DisplayImageFactory.createDisplayImage(new byte[0]);

        // return user obj
        return UserFactory.buildUser(
                "OceanWaves-",
                "3rdSonicSplash",
                "ocean.waves@sea.com",
                "Nemo",
                "Wave",
                Gender.MALE,
                displayImage
        );
    }

    public static User getTestUser4() {
        // display image
        DisplayImage displayImage = DisplayImageFactory.createDisplayImage(new byte[0]);

        // return user obj
        return UserFactory.buildUser(
                "MountainClimber-",
                "4thSonicPeak",
                "mountain.climber@adventure.com",
                "Rocky",
                "Climb",
                Gender.MALE,
                displayImage
        );
    }

    public static User getTestUser5() {
        // display image
        DisplayImage displayImage = DisplayImageFactory.createDisplayImage(new byte[0]);

        // return user obj
        return UserFactory.buildUser(
                "ForestExplorer-",
                "5thSonicTrail",
                "forest.explorer@nature.com",
                "Fern",
                "Green",
                Gender.FEMALE,
                displayImage
        );
    }

}
