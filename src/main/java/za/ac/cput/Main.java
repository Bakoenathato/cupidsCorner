package za.ac.cput;

import za.ac.cput.domain.Notification;
import za.ac.cput.factory.NotificationFactory;

public class Main
{
    public static void main(String[] args)
    {
        Notification notification1 = NotificationFactory.buildNotification("You have been matched with User231", "match","255","231","106");
        System.out.println(notification1.toString());

        Notification notification2 = NotificationFactory.buildNotification("222","You have a message from User275 **Message : Hello **", "Message","205","275","105");
        System.out.println(notification2.toString());

    }
}
