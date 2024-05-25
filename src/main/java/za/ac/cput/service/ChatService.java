package za.ac.cput.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Chat;
import za.ac.cput.repository.ChatRepository.ChatRepository1;

import java.util.List;
import java.util.Optional;

@Service
public class ChatService implements IChatService {

    private final ChatRepository1 chatRepository;

    @Autowired
    public ChatService(ChatRepository1 chatRepository) {
        this.chatRepository = chatRepository;
    }

    @Override
    public Chat save(Chat chat) {
        return chatRepository.save(chat);
    }

    @Override
    public Optional<Chat> findById(Long chatId) {
        return chatRepository.findById(chatId);
    }

    @Override
    public List<Chat> findAll() {
        return chatRepository.findAll();
    }

    @Override
    public Chat update(Long chatId, Chat chat) {
        Optional<Chat> existingChatOpt = chatRepository.findById(chatId);
        if (existingChatOpt.isPresent()) {
            Chat existingChat = existingChatOpt.get();
            Chat updatedChat = new Chat.Builder()
                    .setChatId(existingChat.getchatId())
                    .setSender(chat.getSender())
                    .setReceiver(chat.getReceiver())
                    .setMessage(chat.getMessage())
                    .setTimestamp(chat.getTimestamp())
                    .build();
            return chatRepository.save(updatedChat);
        } else {
            throw new IllegalArgumentException("Chat with ID " + chatId + " does not exist.");
        }
    }

    @Override
    public void deleteById(Long chatId) {
        chatRepository.deleteById(chatId);
    }

    @Override
    public List<Chat> findBySender(String sender) {
        return chatRepository.findBySender(sender);
    }

    @Override
    public List<Chat> findByReceiver(String receiver) {
        return chatRepository.findByReceiver(receiver);
    }

    @Override
    public List<Chat> findBySenderAndReceiver(String sender, String receiver) {
        return chatRepository.findBySenderAndReceiver(sender, receiver);
    }

    @Override
    public List<Chat> findByTimestampBetween(String startTimestamp, String endTimestamp) {
        return chatRepository.findByTimestampBetween(startTimestamp, endTimestamp);
    }
}
