package za.ac.cput.factory;
//UserprofileFactoryTest.java
//UserProfile Test class
//Author:Braedon Sidney Mullins(222821825)
//Date:27 March 2024

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Like;
import za.ac.cput.domain.Location;
import za.ac.cput.domain.User;
import za.ac.cput.domain.UserProfile;
import za.ac.cput.util.Helper;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class UserprofileFactoryTest {
    private UserProfile e=new UserProfile();
    private User users;
    private Location location;
    private LocalDateTime x;
   // private Preference preference;
    private Like like;


    //private Helper x=new Helper();
    @BeforeEach
    void setup(){
        users=UserFactory.buildUser("BraedonMullisn01@gmail.com","1");
        location=LocationFactory.createLocation("","","");
        x=LocalDateTime.now();
        //prefernce=PrefernceFactory.createPrefernce();
        Like like=LikeFactory.buildLike("1","01","001",LocalDateTime.now());

    }
    @Test
    void createUser() {
        UserProfile user= UserprofileFactory.createUser("1", users,"Female", true ,x,location,like);
        //UserProfile user= UserprofileFactory.createUser("1", users,"Female", "yes" ,x,location,preference,like);
        Boolean check=Helper.isNullOrEmpty(String.valueOf(user));
        assertNotNull(check);
        System.out.println(user);

    }

    @Test
    void testCreateUser() {
        String ID=Helper.generateId();
        UserProfile user= UserprofileFactory.createUser(ID,users,"Female",true,x,location);
        //UserProfile user= UserprofileFactory.createUser(ID,users,"Female","yes",x,location,preference,like);
        Boolean check=Helper.isNullOrEmpty(String.valueOf(user));
        assertNotNull(check);
        System.out.println(user);
    }
}