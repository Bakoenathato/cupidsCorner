package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Notification;
import za.ac.cput.repository.*;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class NotificationService implements INotificationService{
    public UserprofileRepository userprofileRepository;
    public NotificationRepository notificationRepository;

    @Autowired
    NotificationService(UserprofileRepository userprofileRepository, NotificationRepository notificationRepository){
        this.userprofileRepository = userprofileRepository;
        this.notificationRepository = notificationRepository;
    }

    @Override
    public Notification create(Notification notification) {
        userprofileRepository.save(notification.getUserProfile());
        return notificationRepository.save(notification);
    }

    @Override
    public Notification read(Long notificationId) {
        return notificationRepository.findById(notificationId).orElse(null);
    }

    @Override
    public Notification update(Notification notification) {
        userprofileRepository.save(notification.getUserProfile());
        return notificationRepository.save(notification);
    }

    @Override
    public void delete(Long notificationId) {
        notificationRepository.deleteById(notificationId);
    }

    @Override
    public Set<Notification> getAll() {
        return notificationRepository.findAll().stream().collect(Collectors.toSet());
    }
}
