package org.example.student_hostel.controller;


import org.example.student_hostel.domain.UserRole;
import org.example.student_hostel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.example.student_hostel.domain.User;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class RegistrationController {


    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Value("${upload.path}")
    String photoPath;

    @GetMapping("/registration")
    public String showRegisterPage() {
        return "registration";
    }

    @PostMapping("/registration")
    public String register(
            @Valid User user,
            @RequestParam MultipartFile file) throws IOException {
        System.out.println("START");

        String photoName = UUID.randomUUID() + "." + file.getOriginalFilename();
        user.setPhotoName(photoName);
        user.setRole(UserRole.getStudentRole());

        userService.createUser(user);

        ControllerUtils.createDirIfNotExist(photoPath);

        file.transferTo(new File(photoPath + "/" + photoName));

        System.out.println("END");
        return "login";

    }

}
