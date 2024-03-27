package za.ac.cput.repository;
/*
    MatchingRepositoryTest.java
    MatchingRepository class
    Author: Thato Mokoena (222667087)
    Date 27 March 2024
*/

import org.junit.jupiter.api.*;
import za.ac.cput.domain.Matching;
import za.ac.cput.factory.MatchingFactory;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MatchingRepositoryTest {

    private IMatchingRepository repository = MatchingRepository.getRepository();

    private Matching matches = MatchingFactory.createMatch("2", "Thembi", "Tshepo");

    @Test
    @Order(1)
    void create() {
        Matching created = repository.create(matches);
        assertNotNull(created);
        System.out.println(created);
    }

    @Test
    @Order(2)
    void read() {
        String connections = matches.getConnections();
        Matching read = repository.read(connections);
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    @Order(3)
    void update() {
        Matching updated = repository.update(new Matching.Builder().copy(matches).setUser2("Sylvester").build());
        assertNotNull(updated);
        System.out.println(updated);;
    }

    @Test
    @Order(5)
    void delete() {
        assertTrue(repository.delete(matches.getConnections()));
        System.out.println("Match has been deleted");
    }

    @Test
    @Order(4)
    void getAll() {
        System.out.println(repository.getAll());
    }
}