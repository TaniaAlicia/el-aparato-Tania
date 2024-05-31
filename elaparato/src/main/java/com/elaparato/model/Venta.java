package com.elaparato.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id_venta;

    private Date fecha;

    @OneToMany(mappedBy = "venta")
    @JsonIgnore // Esto evita la serialización de la lista de ventasProductos en el JSON
    private List<VentaProducto> ventasProductos;

    public Venta() {
    }

    public Venta(int id_venta, Date fecha, List<VentaProducto> ventasProductos) {
        this.id_venta = id_venta;
        this.fecha = fecha;
        this.ventasProductos = ventasProductos;
    }
}
