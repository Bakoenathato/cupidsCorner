package za.ac.cput.util;
//Helper.java
//UserProfile Helper class
//Author:Braedon Sidney Mullins(222821825)
//Date:27 March 2024

import java.util.UUID;

public class Helper {
    public static boolean isNullOrEmpty(String s){
        if(s==null||s.isEmpty())
            return true;
        return false;
    }


    public static String generateID(){
        return UUID.randomUUID().toString();
    }
}
