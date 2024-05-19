package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Chat;
import za.ac.cput.factory.ChatFactory;

import static org.junit.jupiter.api.Assertions.*;

class ChatFactoryTest {

    @Test
    void testCreateChatSuccess() {
        String sender = "Asiphe";
        String receiver = "Masilangwe";
        String message = "What time is the meeting?";
        String timestamp = "2024-09-06T10:15:30";

        Chat chat = ChatFactory.createChat(sender, receiver, message, timestamp);

        assertNotNull(chat);
        assertEquals(sender, chat.getSender());
        assertEquals(receiver, chat.getReceiver());
        assertEquals(message, chat.getMessage());
        assertEquals(timestamp, chat.getTimestamp());
    }

    @Test
    void testCreateChatWithNullSender() {
        String receiver = "Masilangwe";
        String message = "I will let you know once it is confirmed.";
        String timestamp = "2024-09-06T10:15:30";

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ChatFactory.createChat(null, receiver, message, timestamp);
        });

        String expectedMessage = "Sender cannot be null or empty";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testCreateChatWithEmptySender() {
        String receiver = "Masilangwe";
        String message = "What time is the meeting?";
        String timestamp = "2024-09-06T10:15:30";

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ChatFactory.createChat("", receiver, message, timestamp);
        });

        String expectedMessage = "Sender cannot be null or empty";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testCreateChatWithNullReceiver() {
        String sender = "Asiphe";
        String message = "What time is the meeting?";
        String timestamp = "2024-09-06T10:15:30";

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ChatFactory.createChat(sender, null, message, timestamp);
        });

        String expectedMessage = "Receiver cannot be null or empty";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testCreateChatWithEmptyReceiver() {
        String sender = "Asiphe";
        String message = "What time is the meeting?";
        String timestamp = "2024-09-06T10:15:30";

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ChatFactory.createChat(sender, "", message, timestamp);
        });

        String expectedMessage = "Receiver cannot be null or empty";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testCreateChatWithNullMessage() {
        String sender = "Asiphe";
        String receiver = "Masilangwe";
        String timestamp = "2024-09-06T10:15:30";

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ChatFactory.createChat(sender, receiver, null, timestamp);
        });

        String expectedMessage = "Message cannot be null or empty";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testCreateChatWithEmptyMessage() {
        String sender = "Asiphe";
        String receiver = "Masilangwe";
        String timestamp = "2024-09-06T10:15:30";

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ChatFactory.createChat(sender, receiver, "", timestamp);
        });

        String expectedMessage = "Message cannot be null or empty";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testCreateChatWithNullTimestamp() {
        String sender = "Asiphe";
        String receiver = "Masilangwe";
        String message = "What time is the meeting?";

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ChatFactory.createChat(sender, receiver, message, null);
        });

        String expectedMessage = "Timestamp cannot be null or empty";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testCreateChatWithEmptyTimestamp() {
        String sender = "Asiphe";
        String receiver = "Masilangwe";
        String message = "What time is the meeting?";

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ChatFactory.createChat(sender, receiver, message, "");
        });

        String expectedMessage = "Timestamp cannot be null or empty";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}
