package za.ac.cput.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import za.ac.cput.domain.Block;
import za.ac.cput.repository.BlockRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class BlockRepositoryTest {

    @Autowired
    private BlockRepository blockRepository;

    private Block block1, block2, block3;

    @BeforeEach
    void setUp() {
        block1 = new Block.Builder()
                .setBlocker("Asiphe")
                .setBlocked("Masilangwe")
                .setTimestamp("2002-04-25T10:15:30")
                .build();

        block2 = new Block.Builder()
                .setBlocker("Asiphe")
                .setBlocked("Aubrey")
                .setTimestamp("2002-04-19T11:15:30")
                .build();

        block3 = new Block.Builder()
                .setBlocker("Masilangwe")
                .setBlocked("Aubrey")
                .setTimestamp("2002-04-03T12:15:30")
                .build();

        blockRepository.save(block1);
        blockRepository.save(block2);
        blockRepository.save(block3);
    }

    @Test
    void testFindByBlocker() {
        List<Block> blocks = blockRepository.findByBlocker("Asiphe");
        assertEquals(2, blocks.size());
        assertTrue(blocks.contains(block1));
        assertTrue(blocks.contains(block2));
    }

    @Test
    void testFindByBlocked() {
        List<Block> blocks = blockRepository.findByBlocked("Aubrey");
        assertEquals(2, blocks.size());
        assertTrue(blocks.contains(block2));
        assertTrue(blocks.contains(block3));
    }

    @Test
    void testFindByBlockerAndBlocked() {
        List<Block> blocks = blockRepository.findByBlockerAndBlocked("Asiphe", "Masilangwe");
        assertEquals(1, blocks.size());
        assertTrue(blocks.contains(block1));
    }

    @Test
    void testSaveBlock() {
        Block block = new Block.Builder()
                .setBlocker("Lucky")
                .setBlocked("Pholile")
                .setTimestamp("2002-04-17T13:15:30")
                .build();

        Block savedBlock = blockRepository.save(block);

        assertNotNull(savedBlock.getId());
        assertEquals("Lucky", savedBlock.getBlocker());
        assertEquals("Pholile", savedBlock.getBlocked());
        assertEquals("2002-04-17T13:15:30", savedBlock.getTimestamp());
    }

    @Test
    void testDeleteBlock() {
        blockRepository.delete(block1);
        List<Block> blocks = blockRepository.findByBlocker("Asiphe");
        assertEquals(1, blocks.size());
        assertFalse(blocks.contains(block1));
    }
}

