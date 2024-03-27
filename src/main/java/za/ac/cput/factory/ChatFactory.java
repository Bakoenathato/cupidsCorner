package za.ac.cput.factory;
//nasiphi sunduza 222499028

import za.ac.cput.domain.Chat;
import za.ac.cput.util.Helper;
public class ChatFactory {

    public static Chat createChat(String sender, String receiver, String message, String timestamp ){
        if (Helper.isNullOrEmpty(sender) || Helper.isNullOrEmpty(receiver)
                || Helper.isNullOrEmpty(message) || Helper.isNullOrEmpty(timestamp))
            return null;
        return new Chat.Builder().setSender(sender)
                .setReceiver(receiver)
                .setMessage(message)
                .setTimestamp(timestamp)
                .build();
    }
}