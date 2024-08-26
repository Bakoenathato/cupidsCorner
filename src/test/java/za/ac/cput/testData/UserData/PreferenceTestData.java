package za.ac.cput.testData.UserData;

import za.ac.cput.domain.Gender;
import za.ac.cput.domain.Preference;
import za.ac.cput.factory.PreferenceFactory;

public class PreferenceTestData {
    public static Preference geTestPreference1() {
        return PreferenceFactory.buildPreferenceWithoutProfile(
                1L,
                20,
                45,
                50,
                Gender.MALE);
    }

    public static Preference getTestPreference2() {
        return PreferenceFactory.buildPreferenceWithoutProfile(
                2L,
                25,
                40,
                55,
                Gender.FEMALE);
    }

    public static Preference getTestPreference3() {
        return PreferenceFactory.buildPreferenceWithoutProfile(
                3L,
                30,
                35,
                60,
                Gender.MALE);
    }

    public static Preference getTestPreference4() {
        return PreferenceFactory.buildPreferenceWithoutProfile(
                4L,
                22,
                45,
                50,
                Gender.OTHER);
    }

    public static Preference getTestPreference5() {
        return PreferenceFactory.buildPreferenceWithoutProfile(
                5L,
                28,
                38,
                52,
                Gender.FEMALE);
    }

}
