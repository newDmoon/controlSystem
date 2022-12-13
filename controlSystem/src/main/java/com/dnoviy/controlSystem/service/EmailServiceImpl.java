package com.dnoviy.controlSystem.service;

import com.dnoviy.controlSystem.pojo.MailRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {
    private final JavaMailSender mailSender;
    @Value("${spring.mail.username}")
    private String mailFromUsername;
    @Value("${spring.mail.toName}")
    private String mailToName;


    public EmailServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public String sendEmail(MailRequest mailRequest) {
        CurrentUserInfoService currentUserInfoService = new CurrentUserInfoService();
        SimpleMailMessage messageToUserMail = new SimpleMailMessage();
        messageToUserMail.setFrom(mailFromUsername);
        messageToUserMail.setTo(mailToName);
        messageToUserMail.setText(mailRequest.getBody() + "\nСообщение отправлено пользователем  " +
                currentUserInfoService.getCurrentUsername());
        messageToUserMail.setSubject(mailRequest.getSubject());

        mailSender.send(messageToUserMail);

        return "Сообщение успешно отправлено";
    }
}
