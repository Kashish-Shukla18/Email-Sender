package com.emaildemo.SpringEmailProject.controller;

import com.emaildemo.SpringEmailProject.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/send-email")
@CrossOrigin(origins = "http://localhost:3000")
public class EmailController {

    @Autowired
    private EmailSenderService emailSenderService;

    @PostMapping
    public ResponseEntity<Map<String, String>> sendEmail(@RequestBody EmailRequest emailRequest) {
        emailSenderService.sendEmail(emailRequest.getToEmail(),
                emailRequest.getSubject(),
                emailRequest.getBody());
        Map<String, String> response = new HashMap<>();
        response.put("message", "Email sent successfully!");
        return ResponseEntity.ok(response);
    }

}

class EmailRequest {
    private String toEmail;
    private String subject;
    private String body;

    // Getters and setters
    public String getToEmail() {
        return toEmail;
    }

    public void setToEmail(String toEmail) {
        this.toEmail = toEmail;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
