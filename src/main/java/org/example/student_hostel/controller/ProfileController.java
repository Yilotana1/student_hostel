package org.example.student_hostel.controller;


import org.example.student_hostel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.example.student_hostel.domain.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.example.student_hostel.controller.ControllerUtils.getErrors;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    @Value("${upload.path}")
    private String uploadPath;

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String showProfile(Model model) {
        List<User> users = userService.loadAdmins();
        model.addAttribute("admins", users);
        return "profile";
    }

    @PostMapping("/change_photo")
    public String changePhoto(
            @AuthenticationPrincipal User user,
            @RequestParam("file") MultipartFile file
    ) throws IOException {

        File oldPhoto = new File(uploadPath + "/" + user.getPhotoName());
        oldPhoto.delete();
        ControllerUtils.createDirIfNotExist(uploadPath);

        String newPhotoName = UUID.randomUUID() + "." + file.getOriginalFilename();
        user.setPhotoName(newPhotoName);

        userService.updateUser(user);
        file.transferTo(new File(uploadPath + "/" + newPhotoName));

        return "profile";
    }


    @PostMapping("/edit")
    public String editUser(
            @AuthenticationPrincipal User originalUser,
            @Valid User user,
            BindingResult bindingResult,
            Model model
    ) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = getErrors(bindingResult);
            model.mergeAttributes(errors);
            return "profile";
        }


        originalUser.setFirstname(user.getFirstname());
        originalUser.setLastname(user.getLastname());
        originalUser.setUsername(user.getUsername());
        originalUser.setPassword(user.getPassword());
        originalUser.setEmail(user.getEmail());
        originalUser.setPhone(user.getPhone());

        userService.updateUser(originalUser);
        return "redirect:/profile";
    }
}
