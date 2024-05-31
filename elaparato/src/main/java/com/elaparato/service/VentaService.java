package com.elaparato.service;

import com.elaparato.model.Venta;
import com.elaparato.repository.IVentaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentaService implements IVentaService {

    @Autowired
    private IVentaRepository ventaRepository;

    @Override
    public List<Venta> getVentas() {
        return ventaRepository.findAll();
    }

    @Override
    public void saveVenta(Venta venta) {
        ventaRepository.save(venta);
    }

    @Override
    public void deleteVenta(int id) {
        ventaRepository.deleteById(id);
    }

    @Override
    public Venta findVenta(int id) {
        return ventaRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Venta updateVenta(Venta ventaActualizada) {
        Optional<Venta> optionalVenta = ventaRepository.findById(ventaActualizada.getId_venta());
        if (optionalVenta.isPresent()) {
            Venta venta = optionalVenta.get();
            venta.setFecha(ventaActualizada.getFecha());
            //actualizar la lista de productos asociados a la venta
            venta.setVentasProductos(ventaActualizada.getVentasProductos());
            return ventaRepository.save(venta);
        } else {
            throw new RuntimeException("No se encontró la venta con el ID " + ventaActualizada.getId_venta());
        }
    }
}

