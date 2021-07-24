package org.example.student_hostel.repo;

import org.example.student_hostel.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {




}
