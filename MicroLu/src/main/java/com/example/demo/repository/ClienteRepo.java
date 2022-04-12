package com.example.demo.repository;

import com.example.demo.model.Cliente;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface ClienteRepo extends ReactiveMongoRepository<Cliente, String> {
    Mono<Cliente> findByClienteId(String id);
}