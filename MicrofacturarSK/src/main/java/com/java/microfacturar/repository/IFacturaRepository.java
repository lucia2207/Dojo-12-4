package com.java.microfacturar.repository;

import com.java.microfacturar.domain.Factura;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface IFacturaRepository extends ReactiveMongoRepository<Factura,String> {
}
