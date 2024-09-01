package com.example.mental_health_support_chatbot.model;

import java.util.List;

public record ChatMessage(
        String botName,
        String slogan,
        List<ChatHistory> chatHistory
){ }
