package za.ac.cput.repository;

/* INotificationRepository.java
   INotificationRepository interface
   Author: Leonard Gabriel Langa (221069054)
   Date: 25 March 2024
*/

import za.ac.cput.domain.Notification;

import java.util.List;

public interface INotificationRepository extends IRepository <Notification,String>
{
    List<Notification> getAll();

}
