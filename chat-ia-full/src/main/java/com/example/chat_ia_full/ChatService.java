package com.example.chat_ia_full;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

import java.util.Map;

@Service
public class ChatService {

    @Value("${openai.api.key}")
    private String openAiApiKey;

    private final String apiUrl = "https://api.openai.com/v1/chat/completions";

    public String askAI(String prompt) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(openAiApiKey);
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> request = Map.of(
                "model", "gpt-3.5-turbo",
                "messages", new Object[]{Map.of("role", "user", "content", prompt)}
        );

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(request, headers);
        ResponseEntity<Map> response = restTemplate.exchange(apiUrl, HttpMethod.POST, entity, Map.class);

        try {
            return (String) ((Map)((Map)((java.util.List)response.getBody().get("choices")).get(0)).get("message")).get("content");
        } catch (Exception e) {
            return "Erro ao consultar IA: " + e.getMessage();
        }
    }
}
