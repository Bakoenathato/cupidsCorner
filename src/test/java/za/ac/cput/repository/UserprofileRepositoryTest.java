package za.ac.cput.repository;
//UserprofileRepositoryTest.java
//UserProfile Test class
//Author:Braedon Sidney Mullins(222821825)
//Date:27 March 2024


import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.UserProfile;
import za.ac.cput.factory.UserprofileFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class UserprofileRepositoryTest {
    private final IUserProfileRepository repository=UserprofileRepository.getRepository();
    private final UserProfile user= UserprofileFactory.createUser("Braedon","Mullins","Male", 21 ,"192037977239","Kuilsriver","Likes cars");

   @Test
   @Order(1)
    void create() {
    UserProfile created=repository.create(user);
    assertNotNull(created);
       System.out.println(created);
    }

    @Test
    @Order(2)
    void read() {
       String ID= user.getID();
       UserProfile read=repository.read(ID);
       assertNotNull(read);
        System.out.println(read);
    }

    @Test
    @Order(3)
    void update() {
       UserProfile updated= repository.update(new UserProfile.Builder().copy(user).setName("Braedon Sydeny").build())
               ;
        assertNotNull(updated);
        System.out.println(updated);

   }

//    @Test
//    @Order(5)
//    void delete() {
//       assertTrue(repository.delete(user.getID()));
//        System.out.println("Sucess:employee delted");
//    }

    @Test
    @Order(4)
    void getall() {
        System.out.println(repository.getall());
    }

    @Test
    @Order(5)
    void delete() {
       assertTrue(repository.delete(user.getID()));
        System.out.println("Sucess:employee delted");
    }
    }