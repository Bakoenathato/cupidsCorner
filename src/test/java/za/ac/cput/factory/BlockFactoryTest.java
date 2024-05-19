package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Block;
import za.ac.cput.factory.BlockFactory;

import static org.junit.jupiter.api.Assertions.*;

class BlockFactoryTest {

    @Test
    void testCreateBlockSuccess() {
        String blocker = "Asiphe";
        String blocked = "Masilangwe";
        String timestamp = "2002-04-25T10:15:30";

        Block block = BlockFactory.createBlock(blocker, blocked, timestamp);

        assertNotNull(block);
        assertEquals(blocker, block.getBlocker());
        assertEquals(blocked, block.getBlocked());
        assertEquals(timestamp, block.getTimestamp());
    }

    @Test
    void testCreateBlockWithNullBlocker() {
        String blocked = "Masilangwe";
        String timestamp = "2002-04-25T10:15:30";

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            BlockFactory.createBlock(null, blocked, timestamp);
        });

        String expectedMessage = "Blocker cannot be null or empty";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testCreateBlockWithEmptyBlocker() {
        String blocked = "Masilangwe";
        String timestamp = "2002-04-25T10:15:30";

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            BlockFactory.createBlock("", blocked, timestamp);
        });

        String expectedMessage = "Blocker cannot be null or empty";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testCreateBlockWithNullBlocked() {
        String blocker = "Asiphe";
        String timestamp = "2002-04-25T10:15:30";

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            BlockFactory.createBlock(blocker, null, timestamp);
        });

        String expectedMessage = "Blocked cannot be null or empty";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testCreateBlockWithEmptyBlocked() {
        String blocker = "Asiphe";
        String timestamp = "2002-04-25T10:15:30";

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            BlockFactory.createBlock(blocker, "", timestamp);
        });

        String expectedMessage = "Blocked cannot be null or empty";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testCreateBlockWithNullTimestamp() {
        String blocker = "Asiphe";
        String blocked = "Masilangwe";

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            BlockFactory.createBlock(blocker, blocked, null);
        });

        String expectedMessage = "Timestamp cannot be null or empty";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testCreateBlockWithEmptyTimestamp() {
        String blocker = "Asiphe";
        String blocked = "Masilangwe";

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            BlockFactory.createBlock(blocker, blocked, "");
        });

        String expectedMessage = "Timestamp cannot be null or empty";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}

