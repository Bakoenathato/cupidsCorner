package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Chat;

import java.util.List;

public class ChatRepository {
    @Repository
    public interface ChatRepository1 extends JpaRepository<Chat, Long> {
        List<Chat> findBySender(String sender);
        List<Chat> findByReceiver(String receiver);
        List<Chat> findBySenderAndReceiver(String sender, String receiver);
        List<Chat> findByTimestampBetween(String startTimestamp, String endTimestamp);
    }
}
