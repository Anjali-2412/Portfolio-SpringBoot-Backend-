package com.anjali.portfolio.Controller;

import com.anjali.portfolio.DTO.ContactRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins = "*")
public class ContactContoller {

    @Autowired
    private JavaMailSender javaMailSender;

    @PostMapping
    public ResponseEntity<String> sendMessage(@RequestBody ContactRequest request){
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo("jainanjali5544@gmail.com");
            message.setSubject("New Contact Form Submission");
            message.setText(

                    "Name: " + request.getName() + "\n" +
                            "Email: " + request.getEmail() + "\n\n" +
                            request.getMessage()
            );
            javaMailSender.send(message);
            return ResponseEntity.ok("Message sent successfully!");
        }
        catch (Exception e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to send message");
        }

    }
    }



