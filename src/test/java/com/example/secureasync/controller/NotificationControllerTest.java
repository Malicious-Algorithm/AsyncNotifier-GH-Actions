package com.example.secureasync.controller;

import com.example.secureasync.service.NotificationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.concurrent.CompletableFuture;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.asyncDispatch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import com.example.secureasync.config.SecurityConfig;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.context.annotation.Import;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;

@WebMvcTest(NotificationController.class)
@AutoConfigureMockMvc
@Import(SecurityConfig.class)
class NotificationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private NotificationService notificationService;

    @Test
    void notifyShouldReturnSuccessMessage() throws Exception {
        String message = "Hello";
        given(notificationService.sendNotification(message))
                .willReturn(CompletableFuture.completedFuture("Notification processed: " + message));

        var mvcResult = mockMvc.perform(post("/notify").param("message", message).with(user("user").roles("USER")))
                .andExpect(request().asyncStarted())
                .andReturn();

        mockMvc.perform(asyncDispatch(mvcResult))
                .andExpect(status().isOk())
                .andExpect(content().string("Notification processed: " + message));
    }

    @Test
    void notifyShouldFailWithoutAuth() throws Exception {
        mockMvc.perform(post("/notify").param("message", "Hello"))
                .andExpect(status().isUnauthorized());
    }
}
