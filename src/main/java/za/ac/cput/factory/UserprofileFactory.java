package za.ac.cput.factory;

import za.ac.cput.domain.UserProfile;
import za.ac.cput.util.Helper;
//UserprofileFactory.java
//UserProfile Factory class
//Author:Braedon Sidney Mullins(222821825)
//Date:27 March 2024

public class UserprofileFactory {
    public static UserProfile createUser(String Name,String Surename,String ID){
        if(Helper.isNullorEmpty(Name)||Helper.isNullorEmpty(Surename)||Helper.isNullorEmpty(ID))
            return null;
        return new UserProfile.Builder().setName(Name).setSurename(Surename).setID(ID).build();
    }
    public static UserProfile createUser(String Name,String Surename,String Gender,double Age){
        if (Helper.isNullorEmpty(Name)||Helper.isNullorEmpty(Surename)||Helper.isNullorEmpty(Gender)||Helper.isNullorEmpty(String.valueOf(Age)))
            return null;

        String ID=Helper.generateID();
        return new UserProfile.Builder().setName(Name).setSurename(Surename).setID(ID).build();
    }
}
