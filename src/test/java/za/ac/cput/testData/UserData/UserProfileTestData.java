package za.ac.cput.testData.UserData;

import za.ac.cput.domain.*;
import za.ac.cput.factory.UserprofileFactory;
import za.ac.cput.util.Helper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;

import static za.ac.cput.testData.UserData.LocationTestData.*;
import static za.ac.cput.testData.UserData.PreferenceTestData.*;
import static za.ac.cput.testData.UserTestData.*;

public class UserProfileTestData {

    public static UserProfile getTestUserProfile1() {
        User user1 = getTestUser1();
        Preference preference1 = geTestPreference1();
        Location location1 = getLocationTestData1();

        return UserprofileFactory.createUserProfile(
                Helper.generateId(),
                user1,
                "Cooking & Baking",
                true,
                LocalDateTime.now(),
                location1,
                preference1,
                new HashSet<>(), // likes
                new HashSet<>(), // match request
                new HashSet<>(), // match accepted
                new ArrayList<>() // Swipes
        );
    }

    public static UserProfile getTestUserProfile2() {
        User user2 = getTestUser2();
        Preference preference2 = getTestPreference2();
        Location location2 = getLocationTestData2();

        return UserprofileFactory.createUserProfile(
                Helper.generateId(),
                user2,
                "Mountain Biking & photography",
                true,
                LocalDateTime.now(),
                location2,
                preference2,
                new HashSet<>(), // likes
                new HashSet<>(), // match request
                new HashSet<>(), // match accepted
                new ArrayList<>() // Swipes
        );
    }

    public static UserProfile getTestUserProfile3() {
        User user3 = getTestUser3();
        Preference preference3 = getTestPreference3();
        Location location3 = getLocationTestData3();

        return UserprofileFactory.createUserProfile(
                Helper.generateId(),
                user3,
                "Traveling",
                true,
                LocalDateTime.now(),
                location3,
                preference3,
                new HashSet<>(), // likes
                new HashSet<>(), // match request
                new HashSet<>(), // match accepted
                new ArrayList<>() // Swipes
        );
    }

    public static UserProfile getTestUserProfile4() {
        User user4 = getTestUser4();
        Preference preference4 = getTestPreference4();
        Location location4 = getLocationTestData4();

        return UserprofileFactory.createUserProfile(
                Helper.generateId(),
                user4,
                "Singing",
                false,
                LocalDateTime.now(),
                location4,
                preference4,
                new HashSet<>(), // likes
                new HashSet<>(), // match request
                new HashSet<>(), // match accepted
                new ArrayList<>() // Swipes
        );
    }

    public static UserProfile getTestUserProfile5() {
        User user5 = getTestUser5();
        Preference preference5 = getTestPreference5();
        Location location5 = getLocationTestData5();

        return UserprofileFactory.createUserProfile(
                Helper.generateId(),
                user5,
                "Crafting",
                true,
                LocalDateTime.now(),
                location5,
                preference5,
                new HashSet<>(), // likes
                new HashSet<>(), // match request
                new HashSet<>(), // match accepted
                new ArrayList<>() // Swipes
        );
    }
}