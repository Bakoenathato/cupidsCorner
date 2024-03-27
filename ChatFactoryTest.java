package za.ac.cput.factory;
//nasiphi sunduza 222499028
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Chat;

import static org.junit.jupiter.api.Assertions.*;

class ChatFactoryTest {

    @Test
    void createChat_ValidParameters_Success() {
        // Given
        String sender = "Alice";
        String receiver = "Bob";
        String message = "Hello, Bob!";
        String timestamp = "2024-03-27 10:00:00";

        // When
        Chat chat = ChatFactory.createChat(sender, receiver, message, timestamp);

        // Then
        assertNotNull(chat);
        assertEquals(sender, chat.getSender());
        assertEquals(receiver, chat.getReceiver());
        assertEquals(message, chat.getMessage());
        assertEquals(timestamp, chat.getTimestamp());
    }

    @Test
    void createChat_NullParameters_ReturnsNull() {
        // When
        Chat chat = ChatFactory.createChat(null, null, null, null);

        // Then
        assertNull(chat);
    }

    @Test
    void createChat_EmptyParameters_ReturnsNull() {
        // When
        Chat chat = ChatFactory.createChat("", "", "", "");

        // Then
        assertNull(chat);
    }
}