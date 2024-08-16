package com.hashedin.notificationService.service;

import com.hashedin.notificationService.entity.Notification;
import com.hashedin.notificationService.exception.NotificationAlreadyExistsException;
import com.hashedin.notificationService.exception.NotificationNotFoundException;
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
        return repo.findById(id).orElseThrow(() -> new NotificationNotFoundException("Notification not found with id: " + id));
    }

    @Override
    public Notification createNotification(Notification notification) {
        if (repo.existsByJobIdAndCandidateId(notification.getJobId(), notification.getCandidateId())) {
            throw new NotificationAlreadyExistsException("Notification already exists for job id: " + notification.getJobId() + " and candidate id: " + notification.getCandidateId());
        }
        return repo.save(notification);
    }

    @Override
    public Notification updateNotification(Notification notification, int id) {
        Notification oldNotification = repo.findById(id).orElseThrow(() -> new NotificationNotFoundException("Notification not found with id: " + id));
        oldNotification.setJobId(notification.getJobId());
        oldNotification.setCandidateId(notification.getCandidateId());
        oldNotification.setNotification(notification.getNotification());
        return repo.save(oldNotification);
    }

    @Override
    public void deleteNotification(int id) {
        if (!repo.existsById(id)) {
            throw new NotificationNotFoundException("Notification not found with id: " + id);
        }
        repo.deleteById(id);
    }
}