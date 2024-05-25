package za.ac.cput.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import za.ac.cput.domain.Block;
import za.ac.cput.repository.BlockRepository;
import za.ac.cput.service.BlockService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class BlockServiceTest {

    @Autowired
    private BlockService blockService;

    @Autowired
    private BlockRepository blockRepository;

    private Block block1, block2;

    @BeforeEach
    void setUp() {
        blockRepository.deleteAll(); // Clean up before each test

        block1 = new Block.Builder()
                .setId(1L)
                .setBlocker("Asiphe")
                .setBlocked("Masilangwe")
                .setTimestamp("2002-04-25T10:15:30")
                .build();

        block2 = new Block.Builder()
                .setId(2L)
                .setBlocker("Aubrey")
                .setBlocked("Lucky")
                .setTimestamp("2002-05-19T11:15:30")
                .build();
    }

    @Test
    void testSaveBlock() {
        Block savedBlock = blockService.save(block1);
        assertNotNull(savedBlock);
        assertEquals(block1.getId(), savedBlock.getId());
    }

    @Test
    void testFindById() {
        blockService.save(block1);
        Optional<Block> foundBlock = blockService.findById(1L);
        assertTrue(foundBlock.isPresent());
        assertEquals(block1.getId(), foundBlock.get().getId());
    }

    @Test
    void testFindAll() {
        blockService.save(block1);
        blockService.save(block2);

        List<Block> blocks = blockService.findAll();
        assertEquals(2, blocks.size());
    }

    @Test
    void testUpdateBlock() {
        blockService.save(block1);
        Block updatedBlock = new Block.Builder()
                .setBlocker("Asiphe")
                .setBlocked("Pholile")
                .setTimestamp("2002-07-01T12:15:30")
                .build();

        Block result = blockService.update(1L, updatedBlock);
        assertNotNull(result);
        assertEquals("Pholile", result.getBlocked());
    }

    @Test
    void testDeleteById() {
        blockService.save(block1);
        blockService.deleteById(1L);

        Optional<Block> foundBlock = blockService.findById(1L);
        assertFalse(foundBlock.isPresent());
    }

    @Test
    void testFindByBlocker() {
        blockService.save(block1);
        List<Block> blocks = blockService.findByBlocker("Asiphe");
        assertEquals(1, blocks.size());
        assertEquals(block1.getBlocker(), blocks.get(0).getBlocker());
    }

    @Test
    void testFindByBlocked() {
        blockService.save(block1);
        List<Block> blocks = blockService.findByBlocked("Masilangwe");
        assertEquals(1, blocks.size());
        assertEquals(block1.getBlocked(), blocks.get(0).getBlocked());
    }

    @Test
    void testFindByBlockerAndBlocked() {
        blockService.save(block1);
        List<Block> blocks = blockService.findByBlockerAndBlocked("Asiphe", "Masilangwe");
        assertEquals(1, blocks.size());
        assertEquals(block1.getBlocker(), blocks.get(0).getBlocker());
        assertEquals(block1.getBlocked(), blocks.get(0).getBlocked());
    }
}
