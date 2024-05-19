package za.ac.cput.factory;

import za.ac.cput.domain.Notification;
import za.ac.cput.domain.NotificationType;
import za.ac.cput.util.Helper;

public class NotificationFactory {
    public static Notification buildNotification(long notificationId, String content,
                                                 NotificationType type, UserProfile userProfile){
        if(Helper.isZeroOrLess(notificationId) || Helper.isNullOrEmpty(content) || type == null || userProfile == null)
            return null;
        return new Notification.Builder().setNotificationId(notificationId)
                .setContent(content)
                .setType(type)
                .setUserProfile(userProfile)
                .build();
    }

    public static Notification buildNotification(String content, NotificationType type, UserProfile userProfile){
        if (Helper.isNullOrEmpty(content) || type == null || userProfile == null)
            return null;

        long notificationId = Helper.generateLongId();
        return new Notification.Builder().setNotificationId(notificationId)
                .setContent(content)
                .setType(type)
                .setUserProfile(userProfile)
                .build();
    }

}
