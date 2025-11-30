package com.example.secureasync.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class NotificationService {

    private static final Logger logger = LoggerFactory.getLogger(NotificationService.class);

    @Async("taskExecutor")
    public CompletableFuture<String> sendNotification(String message) {
        logger.info("Sending notification: {}", message);
        try {
            // Simulate long running task
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        logger.info("Notification sent: {}", message);
        return CompletableFuture.completedFuture("Notification processed: " + message);
    }
}
