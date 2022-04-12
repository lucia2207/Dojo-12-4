package com.example.demo.service;

import com.example.demo.model.Cliente;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClienteService {
    Mono<Cliente> addCliente(Cliente cliente);
    Flux<Cliente> getClientes();
    Mono<Cliente> getById(String id);
    Mono<Cliente> deleteById(String id);
    Mono<Cliente> actualizarById(String id, Cliente cliente);
}
