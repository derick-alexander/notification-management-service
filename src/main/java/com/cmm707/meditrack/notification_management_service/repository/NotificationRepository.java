package com.cmm707.meditrack.notification_management_service.repository;

import com.cmm707.meditrack.notification_management_service.model.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for managing Notification entities in MongoDB.
 */
@Repository
public interface NotificationRepository extends MongoRepository<Notification, String> {
    List<Notification> findByPatientId(String patientId);
    List<Notification> findByStatus(String status);
}
