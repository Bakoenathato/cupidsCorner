package za.ac.cput.domain;

//nasiphi sunduza 222499028
import jakarta.persistence.*;

import java.util.Objects;



    @Entity

    public class Chat {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long chatId;


        private String sender;


        private String receiver;


        private String message;


        private String timestamp;

        protected Chat() {
        }

        private Chat(Builder builder) {
            this.chatId = builder.chatId;
            this.sender = builder.sender;
            this.receiver = builder.receiver;
            this.message = builder.message;
            this.timestamp = builder.timestamp;
        }


        public Long getchatId() {
            return chatId;
        }


        public String getSender() {
            return sender;
        }


        public String getReceiver() {
            return receiver;
        }

        public String getMessage() {
            return message;
        }

        public String getTimestamp() {
            return timestamp;
        }



        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Chat chat = (Chat) o;
            return Objects.equals(chatId, chat.chatId) &&
                    Objects.equals(sender, chat.sender) &&
                    Objects.equals(receiver, chat.receiver) &&
                    Objects.equals(message, chat.message) &&
                    Objects.equals(timestamp, chat.timestamp);
        }

        @Override
        public int hashCode() {
            return Objects.hash(chatId, sender, receiver, message, timestamp);
        }

        @Override
        public String toString() {
            return "Chat{" +
                    "chatId=" + chatId +
                    ", sender='" + sender + '\'' +
                    ", receiver='" + receiver + '\'' +
                    ", message='" + message + '\'' +
                    ", timestamp='" + timestamp + '\'' +
                    '}';
        }

        public static class Builder {

            private Long chatId;
            private String sender;
            private String receiver;
            private String message;
            private String timestamp;

            public Builder setChatId(Long chatId) {
                this.chatId = chatId;
                return this;
            }

            public Builder setSender(String sender) {
                this.sender = sender;
                return this;
            }

            public Builder setReceiver(String receiver) {
                this.receiver = receiver;
                return this;
            }
            public Builder setMessage(String message) {
                this.message = message;
                return this;
            }

            public Builder setTimestamp(String timestamp) {
                this.timestamp = timestamp;
                return this;
            }

            public Builder copy (Chat c) {
                this.chatId = c.chatId;
                this.sender = c.sender;
                this.receiver = c.receiver;
                this.message = c.message;
                this.timestamp = c.timestamp;
                return this;
            }
            public Chat build(){return new Chat(this);}


        }

    }

