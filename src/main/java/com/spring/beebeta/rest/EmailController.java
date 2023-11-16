package com.spring.beebeta.rest;

import com.spring.beebeta.request.EmailRequest;
import com.spring.beebeta.service.EmailService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/sendmail")
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping
    public void sendHtmlEmail(@RequestBody EmailRequest emailRequest) {
        emailService.sendHtmlMessage(emailRequest.getTo(), emailRequest.getSubject(), emailRequest.getBodyHtml());
    }
}
