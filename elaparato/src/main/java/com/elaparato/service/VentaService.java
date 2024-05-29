package com.elaparato.service;

import com.elaparato.model.Venta;
import com.elaparato.repository.IVentaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentaService implements IVentaService{

    @Autowired
    private IVentaRepository ventaRepository;


    @Override
    public List<Venta> getVentas() {
        return ventaRepository.findAll();
    }

    @Override
    public void saveVenta(Venta vent) {
        ventaRepository.save(vent);
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
    public Venta updateVenta(Venta vent) {
        Optional<Venta> optionalVenta = ventaRepository.findById(vent.getId_venta());
        if (optionalVenta.isPresent()) {
            Venta venta = optionalVenta.get();
            venta.setFecha(vent.getFecha());
            venta.setListaProductos(vent.getListaProductos());
            return ventaRepository.save(venta);
        } else {
            throw new RuntimeException("No se encontró la venta con el ID" + vent.getId_venta());
        }
    }




    }
