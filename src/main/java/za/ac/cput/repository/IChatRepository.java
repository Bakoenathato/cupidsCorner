package za.ac.cput.repository;
// nasiphi sunduza 222499028
import za.ac.cput.domain.Chat;

import java.util.List;
public interface IChatRepository extends IRepository<Chat, String> {
    Chat create(Chat chat);

    Chat read(String receiver);

    Chat update(Chat chat);

    boolean delete(String sender);

    List <Chat>getAll();
}
