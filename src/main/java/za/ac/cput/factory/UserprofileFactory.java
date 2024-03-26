package za.ac.cput.factory;

import za.ac.cput.domain.UserProfile;
import za.ac.cput.util.Helper;

public class UserprofileFactory {
    public static UserProfile createUser(String Name,String Surename,String ID){
        if(Helper.isNullorEmpty(Name)||Helper.isNullorEmpty(Surename)||Helper.isNullorEmpty(ID))
            return null;
        return new UserProfile.Builder().setName(Name).setSurename(Surename).setID(ID).build();
    }
    public static UserProfile createUser(String Name,String Surename){
        if (Helper.isNullorEmpty(Name)||Helper.isNullorEmpty(Surename))
            return null;

        String ID=Helper.generateID();
        return new UserProfile.Builder().setName(Name).setSurename(Surename).setID(ID).build();
    }
}
