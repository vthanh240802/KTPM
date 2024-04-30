package com.edu.iuh.fit.ms.service;

public interface EmailService {
    void sendEmail(String recipient, String subject, String body);
}
