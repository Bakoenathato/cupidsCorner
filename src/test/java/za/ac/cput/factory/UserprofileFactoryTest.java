package za.ac.cput.factory;
//UserprofileFactoryTest.java
//UserProfile Test class
//Author:Braedon Sidney Mullins(222821825)
//Date:27 March 2024

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.UserProfile;
import za.ac.cput.util.Helper;

import static org.junit.jupiter.api.Assertions.*;

class UserprofileFactoryTest {
    private UserProfile e=new UserProfile();
    //private Helper x=new Helper();

    @Test
    void createUser() {
        UserProfile user= UserprofileFactory.createUser("Braedon","Mullins","Male", 21 ,"192037977239","Kuilsriver","Likes cars");
        Boolean check=Helper.isNullOrEmpty(String.valueOf(user));
        assertNotNull(check);
        System.out.println(user);

    }

    @Test
    void testCreateUser() {
        String ID=Helper.generateId();
        UserProfile user= UserprofileFactory.createUser("Braedon","mullins","Male",21,ID,"KuilsRiver","Like Cars");
        Boolean check=Helper.isNullOrEmpty(String.valueOf(user));
        assertNotNull(check);
        System.out.println(user);
    }
}