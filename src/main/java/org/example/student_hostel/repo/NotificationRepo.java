package org.example.student_hostel.repo;

import org.example.student_hostel.domain.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepo extends JpaRepository<Notification, Long> {
}
