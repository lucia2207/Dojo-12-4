package com.example.demo.consumer;

import com.example.demo.model.Cliente;
import com.java.microfacturar.config.MessagingConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Usuario {
    @RabbitListener(queues = MessagingConfig.QUEUE)
    public void consumeMessageFromQueue(Cliente cliente) {
        System.out.println("Se agregó un nuevo cliente: " + cliente.toString());
    }
}
