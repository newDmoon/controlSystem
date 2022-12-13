package com.dnoviy.controlSystem.service;

import com.dnoviy.controlSystem.pojo.MailRequest;

public interface EmailService {
    String sendEmail(MailRequest mailRequest);
}
