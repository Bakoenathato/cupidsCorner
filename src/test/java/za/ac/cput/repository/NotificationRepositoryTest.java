package za.ac.cput.repository;

/* NotificationRepositoryTest.java
   NotificationRepositoryTest class
   Author: Leonard Gabriel Langa (221069054)
   Date: 26 March 2024
*/

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Notification;
import za.ac.cput.factory.NotificationFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class NotificationRepositoryTest
{

    private INotificationRepository repository = NotificationRepository.getRepository();

    private Notification notification = NotificationFactory.buildNotification("301","You have been matched with User210","match","208","209","500");

    @Test
    @Order(1)
    void create()
    {
        Notification created = repository.create(notification);
        assertNotNull(created);
        System.out.println(created);
    }

    @Test
    @Order(2)
    void read()
    {
        String notificationId  = notification.getNotificationId();
        Notification read = repository.read(notificationId);
        assertNotNull(read);
        System.out.println(read);

    }

    @Test
    @Order(3)
    void update()
    {
        Notification updated = repository.update(new Notification.Builder().copy(notification).setContent("You have been matched with User209").build());
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    @Order(5)
    void delete()
    {
        assertTrue(repository.delete(notification.getNotificationId()));
        System.out.println("Success : notification deleted");

    }

    @Test
    @Order(4)
    void getAll()
    {
        System.out.println(repository.getAll());

    }
}