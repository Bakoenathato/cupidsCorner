package za.ac.cput.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import za.ac.cput.domain.Chat;
import za.ac.cput.service.ChatService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ChatController.class)
public class ChatControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ChatService chatService;

    private Chat chat1;
    private Chat chat2;
    private List<Chat> chatList;

    @BeforeEach
    public void setUp() {
        chat1 = new Chat.Builder()
                .setId(1L)
                .setSender("Asiphe")
                .setReceiver("Masilangwe")
                .setMessage("Hey girl!")
                .setTimestamp(System.currentTimeMillis())
                .build();

        chat2 = new Chat.Builder()
                .setId(2L)
                .setSender("Aubrey")
                .setReceiver("Lucky")
                .setMessage("Are you done?")
                .setTimestamp(System.currentTimeMillis())
                .build();

        chatList = Arrays.asList(chat1, chat2);
    }

    @Test
    public void testCreateChat() throws Exception {
        given(chatService.save(any(Chat.class))).willReturn(chat1);

        mockMvc.perform(post("/api/chats")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"sender\":\"Asiphe\", \"receiver\":\"Masilangwe\", \"message\":\"Hey girl!\", \"timestamp\":1234567890}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.sender").value("Asiphe"))
                .andExpect(jsonPath("$.receiver").value("Masilangwe"))
                .andExpect(jsonPath("$.message").value("Hey girl!"));
    }

    @Test
    public void testGetChatById() throws Exception {
        given(chatService.findById(anyLong())).willReturn(Optional.of(chat1));

        mockMvc.perform(get("/api/chats/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.sender").value("Asiphe"));
    }

    @Test
    public void testGetAllChats() throws Exception {
        given(chatService.findAll()).willReturn(chatList);

        mockMvc.perform(get("/api/chats")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].sender").value("Asiphe"))
                .andExpect(jsonPath("$[1].sender").value("Aubrey"));
    }

    @Test
    public void testUpdateChat() throws Exception {
        given(chatService.update(anyLong(), any(Chat.class))).willReturn(chat1);

        mockMvc.perform(put("/api/chats/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"sender\":\"Asiphe\", \"receiver\":\"Masilangwe\", \"message\":\"Hey girl!\", \"timestamp\":1234567890}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.sender").value("Asiphe"))
                .andExpect(jsonPath("$.receiver").value("Masilangwe"))
                .andExpect(jsonPath("$.message").value("Hey girl!"));
    }

    @Test
    public void testDeleteChat() throws Exception {
        doNothing().when(chatService).deleteById(anyLong());

        mockMvc.perform(delete("/api/chats/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetChatsBySender() throws Exception {
        given(chatService.findBySender("Asiphe")).willReturn(Arrays.asList(chat1));

        mockMvc.perform(get("/api/chats/sender/user1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].sender").value("Asiphe"));
    }

    @Test
    public void testGetChatsByReceiver() throws Exception {
        given(chatService.findByReceiver("Masilangwe")).willReturn(Arrays.asList(chat1));

        mockMvc.perform(get("/api/chats/receiver/user2")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].receiver").value("Masilangwe"));
    }

    @Test
    public void testGetChatsBySenderAndReceiver() throws Exception {
        given(chatService.findBySenderAndReceiver("Asiphe", "Masilangwe")).willReturn(Arrays.asList(chat1));

        mockMvc.perform(get("/api/chats/search")
                        .param("sender", "Asiphe")
                        .param("receiver", "Masilangwe")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].sender").value("Asiphe"))
                .andExpect(jsonPath("$[0].receiver").value("Masilangwe"));
    }
}
