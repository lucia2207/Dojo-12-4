package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;
import java.util.UUID;

@Document(collection = "clientes")
public class Cliente {
    @Id
    private String clienteId = UUID.randomUUID().toString().substring(0, 10);

    private String nombre;
    private String telefono;
    private String documentoId;

    public Cliente() {}

    public Cliente(String clienteId, String nombreCliente, String telefono, String docId) {
        this.clienteId = clienteId;
        this.nombre = nombreCliente;
        this.telefono = telefono;
        this.documentoId = docId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return
                Objects.equals(this.clienteId, cliente.clienteId) &&
                Objects.equals(this.nombre, cliente.nombre) &&
                Objects.equals(this.telefono, cliente.telefono) &&
                Objects.equals(this.documentoId, cliente.documentoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.clienteId, this.nombre, this.telefono, this.documentoId);
    }

    public String getId() {
        return this.clienteId;
    }
    public String getNombre() {
        return this.nombre;
    }
    public String getTelefono() {
        return this.telefono;
    }
    public String getDocumento() {
        return this.documentoId;
    }

    public void setId(String clienteId) {
        this.clienteId = clienteId;
    }
    public void setNombre(String nombreCliente) {
        this.nombre = nombreCliente;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public void setDocumento(String docId) {
        this.documentoId = docId;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id='" + this.clienteId + '\'' +
                ", nombre='" + this.nombre + '\'' +
                ", celular='" + this.telefono + '\'' +
                ", documentoId='" + this.documentoId + '\'' +
                '}';
    }
}