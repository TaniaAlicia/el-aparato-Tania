package com.elaparato.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String nombre;
    private String descripcion;
    private double precio;
    private int cantidad;

    @OneToMany(mappedBy = "producto")
    @JsonIgnore // Esto evita la serialización de la lista de ventasProductos en el JSON
    private List<VentaProducto> ventasProductos;

    public Producto() {
    }

    public Producto(int id, String nombre, String descripcion, double precio, int cantidad, List<VentaProducto> ventasProductos) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
        this.ventasProductos = ventasProductos;
    }
}

