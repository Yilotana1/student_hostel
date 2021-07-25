package org.example.student_hostel.repo;

import org.example.student_hostel.domain.User;
import org.example.student_hostel.domain.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {

    User findByUsername(String username);

    List<User> findByUserRole(UserRole userRole);

}
