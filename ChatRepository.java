package za.ac.cput.repository;
//nasiphi sunduza 222499028
import za.ac.cput.domain.Chat;

import java.util.ArrayList;
import java.util.List;

public class ChatRepository implements IChatRepository{

    private static IChatRepository repository = null;
    private List<Chat>chatList;

    private ChatRepository(){
        chatList = new ArrayList<Chat>();}

    public static IChatRepository getRepository(){
        if (repository == null){
            repository = new ChatRepository();
        }
        return repository;
    }

    @Override
    public Chat create (Chat chat){
        boolean success = chatList.add(chat);
        if (success)
            return chat;
        else
            return null;
    }



    @Override
    public Chat read(String receiver){
        for (Chat c : chatList){
            if (c.getReceiver().equals(receiver))
                return c;
        }
        return null;
    }



    @Override
    public Chat update(Chat chat){
        String sender = chat.getSender();
        Chat existingChat = read(sender);
        if (existingChat == null)
            return null;
        if (delete(sender)){
            if (chatList.add(chat))
                return chat;
            return null;
        }
        return null;
    }

    @Override
    public boolean delete(String sender){
        Chat chatDelete = read(sender);
        if (chatDelete == null)
            return false;
            return chatList.remove(chatDelete);
        }



    @Override
    public List<Chat> getAll() {
        return null;
    }


}
