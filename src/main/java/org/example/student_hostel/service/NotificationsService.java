package org.example.student_hostel.service;


import org.example.student_hostel.domain.Notification;
import org.example.student_hostel.repo.NotificationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationsService {

    private NotificationRepo notificationRepo;


    @Autowired
    public void setNotificationRepo(NotificationRepo notificationRepo) {
        this.notificationRepo = notificationRepo;
    }

    public List<Notification> getAllNotifications() {
        return notificationRepo.findAll();
    }

    public void createNotification(Notification notification) {
        notificationRepo.save(notification);
    }


    public void delete(Notification notification) {
        notificationRepo.delete(notification);
    }
}
