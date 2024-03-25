package za.ac.cput.domain;

/* Notification.java
   Notification model class
   Author: Leonard Gabriel Langa (221069054)
   Date: 23 March 2024
*/

import java.util.Objects;

public class Notification
{
    private String notificationId;
    private String content;
    private String notificationType;
    private String receiverId;
    private String senderId;
    private String associatedEntityId;

    private Notification(){}

    private Notification(Builder builder)
    {
        this.notificationId = builder.notificationId;
        this.content = builder.content;
        this.notificationType = builder.notificationType;
        this.receiverId = builder.receiverId;
        this.senderId = builder.senderId;
        this.associatedEntityId = builder.associatedEntityId;
    }

    public String getNotificationId()
    {
        return notificationId;
    }

    public String getContent()
    {
        return content;
    }

    public String getNotificationType()
    {
        return notificationType;
    }

    public String getReceiverId()
    {
        return receiverId;
    }

    public String getSenderId()
    {
        return senderId;
    }

    public String getAssociatedEntityId()
    {
        return associatedEntityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Notification that)) return false;
        return Objects.equals(notificationId, that.notificationId) && Objects.equals(content, that.content) && Objects.equals(notificationType, that.notificationType) && Objects.equals(receiverId, that.receiverId) && Objects.equals(senderId, that.senderId) && Objects.equals(associatedEntityId, that.associatedEntityId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(notificationId, content, notificationType, receiverId, senderId, associatedEntityId);
    }

    @Override
    public String toString() {
        return "Notification{" +
                "notificationId='" + notificationId + '\'' +
                ", content='" + content + '\'' +
                ", notificationType='" + notificationType + '\'' +
                ", receiverId='" + receiverId + '\'' +
                ", senderId='" + senderId + '\'' +
                ", associatedEntityId='" + associatedEntityId + '\'' +
                '}';
    }

    public static class Builder
    {
        private String notificationId;
        private String content;
        private String notificationType;
        private String receiverId;
        private String senderId;
        private String associatedEntityId;

        public Builder setNotificationId(String notificationId) {
            this.notificationId = notificationId;
            return this;
        }

        public Builder setContent(String content) {
            this.content = content;
            return this;
        }

        public Builder setNotificationType(String notificationType) {
            this.notificationType = notificationType;
            return this;
        }

        public Builder setReceiverId(String receiverId) {
            this.receiverId = receiverId;
            return this;
        }

        public Builder setSenderId(String senderId) {
            this.senderId = senderId;
            return this;
        }

        public Builder setAssociatedEntityId(String associatedEntityId) {
            this.associatedEntityId = associatedEntityId;
            return this;
        }

        public Builder copy(Notification n)
        {
            this.notificationId = n.notificationId;
            this.content = n.content;
            this.notificationType = n.notificationType;
            this.receiverId = n.receiverId;
            this.senderId = n.senderId;
            this.associatedEntityId = n.associatedEntityId;
            return this;
        }

        public Notification build(){return new Notification(this);}
    }


}
