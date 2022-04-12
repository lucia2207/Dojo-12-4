package com.example.demo.service;

import com.example.demo.model.Cliente;
import com.example.demo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClienteServiceImpl implements ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Mono<Cliente> addCliente(Cliente cliente) {
        return this.clienteRepository.save(cliente);
    }

    @Override
    public Flux<Cliente> getClientes() {
        return this.clienteRepository.findAll();
    }


    @Override
    public Mono<Cliente> getById(String id) {
        return this.clienteRepository.findByClienteId(id);
    }

    @Override
    public Mono<Cliente> deleteById(String id) {
        return this.clienteRepository.findByClienteId(id)
                .flatMap(cliente -> this.clienteRepository.deleteById(cliente.getId())
                        .thenReturn(cliente));
    }

    @Override
    public Mono<Cliente> actualizarById(String id, Cliente cliente) {
        return this.clienteRepository.findByClienteId(id)
                .flatMap(clienteact -> {
                    cliente.setId(id);
                    return this.addCliente(cliente);
                })
                .switchIfEmpty(Mono.empty());
    }
}