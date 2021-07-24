package org.example.student_hostel.repo;

import org.example.student_hostel.domain.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApartmentRepo extends JpaRepository<Apartment, Long> {
}
