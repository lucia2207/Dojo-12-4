package com.java.microfacturar.service.impl;

import com.java.microfacturar.domain.Factura;
import com.java.microfacturar.repository.IFacturaRepository;
import com.java.microfacturar.service.IFacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class FacturaServiceImpl implements IFacturaService {
    @Autowired
    private IFacturaRepository facturaRepo;

    @Override
    public Mono<Factura> saveInvoice(Factura f) {
        return this.facturaRepo.save(f);
    }

    @Override
    public Mono<Factura> findInvoiceById(String id) {
        return this.facturaRepo.findById(id);
    }

    @Override
    public Flux<Factura> findInvoices() {
        return this.facturaRepo.findAll();
    }
}
