package com.example.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListerners {

    @KafkaListener(
            topics = "trendtop",
            groupId = "grId"
    )
    void listener(String data) {
        System.out.println("Listener recived: "+data+" .");
    }
}
