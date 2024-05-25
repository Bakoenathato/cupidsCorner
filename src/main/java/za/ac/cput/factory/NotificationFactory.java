package za.ac.cput.factory;

/* NotificationFactory.java
NotificationFactory class
Author: Leonard Gabriel Langa (221069054)
Date: 17 May 2024
*/
import za.ac.cput.domain.*;
import za.ac.cput.util.Helper;

import java.time.LocalDateTime;
import java.util.Set;

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

    public static Notification buildNotification(long notificationId, String content, NotificationType type, String profileId, User userId,
                                                 String interests, boolean profileVisibility, LocalDateTime createdAt, Location locationId,
                                                 Preference preferenceId, Like likes){
        if (Helper.isZeroOrLess(notificationId) || Helper.isNullOrEmpty(content) || type == null ||
                Helper.isNullOrEmpty(profileId) || userId == null || Helper.isNullOrEmpty(interests) || !profileVisibility ||
                createdAt == null || locationId == null || preferenceId == null || likes == null)
            return null;

        UserProfile useProfile = UserprofileFactory.createUser(profileId, userId, interests, true, createdAt,
                locationId, preferenceId, likes);
        return new Notification.Builder()
                .setNotificationId(notificationId)
                .setContent(content)
                .setType(type)
                .setUserProfile(useProfile)
                .build();
    }

    public static Notification buildNotification(String content, NotificationType type, String profileId, User userId,
                                                 String interests, boolean profileVisibility, LocalDateTime createdAt,
                                                 Location locationId,Preference preferenceId, Like likes){
        if (Helper.isNullOrEmpty(content) || type == null || Helper.isNullOrEmpty(profileId) || userId == null ||
                Helper.isNullOrEmpty(interests) || !profileVisibility || createdAt == null || locationId == null || preferenceId == null ||
                likes == null)
            return null;

        long notificationId = Helper.generateLongId();
        UserProfile useProfile = UserprofileFactory.createUser(profileId, userId, interests, true, createdAt,locationId,
                preferenceId, likes);
        return new Notification.Builder()
                .setNotificationId(notificationId)
                .setContent(content)
                .setType(type)
                .setUserProfile(useProfile)
                .build();
    }

}
