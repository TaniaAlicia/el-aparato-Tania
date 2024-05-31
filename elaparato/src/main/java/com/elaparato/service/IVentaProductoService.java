package com.elaparato.service;

import com.elaparato.model.VentaProducto;

import java.util.List;
import java.util.Optional;

public interface IVentaProductoService {
    VentaProducto save(VentaProducto ventaProducto);
    Optional<VentaProducto> findById(int id);
    List<VentaProducto> findAll();
    void deleteById(int id);
}
