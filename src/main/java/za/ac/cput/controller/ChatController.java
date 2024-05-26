package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Chat;
import za.ac.cput.service.ChatService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/chats")
public class ChatController {

    private final ChatService chatService;

    @Autowired
    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping
    public Chat createChat(@RequestBody Chat chat) {
        return chatService.save(chat);
    }

    @GetMapping("/{id}")
    public Optional<Chat> getChatById(@PathVariable Long id) {
        return chatService.findById(id);
    }

    @GetMapping
    public List<Chat> getAllChats() {
        return chatService.findAll();
    }

    @PutMapping("/{id}")
    public Chat updateChat(@PathVariable Long id, @RequestBody Chat chat) {
        return chatService.update(id, chat);
    }

    @DeleteMapping("/{id}")
    public void deleteChat(@PathVariable Long id) {
        chatService.deleteById(id);
    }

    @GetMapping("/sender/{sender}")
    public List<Chat> getChatsBySender(@PathVariable String sender) {
        return chatService.findBySender(sender);
    }

    @GetMapping("/receiver/{receiver}")
    public List<Chat> getChatsByReceiver(@PathVariable String receiver) {
        return chatService.findByReceiver(receiver);
    }

    @GetMapping("/search")
    public List<Chat> getChatsBySenderAndReceiver(@RequestParam String sender, @RequestParam String receiver) {
        return chatService.findBySenderAndReceiver(sender, receiver);
    }
}
