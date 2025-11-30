package com.example.secureasync.service;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.assertj.core.api.Assertions.assertThat;

class NotificationServiceTest {

    private final NotificationService notificationService = new NotificationService();

    @Test
    void sendNotificationShouldReturnFuture() throws ExecutionException, InterruptedException {
        String message = "Test Message";
        CompletableFuture<String> future = notificationService.sendNotification(message);

        assertThat(future).isNotNull();
        assertThat(future.get()).isEqualTo("Notification processed: " + message);
    }
}
