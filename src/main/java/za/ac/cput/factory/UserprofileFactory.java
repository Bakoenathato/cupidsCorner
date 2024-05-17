package za.ac.cput.factory;

import za.ac.cput.domain.Like;
import za.ac.cput.domain.Location;
import za.ac.cput.domain.User;
import za.ac.cput.domain.UserProfile;
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
    private Prefernce prefernce;
    private Like like;
    private LocalDateTime time;
    public static UserProfile createUser(String profileID, User userID, String intrest, boolean profile_vis, LocalDateTime created_at, Location LocationID, Preference prefernceID, Like like){
        if(Helper.isNullOrEmpty(profileID)||Helper.isNullOrEmpty(String.valueOf(userID))||Helper.isNullOrEmpty(intrest)||Helper.isNullOrEmpty(String.valueOf(profile_vis))||Helper.isNullOrEmpty(String.valueOf(created_at))||Helper.isNullOrEmpty(String.valueOf(LocationID))||Helper.isNullOrEmpty(String.valueOf(prefernceID))|Helper.isNullOrEmpty(String.valueOf(like)))
            return null;
        return new UserProfile.Builder().setProfileID(profileID).setUserID(userID).setIntrests(intrest).setProfile_visibility(profile_vis).setCreated_at(created_at).setLocationID(LocationID).setPrefernceID(prefernceID).setLikes(like).build();
    }




    public static UserProfile createUser(String intrest, boolean profile_vis, LocalDateTime created_at){
        if (Helper.isNullOrEmpty(intrest)||Helper.isNullOrEmpty(String.valueOf(profile_vis))||Helper.isNullOrEmpty(String.valueOf(created_at)))
        return null;

        String profileID=Helper.generateId();

        User user=UserFactory.buildUser("braedonmullins01@gmail.com","Password");
        Location location1=LocationFactory.createLocation("Cape Town","Western Cape","Kuilsriver");
       // Preference prefernce= PreferenceFactory.createPreference();
        Like like=LikeFactory.buildLike("1","01","001",LocalDateTime.now());

//        User userid=user.getUserId();
        return new UserProfile.Builder().setProfileID(profileID).setUserID(user).setIntrests(intrest).setProfile_visibility(profile_vis).setCreated_at(created_at).setLocationID(location1).setPrefernceID().setLikes(like).build();
    }
}
