package za.ac.cput.service;

import za.ac.cput.domain.Chat;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface IChatService /*extends IService<Chat, Long>*/ {
    Chat create(Chat chat);

    Optional<Chat> findById(Long chatId);

    List<Chat> findAll();

    Chat update(Long chatId, Chat chat);

    void deleteById(Long chatId);

    List<Chat> findBySender(String sender);
    List<Chat> findByReceiver(String receiver);
    List<Chat> findBySenderAndReceiver(String sender, String receiver);
    List<Chat> findByTimestampBetween(String startTimestamp, String endTimestamp);
}
