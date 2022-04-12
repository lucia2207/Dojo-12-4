package com.java.microfacturar.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.UUID;

@Document(collection = "facturadojo")
public class Factura {
    @Id
    private String id = UUID.randomUUID().toString().substring(0, 10);
    private LocalDate fecha;
    private String nomCliente;
    private Double total;
    private Boolean aplicaDesc;
    private String nomCajero;


    //Constructor
    public Factura() {
        this.fecha = LocalDate.now();
        this.aplicaDesc = false;
    }

    //Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getNomCliente() {
        return nomCliente;
    }

    public void setNomCliente(String nomCliente) {
        this.nomCliente = nomCliente;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Boolean getAplicaDesc() {
        return aplicaDesc;
    }

    public void setAplicaDesc(Boolean aplicaDesc) {
        this.aplicaDesc = aplicaDesc;
    }

    public String getNomCajero() {
        return nomCajero;
    }

    public void setNomCajero(String nomCajero) {
        this.nomCajero = nomCajero;
    }
}
