package com.hashedin.notificationService.service;

import com.hashedin.notificationService.entity.Notification;
import com.hashedin.notificationService.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {
    @Autowired
    private NotificationRepository repo;

    @Override
    public List<Notification> getAllNotifications() {
        return repo.findAll();
    }

    @Override
    public Notification getNotificationById(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Notification createNotification(Notification notification) {
        return repo.save(notification);
    }

    @Override
    public Notification updateNotification(Notification notification, int id) {
        Notification oldNotification = repo.findById(id).orElse(null);
        oldNotification.setJobId(notification.getJobId());
        oldNotification.setCandidateId(notification.getCandidateId());
        oldNotification.setNotification(notification.getNotification());
        return repo.save(oldNotification);
    }

    @Override
    public void deleteNotification(int id) {
        repo.deleteById(id);
    }
}
