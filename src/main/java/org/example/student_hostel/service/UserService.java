package org.example.student_hostel.service;

import org.example.student_hostel.domain.User;
import org.example.student_hostel.domain.UserRole;
import org.example.student_hostel.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {


    private UserRepo userRepo;

    @Autowired
    public void setUserRepo(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws BadCredentialsException {
        UserDetails user = userRepo.findByUsername(username);
        if (user == null) {
            throw new BadCredentialsException("Користувача не знайдено");
        }

        return userRepo.findByUsername(username);
    }

    public List<User> loadAdmins(){
        return userRepo.findByUserRole(UserRole.getAdminRole());
    }
}
