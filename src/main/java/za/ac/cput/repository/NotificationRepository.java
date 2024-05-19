package za.ac.cput.repository;

/* NotificationRepository.java
NotificationRepository Interface
Author: Leonard Gabriel Langa (221069054)
Date: 17 May 2024
*/

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification,Long> {
}
