package za.ac.cput;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import za.ac.cput.domain.Chat;
import za.ac.cput.domain.Notification;
import za.ac.cput.factory.ChatFactory;
import za.ac.cput.factory.NotificationFactory;


@SpringBootApplication
public class Main
{
    public static void main(String[] args)
    {
        SpringApplication.run(Main.class, args);
    }
}
