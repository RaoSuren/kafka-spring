package com.example.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/messages")
public class MessageController {
    private KafkaTemplate<String, String> kafkaTemplate;

    public MessageController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @GetMapping("")
    public String getCall() {
        return "Hello from Tomcat Server";
    }

    @PostMapping("")
    public void publish(@RequestBody MessageRequest messageRequest) {
        kafkaTemplate.send("trendtop", messageRequest.message());
    }
}
