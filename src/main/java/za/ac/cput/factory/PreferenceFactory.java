package za.ac.cput.factory;
/*
    MatchingFactoryTest.java
    MatchingFactory class
    Author: Thato Mokoena (222667087)
    Date 19 May 2024
*/


import za.ac.cput.domain.Preference;
import za.ac.cput.domain.UserProfile;
import za.ac.cput.util.Helper;

public class PreferenceFactory {
    public static Preference buildPreference(int preferenceId, UserProfile profile, String ageRange, String distance, String genderPreference){
        if (Helper.isZero(preferenceId) || profile == null || Helper.isNullOrEmpty(ageRange) || Helper.isNullOrEmpty(distance) || Helper.isNullOrEmpty(genderPreference)) {
            return null;
        }
        return new Preference.Builder()
                .setPreferenceId(preferenceId)
                .setProfile(profile)
                .setAgeRange(ageRange)
                .setDistance(distance)
                .setGenderPreference(genderPreference)
                .build();
    }


    public static Preference buildPreference(int preferenceId, String ageRange, String distance, String genderPreference){
        if (Helper.isZero(preferenceId) || Helper.isNullOrEmpty(ageRange) || Helper.isNullOrEmpty(distance) || Helper.isNullOrEmpty(genderPreference)) {
            return null;
        }

        return new Preference.Builder()
                .setPreferenceId(preferenceId)
                .setAgeRange(ageRange)
                .setDistance(distance)
                .setGenderPreference(genderPreference)
                .build();
    }
}
