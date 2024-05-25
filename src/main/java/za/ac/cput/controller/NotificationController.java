package za.ac.cput.controller;
/* NotificationController.java
NotificationController Class
Author: Leonard Gabriel Langa (221069054)
Date: 24 May 2024
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Notification;
import za.ac.cput.service.NotificationService;
import za.ac.cput.service.UserprofileService;

import java.util.Set;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    @Autowired
    public UserprofileService userprofileService;

    @Autowired
    private NotificationService notificationService;

    @PostMapping("/create")
    public Notification create(@RequestBody Notification notification)
    {
        userprofileService.create(notification.getUserProfile());
        return notificationService.create(notification);
    }

    @GetMapping("/read/{notificationId}")
    public Notification read(@PathVariable Long notificationId)
    {
        return notificationService.read(notificationId);
    }

    @PostMapping("/update")
    public Notification update(@RequestBody Notification notification){
        userprofileService.create(notification.getUserProfile());
        return notificationService.create(notification);
    }

    @DeleteMapping("/delete/{notificationId}")
    public void delete(@PathVariable Long notificationId){
        notificationService.delete(notificationId);
    }

    @GetMapping("/getall")
    public Set<Notification> getAll()
    {
        return  notificationService.getAll();
    }

}
