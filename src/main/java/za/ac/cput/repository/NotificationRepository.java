package za.ac.cput.repository;

/* NotificationRepository.java
   NotificationRepository class
   Author: Leonard Gabriel Langa (221069054)
   Date: 26 March 2024
*/

import za.ac.cput.domain.Notification;

import java.util.ArrayList;
import java.util.List;

public class NotificationRepository implements INotificationRepository
{

    private static INotificationRepository repository = null;
    private final List<Notification> notificationList;

    private NotificationRepository()
    {
        notificationList = new ArrayList<>();
    }

    public static INotificationRepository getRepository()
    {
        if (repository == null)
        {
            repository = new NotificationRepository();
        }
        return repository;

    }


    @Override
    public Notification create(Notification notification)
    {
        boolean success = notificationList.add(notification);
        if (success)
            return notification;
        return null;
    }

    @Override
    public Notification read(String id)
    {
        for (Notification notification : notificationList)
        {
            if (notification.getNotificationId().equals(id)){
                return notification;
            }
        }
        return null;
    }

    @Override
    public Notification update(Notification notification)
    {
        String notificationId = notification.getNotificationId();
        Notification notificationCode = read(notificationId);
        if (notificationCode == null)
            return null;
        if (delete(notificationId)){
            if (notificationList.add(notification))
                return notification;
            else
                return null;
        }
        return null;
    }

    @Override
    public boolean delete(String id)
    {
        Notification deleteNotification = read(id);

        if (deleteNotification == null)
            return false;
        return notificationList.remove(deleteNotification);
    }

    @Override
    public List<Notification> getAll()
    {
        return notificationList;
    }
}
