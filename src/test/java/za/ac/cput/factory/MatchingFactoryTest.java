package za.ac.cput.factory;
/*
    MatchingFactoryTest.java
    MatchingFactory class
    Author: Thato Mokoena (222667087)
    Date 27 March 2024
*/

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Matching;

import java.sql.SQLOutput;

import static org.junit.jupiter.api.Assertions.*;

class MatchingFactoryTest {

    @Test
    void testMatchBuild(){
        Matching matching = MatchingFactory.createMatch("2", "Thembi", "Tshepho");
        assertNotNull(matching);
        System.out.println(matching);
    }

    @Test
    void testMatchBuildWithFail(){
        Matching matching = MatchingFactory.createMatch("", "Mhla", "Bellemy");
        assertNotNull(matching);
        System.out.println(matching);
    }

}