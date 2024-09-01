package com.example.mental_health_support_chatbot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mental_health_support_chatbot.model.ChatMessage;
import com.example.mental_health_support_chatbot.service.ChatBotService;

import java.io.IOException;
import java.net.URISyntaxException;

@Controller
public class ChatBotController {
    private final ChatBotService genAiService;

    @Autowired
    public ChatBotController(ChatBotService genAiService) {
        this.genAiService = genAiService;
    }

    @GetMapping
    public String introMessage(Model model) throws IOException, URISyntaxException {

        return chat("Hello, could you tell me something about yourself ?", model);
    }

    @PostMapping
    public String chat(@RequestParam(name = "prompt") String prompt, Model model)
            throws IOException, URISyntaxException {
        ChatMessage chatMessage = genAiService.predict(prompt);
        model.addAttribute("model", chatMessage);
        return "chatbot";
    }
}
