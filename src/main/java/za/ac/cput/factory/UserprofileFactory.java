package za.ac.cput.factory;

import za.ac.cput.domain.*;
import za.ac.cput.util.Helper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.prefs.Preferences;
import java.util.prefs.PreferencesFactory;
//UserprofileFactory.java
//UserProfile Factory class
//Author:Braedon Sidney Mullins(222821825)
//Date:27 March 2024

public class UserprofileFactory {
    private User user;
    private Location location;
    private Preference prefernce;
    private Like like;
    private LocalDateTime time;
    public static UserProfile createUser(String profileID, User userID, String intrest, boolean profile_vis, LocalDateTime created_at, Location LocationID, Preference prefernceID, Like like,Match matchrequest,Match matchedaccpeted){
        if(Helper.isNullOrEmpty(profileID)||Helper.isNullOrEmpty(String.valueOf(userID))||Helper.isNullOrEmpty(intrest)||Helper.isNullOrEmpty(String.valueOf(profile_vis))||Helper.isNullOrEmpty(String.valueOf(created_at))||Helper.isNullOrEmpty(String.valueOf(LocationID))||Helper.isNullOrEmpty(String.valueOf(prefernceID))|Helper.isNullOrEmpty(String.valueOf(like))||Helper.isNullOrEmpty(String.valueOf(matchrequest))||Helper.isNullOrEmpty(String.valueOf(matchedaccpeted)))
            return null;
        return new UserProfile.Builder().setProfileID(profileID).setUserID(userID).setInterests(intrest).setProfile_visibility(profile_vis).setCreated_at(created_at).setLocationID(LocationID).setPreferenceID(prefernceID).setLikes(like).build();
    }




    public static UserProfile createUser(String intrest, boolean profile_vis, LocalDateTime created_at){
        if (Helper.isNullOrEmpty(intrest)||Helper.isNullOrEmpty(String.valueOf(profile_vis))||Helper.isNullOrEmpty(String.valueOf(created_at)))
        return null;

        String profileID=Helper.generateId();

        User user=UserFactory.buildUser("1","braedon","braedonmullins01@gmail.com","Bredon","Mullins","male","braedon");
        Location location1=LocationFactory.createLocation("Cape Town","Western Cape","Kuilsriver");
        Preference prefernce= PreferenceFactory.buildPreference(1,"20","50km","female");
        Like like=LikeFactory.buildLike("1","01","001",LocalDateTime.now());
//        Match match=MatchFactory.buildMatch()

//        User userid=user.getUserId();
        return new UserProfile.Builder().setProfileID(profileID).setUserID(user).setInterests(intrest).setProfile_visibility(profile_vis).setCreated_at(created_at).setLocationID(location1).setPreferenceID(prefernce).setLikes(like).build();
    }
    public static UserProfile createUser(String profileID, User userID, String intrest, boolean profile_vis, LocalDateTime created_at, Location LocationID, Preference prefernceID, Like like){
        if(Helper.isNullOrEmpty(profileID)||Helper.isNullOrEmpty(String.valueOf(userID))||Helper.isNullOrEmpty(intrest)||Helper.isNullOrEmpty(String.valueOf(profile_vis))||Helper.isNullOrEmpty(String.valueOf(created_at))||Helper.isNullOrEmpty(String.valueOf(LocationID))||Helper.isNullOrEmpty(String.valueOf(prefernceID))|Helper.isNullOrEmpty(String.valueOf(like)))
            return null;
        return new UserProfile.Builder().setProfileID(profileID).setUserID(userID).setInterests(intrest).setProfile_visibility(profile_vis).setCreated_at(created_at).setLocationID(LocationID).setPreferenceID(prefernceID).setLikes(like).build();
    }
}
