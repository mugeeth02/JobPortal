package com.hashedin.notificationService.controller;

import com.hashedin.notificationService.entity.Notification;
import com.hashedin.notificationService.exception.NotificationAlreadyExistsException;
import com.hashedin.notificationService.exception.NotificationNotFoundException;
import com.hashedin.notificationService.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notifications")
public class NotificationController {
    @Autowired
    private NotificationService service;

    @GetMapping
    public ResponseEntity<List<Notification>> getAllNotifications(){
        List<Notification> allNotifications = service.getAllNotifications();
        return new ResponseEntity<>(allNotifications, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Notification> getNotificationById(@PathVariable int id){
        try {
            Notification notificationById = service.getNotificationById(id);
            return new ResponseEntity<>(notificationById, HttpStatus.OK);
        } catch (NotificationNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Notification> createNotification(@RequestBody Notification notification){
        try {
            Notification notification1 = service.createNotification(notification);
            return new ResponseEntity<>(notification1, HttpStatus.CREATED);
        } catch (NotificationAlreadyExistsException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Notification> updateNotification(@PathVariable int id, @RequestBody Notification notification){
        try {
            Notification notification1 = service.updateNotification(notification, id);
            return new ResponseEntity<>(notification1, HttpStatus.OK);
        } catch (NotificationNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotification(@PathVariable int id){
        try {
            service.deleteNotification(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (NotificationNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}