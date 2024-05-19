package za.ac.cput.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.*;
import za.ac.cput.factory.*;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.class)
class UserprofileServiceTest {

    @Autowired
    private UserprofileService service;
    User user= UserFactory.buildUser("1","braedon","braedonmullins01@gmail.com","Bredon","Mullins","male","braedon");
    Location location1= LocationFactory.createLocation("Cape Town","Western Cape","Kuilsriver");
    Preference prefernce= PreferenceFactory.buildPreference(1,"20","50km","female");
    Like like= LikeFactory.buildLike("1","01","001", LocalDateTime.now());

    private UserProfile userprofile1= UserprofileFactory.createUser("1",user,"Female",true,LocalDateTime.now(),location1,prefernce,like);


    @Test
    void a_create(){
        UserProfile created = service.create(userprofile1);
        assertNotNull(created);
        System.out.println(created);


    }
    @Test
    void b_read(){
        UserProfile read =service.read(userprofile1.getProfileID());
        assertNotNull(read);
        System.out.println(read);
    }
    @Test
    void c_update(){
        UserProfile newUserprofile= new UserProfile.Builder().copy(userprofile1).setProfile_visibility(false).build();
        UserProfile updated = service.update(newUserprofile);
        assertNotNull(updated);
        System.out.println(updated);

    }
    @Test
    void d_getAll(){
        System.out.println(service.getall());
    }


}