package com.cmm707.meditrack.notification_management_service.service;

import com.cmm707.meditrack.notification_management_service.model.Notification;
import com.cmm707.meditrack.notification_management_service.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service implementation for managing notifications.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationServiceImpl implements NotificationService {
    private final NotificationRepository notificationRepository;

    @Override
    public Notification createNotification(Notification notification) {
        log.info("Creating notification for patient ID: {}", notification.getPatientId());
        return notificationRepository.save(notification);
    }

    @Override
    public List<Notification> getNotificationsByPatient(String patientId) {
        log.info("Fetching notifications for patient ID: {}", patientId);
        return notificationRepository.findByPatientId(patientId);
    }

    @Override
    public List<Notification> getPendingNotifications() {
        log.info("Fetching all pending notifications");
        return notificationRepository.findByStatus("Pending");
    }

    @Override
    public void updateNotificationStatus(String id, String status) {
        log.info("Updating notification status for ID: {}", id);
        Optional<Notification> notification = notificationRepository.findById(id);
        if (notification.isPresent()) {
            Notification updatedNotification = notification.get();
            updatedNotification.setStatus(status);
            notificationRepository.save(updatedNotification);
        } else {
            log.warn("Notification not found with ID: {}", id);
            throw new RuntimeException("Notification not found");
        }
    }

    @Override
    public void deleteNotification(String id) {
        log.info("Deleting notification with ID: {}", id);
        notificationRepository.deleteById(id);
    }
}
