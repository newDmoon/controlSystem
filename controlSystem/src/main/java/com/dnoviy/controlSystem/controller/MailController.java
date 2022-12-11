package com.dnoviy.controlSystem.controller;

import com.dnoviy.controlSystem.pojo.MailRequest;
import com.dnoviy.controlSystem.service.EmailServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mail")
@CrossOrigin(origins = "*", maxAge = 3600)
@PreAuthorize("hasRole('CLIENT') or hasRole('ADMIN')")
public class MailController {
    private final EmailServiceImpl emailService;

    public MailController(EmailServiceImpl emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/send")
    public ResponseEntity<?> sendMail(@RequestBody MailRequest mailRequest){
        return new ResponseEntity<>(emailService.sendEmail(mailRequest), HttpStatus.OK);
    }

}
