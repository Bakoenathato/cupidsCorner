package za.ac.cput.factory;

import za.ac.cput.domain.UserProfile;
import za.ac.cput.util.Helper;
//UserprofileFactory.java
//UserProfile Factory class
//Author:Braedon Sidney Mullins(222821825)
//Date:27 March 2024

public class UserprofileFactory {
    public static UserProfile createUser(String Name,String Surname,String ID){
        if(Helper.isNullOrEmpty(Name)||Helper.isNullOrEmpty(Surname)||Helper.isNullOrEmpty(ID))
            return null;
        return new UserProfile.Builder().setName(Name).setSurname(Surname).setID(ID).build();
    }
    public static UserProfile createUser(String Name,String Surname,String Gender,double Age){
        if (Helper.isNullOrEmpty(Name)||Helper.isNullOrEmpty(Surname)||Helper.isNullOrEmpty(Gender)||Helper.isNullOrEmpty(String.valueOf(Age)))
            return null;

        String ID=Helper.generateId();
        return new UserProfile.Builder().setName(Name).setSurname(Surname).setID(ID).build();
    }
}
