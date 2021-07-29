package org.example.student_hostel.controller;


import org.example.student_hostel.domain.Notification;
import org.example.student_hostel.domain.User;
import org.example.student_hostel.service.MailSenderService;
import org.example.student_hostel.service.NotificationsService;
import org.example.student_hostel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;


@Controller
@RequestMapping("/notifications")
public class NotificationsController {

    private NotificationsService notificationsService;
    private MailSenderService mailSenderService;
    private UserService userService;

    @Autowired
    public void setNotificationsService(NotificationsService notificationsService) {
        this.notificationsService = notificationsService;
    }

    @Autowired
    public void setMailSenderService(MailSenderService mailSenderService) {
        this.mailSenderService = mailSenderService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String showNotifications(Model model) {
        model.addAttribute("notifications", notificationsService.getAllNotifications());
        return "notifications";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/create")
    public String showCreateNotificationPage() {
        return "notification_form";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/create")
    public String createNotification(
            @AuthenticationPrincipal User user,
            @Valid Notification notification,
            BindingResult bindingResult,
            Model model,
            @RequestParam(required = false, name = "sendEmail") String sendEmail
    ) {

        if (bindingResult.hasErrors()) {
            Map<String, String> errors = ControllerUtils.getErrors(bindingResult);
            model.mergeAttributes(errors);
            return "notification_form";
        }

        notification.setAuthor(user);
        if (sendEmail != null) {

            mailSenderService.sendNotificationToStudents(notification);
        }

        notificationsService.createNotification(notification);
        return "redirect:/notifications";
    }


    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/delete/{id}")
    public String deleteNotification(
            @PathVariable("id") Notification notification
    ) {
        notificationsService.delete(notification);
        return "redirect:/notifications";
    }
}
