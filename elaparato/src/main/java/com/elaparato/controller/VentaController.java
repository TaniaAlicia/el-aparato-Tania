package com.elaparato.controller;

import com.elaparato.model.Venta;
import com.elaparato.service.IVentaService;
import com.elaparato.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class VentaController {

    @Autowired
    private VentaService ventServ;

    // Crear una nueva venta
    @PostMapping("/ventas/create")
    public ResponseEntity<String> createVenta(@RequestBody Venta vent) {
        ventServ.saveVenta(vent);
        return ResponseEntity.status(HttpStatus.CREATED).body("Venta creada correctamente");
    }

    // Obtener todas las ventas
    @GetMapping("/ventas/getall")  //-----OKK
    //@PreAuthorize("hasAnyRole('app_vendedor', 'app_admin')")
    public List<Venta> getVentas () {
        return ventServ.getVentas();
    }

    // Modificar los datos de una venta
    @PutMapping("/ventas/update")     //-----OKK
    public ResponseEntity<String> updateVenta(@RequestBody Venta vent) {
        ventServ.updateVenta(vent);
        return ResponseEntity.ok("Venta editada correctamente");
    }

    // Eliminar una venta
    @DeleteMapping("/ventas/delete/{id}") //---error
    public ResponseEntity<String> eliminarVenta(@PathVariable int id) {
        try {
            Venta venta = ventServ.findVenta(id);
            if (venta != null) {
                ventServ.deleteVenta(id);
                return ResponseEntity.ok("Venta eliminada correctamente");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró ninguna venta con el ID proporcionado");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocurrió un error al intentar eliminar la venta");
        }
    }
}
