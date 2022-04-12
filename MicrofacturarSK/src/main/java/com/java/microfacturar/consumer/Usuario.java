package com.java.microfacturar.consumer;

import com.java.microfacturar.config.MessagingConfig;
import com.java.microfacturar.domain.Factura;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Usuario {
    @RabbitListener(queues = MessagingConfig.QUEUE)
    public void consumeMessageFromQueue(Factura f) {
        System.out.println("Factura recibida en la cola : " + f.getId());
    }
}
