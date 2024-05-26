package za.ac.cput.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import za.ac.cput.domain.Block;
import za.ac.cput.service.BlockService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BlockController.class)
public class BlockControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BlockService blockService;

    private Block block1;
    private Block block2;
    private List<Block> blockList;

    @BeforeEach
    public void setUp() {
        block1 = new Block.Builder()
                .setId(1L)
                .setBlocker("Asiphe")
                .setBlocked("Masilangwe")
                .setTimestamp(System.currentTimeMillis())
                .build();

        block2 = new Block.Builder()
                .setId(2L)
                .setBlocker("Aubrey")
                .setBlocked("Lucky")
                .setTimestamp(System.currentTimeMillis())
                .build();

        blockList = Arrays.asList(block1, block2);
    }

    @Test
    public void testCreateBlock() throws Exception {
        given(blockService.save(any(Block.class))).willReturn(block1);

        mockMvc.perform(post("/api/blocks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"blocker\":\"Asiphe\", \"blocked\":\"Masilangwe\", \"timestamp\":1234567890}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.blocker").value("Asiphe"))
                .andExpect(jsonPath("$.blocked").value("Masilangwe"))
                .andExpect(jsonPath("$.timestamp").isNumber());
    }

    @Test
    public void testGetBlockById() throws Exception {
        given(blockService.findById(anyLong())).willReturn(Optional.of(block1));

        mockMvc.perform(get("/api/blocks/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.blocker").value("Asiphe"));
    }

    @Test
    public void testGetAllBlocks() throws Exception {
        given(blockService.findAll()).willReturn(blockList);

        mockMvc.perform(get("/api/blocks")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].blocker").value("Asiphe"))
                .andExpect(jsonPath("$[1].blocker").value("Aubrey"));
    }

    @Test
    public void testUpdateBlock() throws Exception {
        given(blockService.update(anyLong(), any(Block.class))).willReturn(block1);

        mockMvc.perform(put("/api/blocks/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"blocker\":\"Asiphe\", \"blocked\":\"Masilangwe\", \"timestamp\":1234567890}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.blocker").value("Asiphe"))
                .andExpect(jsonPath("$.blocked").value("Masilangwe"))
                .andExpect(jsonPath("$.timestamp").isNumber());
    }

    @Test
    public void testDeleteBlock() throws Exception {
        doNothing().when(blockService).deleteById(anyLong());

        mockMvc.perform(delete("/api/blocks/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetBlocksByBlocker() throws Exception {
        given(blockService.findByBlocker("user1")).willReturn(Arrays.asList(block1));

        mockMvc.perform(get("/api/blocks/blocker/user1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].blocker").value("Asiphe"));
    }

    @Test
    public void testGetBlocksByBlocked() throws Exception {
        given(blockService.findByBlocked("Masilangwe")).willReturn(Arrays.asList(block1));

        mockMvc.perform(get("/api/blocks/blocked/Masilangwe")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].blocked").value("Masilangwe"));
    }

    @Test
    public void testGetBlocksByBlockerAndBlocked() throws Exception {
        given(blockService.findByBlockerAndBlocked("Asiphe", "Masilangwe")).willReturn(Arrays.asList(block1));

        mockMvc.perform(get("/api/blocks/search")
                        .param("blocker", "Asiphe")
                        .param("blocked", "Masilangwe")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].blocker").value("Asiphe"))
                .andExpect(jsonPath("$[0].blocked").value("Masilangwe"));
    }
}
