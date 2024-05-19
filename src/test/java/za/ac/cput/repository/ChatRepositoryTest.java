package za.ac.cput.repository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import za.ac.cput.domain.Chat;
import za.ac.cput.repository.ChatRepository.ChatRepository1;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class ChatRepositoryTest {

    @Autowired
    private ChatRepository1 chatRepository;

    private Chat chat1, chat2, chat3;

    @BeforeEach
    void setUp() {
        chat1 = new Chat.Builder()
                .setSender("Asiphe")
                .setReceiver("Masilangwe")
                .setMessage("What time is the meeting?")
                .setTimestamp("2024-09-06T10:15:30")
                .build();

        chat2 = new Chat.Builder()
                .setSender("Asiphe")
                .setReceiver("Aubrey")
                .setMessage("Please check your email.")
                .setTimestamp("2024-09-07T11:15:30")
                .build();

        chat3 = new Chat.Builder()
                .setSender("Masilangwe")
                .setReceiver("Aubrey")
                .setMessage("I sent an email.")
                .setTimestamp("2024-09-08T12:15:30")
                .build();

        chatRepository.save(chat1);
        chatRepository.save(chat2);
        chatRepository.save(chat3);
    }

    @Test
    void testFindBySender() {
        List<Chat> chats = chatRepository.findBySender("Asiphe");
        assertEquals(2, chats.size());
        assertTrue(chats.contains(chat1));
        assertTrue(chats.contains(chat2));
    }

    @Test
    void testFindByReceiver() {
        List<Chat> chats = chatRepository.findByReceiver("Aubrey");
        assertEquals(2, chats.size());
        assertTrue(chats.contains(chat2));
        assertTrue(chats.contains(chat3));
    }

    @Test
    void testFindBySenderAndReceiver() {
        List<Chat> chats = chatRepository.findBySenderAndReceiver("Asiphe", "Masilangwe");
        assertEquals(1, chats.size());
        assertTrue(chats.contains(chat1));
    }

    @Test
    void testFindByTimestampBetween() {
        List<Chat> chats = chatRepository.findByTimestampBetween("2024-09-06T10:00:00", "2024-09-06T11:30:00");
        assertEquals(2, chats.size());
        assertTrue(chats.contains(chat1));
        assertTrue(chats.contains(chat2));
    }

    @Test
    void testSaveChat() {
        Chat chat = new Chat.Builder()
                .setSender("Lucky")
                .setReceiver("Pholile")
                .setMessage("Hey Pholile")
                .setTimestamp("2024-09-10T13:15:30")
                .build();

        Chat savedChat = chatRepository.save(chat);

        assertNotNull(savedChat.getchatId());
        assertEquals("Lucky", savedChat.getSender());
        assertEquals("Pholile", savedChat.getReceiver());
        assertEquals("Hey Pholile", savedChat.getMessage());
        assertEquals("2024-09-10T13:15:30", savedChat.getTimestamp());
    }

    @Test
    void testDeleteChat() {
        chatRepository.delete(chat1);
        List<Chat> chats = chatRepository.findBySender("Asiphe");
        assertEquals(1, chats.size());
        assertFalse(chats.contains(chat1));
    }
}
