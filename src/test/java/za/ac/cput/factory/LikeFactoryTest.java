package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Like;
import za.ac.cput.domain.UserProfile;
import za.ac.cput.util.Helper;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class LikeFactoryTest {
    private LocalDateTime x;
    @BeforeEach
    void setup(){
        x= LocalDateTime.now();
    }
    @Test
    void createLike1() {
        Like like= LikeFactory.buildLike("1","01","001",x);
        Boolean check= Helper.isNullOrEmpty(String.valueOf(like));
        assertNotNull(check);
        System.out.println(like);

    }

    @Test
    void createLike2() {
        String likeid=Helper.generateId();
        String likerid=Helper.generateId();
        String likedid=Helper.generateId();
        Like like=LikeFactory.buildLike(likeid,likerid,likedid,x);
        Boolean check=Helper.isNullOrEmpty(String.valueOf(like));
        assertNotNull(check);
        System.out.println(like);
    }

}