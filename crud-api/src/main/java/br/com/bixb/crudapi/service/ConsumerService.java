package br.com.bixb.crudapi.service;

import br.com.bixb.crudapi.controller.ProductRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ConsumerService {
    private final ProductService productService;
    private final ObjectMapper objectMapper;

    @KafkaListener(topics = "bixb_topic", groupId = "${spring.kafka.consumer.group-id}")
    @SneakyThrows
    public void listenGroupFoo(String message) {
        log.info("Received Message in group 1: {}", message);
        productService.create(objectMapper.readValue(message, ProductRequest.class));
    }
}
