package za.ac.cput.factory;

import za.ac.cput.domain.UserProfile;
import za.ac.cput.util.Helper;
//UserprofileFactory.java
//UserProfile Factory class
//Author:Braedon Sidney Mullins(222821825)
//Date:27 March 2024

public class UserprofileFactory {
    public static UserProfile createUser(String Name,String Surname,String Gender,double Age,String ID,String Location,String Bio){
        if(Helper.isNullOrEmpty(Name)||Helper.isNullOrEmpty(Surname)||Helper.isNullOrEmpty(ID)||Helper.isNullOrEmpty(String.valueOf(Age))||Helper.isNullOrEmpty(Location)||Helper.isNullOrEmpty(Bio)||Helper.isNullOrEmpty(Gender))
            return null;
        return new UserProfile.Builder().setName(Name).setSurname(Surname).setID(ID).setAge(Age).setLocation(Location).setBio(Bio).setGender(Gender).build();
    }
    public static UserProfile createUser(String Name,String Surname,String Gender,double Age,String Location,String Bio){
        if (Helper.isNullOrEmpty(Name)||Helper.isNullOrEmpty(Surname)||Helper.isNullOrEmpty(Gender)||Helper.isNullOrEmpty(String.valueOf(Age))||Helper.isNullOrEmpty(Location)||Helper.isNullOrEmpty(Bio))
            return null;

        String ID=Helper.generateID();
        return new UserProfile.Builder().setName(Name).setSurname(Surname).setID(ID).setAge(Age).setLocation(Location).setBio(Bio).build();
    }
}
