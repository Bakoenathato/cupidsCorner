package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.User;
import za.ac.cput.factory.UserFactory;

import static org.junit.jupiter.api.Assertions.*;
/*UserRepositoryTest.java
UserRepositoryTest class
Author Mihle Sivuyise Bontsi (222406917)
Date: 27 March 2024
 */

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserRepositoryTest {

    private IUserRepository repository = UserRepository.getRepository();

    private User user = UserFactory.buildUser("123", "mihlebontsi99@gmail.com", "sivu55");


    @Test
    @Order(2)
    void read() {
        String userId = "123";
        User read = repository.read(userId);
        assertEquals(read, user);
        System.out.println(read);
    }

    @Test
    @Order(3)
    void update() {
        User updated = repository.update(new User.Builder().copy(user).setEmail("mihlebontsi99@gmail.com").build());
        assertNotNull(updated);
        System.out.println(updated);

    }

    @Test
    @Order(5)
    void delete() {
        assertTrue(repository.delete(user.getUserId()));
        System.out.println("Success : deleted user");
    }

    @Test
    @Order(1)
    void create() {
        User created = repository.create(user);
        assertNotNull(created);
        System.out.println(created);

    }

    @Test
    @Order(4)
    void getAll() {
        System.out.println(repository.getAll());
    }
}