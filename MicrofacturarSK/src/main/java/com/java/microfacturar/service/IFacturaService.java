package com.java.microfacturar.service;

import com.java.microfacturar.domain.Factura;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IFacturaService {
    Mono<Factura> saveInvoice (Factura f);
    Mono<Factura> findInvoiceById(String id);
    Flux<Factura> findInvoices();


}
