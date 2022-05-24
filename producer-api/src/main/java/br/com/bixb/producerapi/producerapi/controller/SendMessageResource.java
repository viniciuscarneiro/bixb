package br.com.bixb.producerapi.producerapi.controller;

import br.com.bixb.producerapi.producerapi.service.ProducerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SendMessageResource {
    private final ProducerService producerService;
    private final ObjectMapper objectMapper;

    @PostMapping("/message")
    @SneakyThrows
    public ResponseEntity<Object> sendMessage(@RequestBody Object message) {
        producerService.sendMessage(objectMapper.writeValueAsString(message));
        return ResponseEntity.noContent().build();
    }
}
