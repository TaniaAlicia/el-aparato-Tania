package com.elaparato.service;

import com.elaparato.model.VentaProducto;
import com.elaparato.repository.IVentaProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class VentaProductoService implements IVentaProductoService{

    @Autowired
    private IVentaProductoRepository ventaProductoRepository;
    @Override
    public VentaProducto save(VentaProducto ventaProducto) {
        return null;
    }

    @Override
    public Optional<VentaProducto> findById(int id) {
        return Optional.empty();
    }

    @Override
    public List<VentaProducto> findAll() {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }
}
