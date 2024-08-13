package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Chat;

import java.util.List;

    @Repository
    public interface ChatRepository extends JpaRepository<Chat, Long> {
        List<Chat> findBySender(String sender);
        List<Chat> findByReceiver(String receiver);
        List<Chat> findBySenderAndReceiver(String sender, String receiver);
        List<Chat> findByTimestampBetween(String startTimestamp, String endTimestamp);
    }
