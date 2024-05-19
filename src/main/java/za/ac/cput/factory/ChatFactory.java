package za.ac.cput.factory;
//nasiphi sunduza 222499028

import za.ac.cput.domain.Chat;


public class ChatFactory {

    public static Chat createChat(String sender, String receiver, String message, String timestamp) {
        // Validate the parameters (optional, depending on your requirements)
        if (sender == null || sender.isEmpty()) {
            throw new IllegalArgumentException("Sender cannot be null or empty");
        }
        if (receiver == null || receiver.isEmpty()) {
            throw new IllegalArgumentException("Receiver cannot be null or empty");
        }
        if (message == null || message.isEmpty()) {
            throw new IllegalArgumentException("Message cannot be null or empty");
        }
        if (timestamp == null || timestamp.isEmpty()) {
            throw new IllegalArgumentException("Timestamp cannot be null or empty");
        }


        return new Chat.Builder()
                .setSender(sender)
                .setReceiver(receiver)
                .setMessage(message)
                .setTimestamp(timestamp)
                .build();
    }
}