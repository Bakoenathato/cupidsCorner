package za.ac.cput.service;


import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.User;
import za.ac.cput.factory.UserFactory;
import za.ac.cput.domain.User;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.MethodOrder;
import org.junit.jupiter.api.TestMethodOrder;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest;
import static org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.test.util.AssertionErrors.assertNotNull;

@SpringBootTest
class UserServiceTest {
    @Autowired
    private UserService userService;

    private static User user1;
    private static User user2;

    @Test
    void a_setup () {
        user1 = UserFactory.buildUser("123", "Mihle", "0000", "222456719@mycput.ac.za", "Mihle", "Bontsi", "F", "12");
        assertNotNull(user1);
        System.out.println(user1);
        user2 = UserFactory.buildUser("122", "Khanyisile", "0011", "234689871@mycput.ac.za","Khanyisile", "Bontsi", "F","10");
        assertNotNull(user2);
        System.out.println(user2);
    }
    @Test
    void b_create() {
        User created1 = UserService.create(user1);
        assertNotNull(created1);
        System.out.println(created1);
        User created2 = UserService.create(user2);
        assertNotNull(created2);
        System.out.println(created2);


    }
    @Test
    void c_read() {
        User read = userService.read(user2.getUserId());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    void d_update() {
        User newUser = new User.Builder().copy(user2).setUserName("Khanyisile Athandwa").build();
        User updated = userService.update(newUser);
        System.out.println(updated);
    }
    @Test
    void getAll() {
        System.out.println(userService.getAll());
    }
}