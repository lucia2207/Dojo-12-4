package com.java.microfacturar.web;

import com.java.microfacturar.config.MessagingConfig;
import com.java.microfacturar.domain.Factura;
import com.java.microfacturar.service.IFacturaService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class FacturaResource {
    @Autowired
    private IFacturaService facturaService;

    @Autowired
    private RabbitTemplate template;

    @GetMapping("/facturasReactivas")
    @ResponseStatus(HttpStatus.OK)
    private Flux<Factura> obtenerFacturas(){
        return this.facturaService.findInvoices();
    }

    @GetMapping("/facturasReactivas/factura/{id}")
    @ResponseStatus(HttpStatus.OK)
    private Mono<Factura> obtenerFacturaPorId(@PathVariable String id){
        return this.facturaService.findInvoiceById(id);
    }

    @PostMapping("/facturasReactivas/guardarFactura")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<Factura> guardarFactura(@RequestBody Factura f){
        template.convertAndSend(MessagingConfig.EXCHANGE,MessagingConfig.ROUTING_KEY,f);
        return this.facturaService.saveInvoice(f);
    }



}
