package com.cmm707.meditrack.notification_management_service.service;

import com.cmm707.meditrack.notification_management_service.model.Notification;

import java.util.List;

/**
 * Service interface defining methods for managing notifications.
 */
public interface NotificationService {
    Notification createNotification(Notification notification);
    List<Notification> getNotificationsByPatient(String patientId);
    List<Notification> getPendingNotifications();
    void updateNotificationStatus(String id, String status);
    void deleteNotification(String id);
}
