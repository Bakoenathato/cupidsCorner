package za.ac.cput.factory;

/* NotificationFactory.java
   NotificationFactory class
   Author: Leonard Gabriel Langa (221069054)
   Date: 23 March 2024
*/

import za.ac.cput.domain.Notification;
import za.ac.cput.util.Helper;

public class NotificationFactory
{
    public static Notification buildNotification(String notificationId, String content, String notificationType, String receiveId, String senderId, String associatedEntityId)
    {
        if (Helper.isNullOrEmpty(notificationId) || Helper.isNullOrEmpty(content) || Helper.isNullOrEmpty(notificationType) || Helper.isNullOrEmpty(senderId) || Helper.isNullOrEmpty(receiveId) || Helper.isNullOrEmpty(associatedEntityId))
            return null;

        return new Notification.Builder().setNotificationId(notificationId)
                .setContent(content)
                .setNotificationType(notificationType)
                .setSenderId(senderId)
                .setReceiverId(receiveId)
                .setAssociatedEntityId(associatedEntityId)
                .build();
    }

    public static Notification buildNotification(String content, String notificationType, String receiverId, String senderId, String associatedEntityId)
    {
        if (Helper.isNullOrEmpty(content) || Helper.isNullOrEmpty(notificationType) || Helper.isNullOrEmpty(senderId) || Helper.isNullOrEmpty(receiverId) || Helper.isNullOrEmpty(associatedEntityId))
            return null;

        String notificationId = Helper.generateId();
        return new Notification.Builder().setNotificationId(notificationId)
                .setContent(content)
                .setNotificationType(notificationType)
                .setSenderId(senderId)
                .setReceiverId(receiverId)
                .setAssociatedEntityId(associatedEntityId)
                .build();
    }

}
