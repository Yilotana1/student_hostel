package org.example.student_hostel.repo;

import org.example.student_hostel.domain.Floor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FloorRepo extends JpaRepository<Floor, Long> {
}
