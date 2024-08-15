package com.hashedin.notificationService.controller;

import com.hashedin.notificationService.entity.Notification;
import com.hashedin.notificationService.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notifications")
public class NotificationController {
    @Autowired
    private NotificationService service;

    @GetMapping
    public List<Notification> getAllNotifications(){
        List<Notification> allNotifications = service.getAllNotifications();
        return allNotifications;
    }

    @GetMapping("/{id}")
    public Notification getNotificationById(@PathVariable int id){
        Notification notificationById = service.getNotificationById(id);
        return notificationById;
    }

    @PostMapping
    public Notification createNotification(@RequestBody Notification notification){
        Notification notification1 = service.createNotification(notification);
        return notification1;
    }

    @PutMapping("/{id}")
    public Notification updateNotification(@PathVariable int id,@RequestBody Notification notification){
        Notification notification1 = service.updateNotification(notification, id);
        return notification1;
    }

    @DeleteMapping("/{id}")
    public void deleteNotification(@PathVariable int id){
        service.deleteNotification(id);
    }
}
