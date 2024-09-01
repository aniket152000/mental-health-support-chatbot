package com.example.mental_health_support_chatbot.service;




import java.io.IOException;
import java.net.URISyntaxException;

import com.example.mental_health_support_chatbot.model.ChatMessage;



public interface ChatBotService {
    ChatMessage predict(String prompt) throws IOException, URISyntaxException;
}
