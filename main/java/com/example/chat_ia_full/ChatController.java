package com.example.chat_ia_full;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @Autowired
    private ChatService chatService;

    @MessageMapping("/sendMessage")
    @SendTo("/topic/messages")
    public ChatMessage sendMessage(ChatMessage message) {
        if ("user".equals(message.getType())) {
            String aiResponse = chatService.askAI(message.getContent());
            return new ChatMessage("AI", aiResponse, "ai");
        }
        return message;
    }
}