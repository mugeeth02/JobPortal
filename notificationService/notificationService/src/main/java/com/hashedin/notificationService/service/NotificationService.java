package com.hashedin.notificationService.service;

import com.hashedin.notificationService.entity.Notification;

import java.util.List;

public interface NotificationService {
    List<Notification> getAllNotifications();
    Notification getNotificationById(int id);
    Notification createNotification(Notification notification);
    Notification updateNotification(Notification notification,int id);
    void deleteNotification(int id);
}
