package com.portfolio.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.portfolio.model.ContactRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins = "*")
public class ContactController {

    @PostMapping
    public ResponseEntity<?> submitContact(@RequestBody ContactRequest contactRequest) {
        try {
            // Here you can add your logic to save the contact request or send email
            System.out.println("Received contact request from: " + contactRequest.getName());
            System.out.println("Email: " + contactRequest.getEmail());
            System.out.println("Message: " + contactRequest.getMessage());
            
            Map<String, String> response = new HashMap<>();
            response.put("message", "Thank you for your message! I will get back to you soon.");
            
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("message", "Failed to process your request. Please try again later.");
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }
} 