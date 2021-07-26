package org.example.student_hostel.controller;


import org.example.student_hostel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {


    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/")
    public String showMain(Model model) {
        model.addAttribute("admins", userService.loadAdmins());
        return "main";
    }



}
