package com.cmm707.meditrack.notification_management_service.model;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

/**
 * Entity class representing notification details stored in the database.
 */
@Data
@Document(collection = "notifications")
public class Notification {
    @Id
    private String id; // Unique identifier for the notification.

    @NotBlank
    private String patientId; // ID of the patient to whom the notification is sent.

    @NotBlank
    private String message; // Notification message content.

    @FutureOrPresent
    private LocalDateTime scheduledTime; // Time when the notification is scheduled to be sent.

    @NotBlank
    private String status; // Status of the notification (e.g., Pending, Sent, Failed).

    @CreatedDate
    private LocalDateTime createdAt; // Timestamp when the notification record was created.
}
