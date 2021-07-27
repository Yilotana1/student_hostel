package org.example.student_hostel.controller;


import org.example.student_hostel.domain.UserRole;
import org.example.student_hostel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.example.student_hostel.domain.User;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static org.example.student_hostel.controller.ControllerUtils.getErrors;

@Controller
public class RegistrationController {


    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Value("${upload.path}")
    String uploadPath;

    @GetMapping("/registration")
    public String showRegisterPage() {
        return "registration";
    }

    @PostMapping("/registration")
    public String register(
            @RequestParam MultipartFile file,
            @Valid User user,
            BindingResult bindingResult,
            Model model) throws IOException {


        if (bindingResult.hasErrors()) {
            Map<String, String> errors = getErrors(bindingResult);
            model.mergeAttributes(errors);
            System.out.println(errors);
            return "registration";
        }

        String photoName = UUID.randomUUID() + "." + file.getOriginalFilename();
        user.setPhotoName(photoName);
        user.setRole(UserRole.getStudentRole());

        userService.createUser(user);

        ControllerUtils.createDirIfNotExist(uploadPath);

        file.transferTo(new File(uploadPath + "/" + photoName));

        return "login";

    }



}
