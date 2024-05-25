package za.ac.cput.service;

import za.ac.cput.domain.Chat;

import java.util.List;
public interface IChatService extends IService<Chat, Long> {
    List<Chat> findBySender(String sender);
    List<Chat> findByReceiver(String receiver);
    List<Chat> findBySenderAndReceiver(String sender, String receiver);
    List<Chat> findByTimestampBetween(String startTimestamp, String endTimestamp);
}
