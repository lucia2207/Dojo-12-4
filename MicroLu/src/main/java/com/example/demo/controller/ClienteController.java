package com.example.demo.controller;

import com.example.demo.model.Cliente;
import com.example.demo.service.ClienteServiceImpl;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import com.java.microfacturar.config.MessagingConfig;

@RestController
@CrossOrigin(origins = "*")
public class ClienteController {
    @Autowired
    ClienteServiceImpl clienteServiceImpl;

    @Autowired
    private RabbitTemplate template;

    @PostMapping("/clientes")
    private Mono<Cliente> addCliente(@RequestBody Cliente cliente) {
        template.convertAndSend(MessagingConfig.EXCHANGE, MessagingConfig.ROUTING_KEY, cliente);
        return this.clienteServiceImpl.addCliente(cliente);
    }

    @GetMapping("/clientes")
    private Flux<Cliente> getClientes() {
        return this.clienteServiceImpl.getClientes();
    }

    @GetMapping(value="/clientes/{id}")
    @ResponseStatus(HttpStatus.OK)
    private Mono<Cliente> getById(@PathVariable("id") String id) {
        return this.clienteServiceImpl.getById(id);
    }

    @DeleteMapping("/clientes/{id}")
    private Mono<ResponseEntity<Cliente>> deleteById(@PathVariable("id") String id) {
        return this.clienteServiceImpl.deleteById(id)
                .flatMap(cliente -> Mono.just(ResponseEntity.ok(cliente)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @PutMapping("/clientes/{id}")
    private Mono<ResponseEntity<Cliente>> actualizarById(@PathVariable("id") String id, @RequestBody Cliente cliente) {
        return this.clienteServiceImpl.actualizarById(id, cliente)
                .flatMap(clientes -> Mono.just(ResponseEntity.ok(clientes)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }
}