package za.ac.cput.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Like;
import za.ac.cput.factory.LikeFactory;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.class)
class LikeServiceTest {

    @Autowired
    private LikeService service;
//    private LocalDateTime time;

    private Like like= LikeFactory.buildLike("01","001","001",LocalDateTime.now());

    @Test
    void a_create(){
        //if(like == null)throw AssertionError();
        Like created =service.read(like.getLikeID());
        assertNotNull(created);
        System.out.println(created);
    }
    @Test
    void b_read(){
        Like read=service.read(like.getLikeID());
        assertNotNull(read);
        System.out.println(read);
    }
    @Test
    void c_update(){
        Like newlike = new Like.Builder().copy(like).setLikedID("200").build();
        Like updated = service.update(newlike);
        assertNotNull(updated);
        System.out.println(updated);
    }
    @Test
    void d_getAll(){
        System.out.println(service.getall());
    }
}