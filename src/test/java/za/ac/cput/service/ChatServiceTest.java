package za.ac.cput.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import za.ac.cput.domain.Chat;
import za.ac.cput.repository.ChatRepository.ChatRepository1;
import za.ac.cput.service.ChatService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class ChatServiceTest {

    @Autowired
    private ChatService chatService;

    @Autowired
    private ChatRepository1 chatRepository;

    private Chat chat1, chat2;

    @BeforeEach
    void setUp() {
        chatRepository.deleteAll();

        chat1 = new Chat.Builder()
                .setChatId(1L)
                .setSender("Asiphe")
                .setReceiver("Masilangwe")
                .setMessage("Pay me back!")
                .setTimestamp("2022-06-30T10:15:30")
                .build();

        chat2 = new Chat.Builder()
                .setChatId(2L)
                .setSender("Aubrey")
                .setReceiver("Lucky")
                .setMessage("Delete that post please!!")
                .setTimestamp("2022-06-12T11:15:30")
                .build();
    }

    @Test
    void testSaveChat() {
        Chat savedChat = chatService.save(chat1);
        assertNotNull(savedChat);
        assertEquals(chat1.getchatId(), savedChat.getchatId());
    }

    @Test
    void testFindById() {
        chatService.save(chat1);
        Optional<Chat> foundChat = chatService.findById(1L);
        assertTrue(foundChat.isPresent());
        assertEquals(chat1.getchatId(), foundChat.get().getchatId());
    }

    @Test
    void testFindAll() {
        chatService.save(chat1);
        chatService.save(chat2);

        List<Chat> chats = chatService.findAll();
        assertEquals(2, chats.size());
    }

    @Test
    void testUpdateChat() {
        chatService.save(chat1);
        Chat updatedChat = new Chat.Builder()
                .setSender("Asiphe")
                .setReceiver("Pholile")
                .setMessage("What's the vibe like?")
                .setTimestamp("2022-06-11T12:15:30")
                .build();

        Chat result = chatService.update(1L, updatedChat);
        assertNotNull(result);
        assertEquals("UserE", result.getReceiver());
    }

    @Test
    void testDeleteById() {
        chatService.save(chat1);
        chatService.deleteById(1L);

        Optional<Chat> foundChat = chatService.findById(1L);
        assertFalse(foundChat.isPresent());
    }

    @Test
    void testFindBySender() {
        chatService.save(chat1);
        List<Chat> chats = chatService.findBySender("Asiphe");
        assertEquals(1, chats.size());
        assertEquals(chat1.getSender(), chats.get(0).getSender());
    }

    @Test
    void testFindByReceiver() {
        chatService.save(chat1);
        List<Chat> chats = chatService.findByReceiver("Masilangwe");
        assertEquals(1, chats.size());
        assertEquals(chat1.getReceiver(), chats.get(0).getReceiver());
    }

    @Test
    void testFindBySenderAndReceiver() {
        chatService.save(chat1);
        List<Chat> chats = chatService.findBySenderAndReceiver("Asiphe", "Masilangwe");
        assertEquals(1, chats.size());
        assertEquals(chat1.getSender(), chats.get(0).getSender());
        assertEquals(chat1.getReceiver(), chats.get(0).getReceiver());
    }

    @Test
    void testFindByTimestampBetween() {
        chatService.save(chat1);
        chatService.save(chat2);

        List<Chat> chats = chatService.findByTimestampBetween("2022-06-22T19:20:00", "2022-06-22T12:00:00");
        assertEquals(2, chats.size());
    }
}

