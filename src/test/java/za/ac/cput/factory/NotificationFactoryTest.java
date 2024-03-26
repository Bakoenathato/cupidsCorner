package za.ac.cput.factory;
/*
   NotificationFactoryTest.java
   NotificationFactoryTest  class
   Author: Leonard Gabriel Langa (221069054)
   Date: 23 March 2024
*/

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Notification;

import static org.junit.jupiter.api.Assertions.*;

class NotificationFactoryTest
{


    @Test
    void firstTestBuildNotification()
    {
        Notification notification = NotificationFactory.buildNotification("300","You have a message from User200 **Message : Hello, how are you doing**", "Message","201","200","100");
        assertNotNull(notification);
        System.out.println(notification);
    }

    @Test
    void firstTestBuildNotificationWithFail()
    {
        Notification notification = NotificationFactory.buildNotification("","You have been matched with User202","match","203","202","500");
        assertNotNull(notification);
        System.out.println(notification);
    }

    @Test
    void secondTestBuildNotification()
    {
        Notification notification = NotificationFactory.buildNotification("You have been matched with User204", "match","205","204","500");
        assertNotNull(notification);
        System.out.println(notification);
    }

    @Test
    void secondTestBuildNotificationWithFail()
    {
        Notification notification = NotificationFactory.buildNotification("You have been matched with User---", "match","207","","500");
        assertNotNull(notification);
        System.out.println(notification);
    }
}