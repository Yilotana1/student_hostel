package org.example.student_hostel.service;


import org.example.student_hostel.domain.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.example.student_hostel.domain.User;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class MailSenderService {


    @Value("${spring.mail.username}")
    private String username;

    private JavaMailSender mailSender;

    private UserService userService;


    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }


    public void send(String emailTo, String subject, String message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setFrom(username);
        mailMessage.setTo(emailTo);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);

        mailSender.send(mailMessage);
    }

    public void send(List<User> emailTo, String subject, String message) {
        List<String> emails = emailTo
                .stream()
                .map(User::getEmail)
                .collect(Collectors.toList());



        for (String email : emails) {

            new Thread(new Runnable() {
                @Override
                public void run() {
                    if (email != null && !email.isEmpty()) {
                        send(email, subject, message);
                    }
                }
            }).start();

        }
    }

    public void sendNotificationToStudents(Notification notification) {
        List<User> users = userService.loadStudents();

        send(users, notification.getTitle(), notification.getText());
    }
}
