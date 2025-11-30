package com.example.secureasync.controller;

import com.example.secureasync.service.NotificationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping("/notify")
    public CompletableFuture<String> notify(@RequestParam String message) {
        return notificationService.sendNotification(message);
    }
}
