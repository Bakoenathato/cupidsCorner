package za.ac.cput.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.*;
import za.ac.cput.factory.*;
import za.ac.cput.repository.MatchRepository;
import za.ac.cput.repository.UserprofileRepository;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class MatchServiceTest {

    @Autowired
    private MatchService matchService;

    private MatchRepository matchRepository;

    private Match match;

    @Test
    void a_create() {
        Match createdMatch = matchService.create(match);
        assertNotNull(createdMatch);
        System.out.println(createdMatch);
    }

    @Test
    void b_read() {
        Match readMatch = matchService.read(match.getMatchId());
        assertNotNull(readMatch);
        System.out.println(readMatch);
    }

    @Test
    void c_update() {
        Match newMatch = new Match.Builder().copy(match)
                .setMatchId(3)
                .build();
        Match updatedMatch = matchService.update(newMatch);
        assertNotNull(updatedMatch);
        System.out.println(updatedMatch);
    }

    @Test
    void d_getAll() {
        System.out.println(matchService.getAll());
    }
}