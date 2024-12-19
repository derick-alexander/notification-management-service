package com.cmm707.meditrack.notification_management_service.controller;

import com.cmm707.meditrack.notification_management_service.model.Notification;
import com.cmm707.meditrack.notification_management_service.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing notifications.
 */
@RestController
@RequestMapping("/api/notifications")
@RequiredArgsConstructor
@Slf4j
public class NotificationController {
    private final NotificationService notificationService;

    @PostMapping
    public ResponseEntity<Notification> createNotification(@RequestBody Notification notification) {
        log.info("API call to create a new notification");
        return ResponseEntity.ok(notificationService.createNotification(notification));
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<Notification>> getNotificationsByPatient(@PathVariable String patientId) {
        log.info("API call to fetch notifications for patient ID: {}", patientId);
        return ResponseEntity.ok(notificationService.getNotificationsByPatient(patientId));
    }

    @GetMapping("/pending")
    public ResponseEntity<List<Notification>> getPendingNotifications() {
        log.info("API call to fetch all pending notifications");
        return ResponseEntity.ok(notificationService.getPendingNotifications());
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Void> updateNotificationStatus(@PathVariable String id, @RequestParam String status) {
        log.info("API call to update notification status for ID: {}", id);
        notificationService.updateNotificationStatus(id, status);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotification(@PathVariable String id) {
        log.info("API call to delete notification with ID: {}", id);
        notificationService.deleteNotification(id);
        return ResponseEntity.noContent().build();
    }
}
