package com.elaparato.controller;

import com.elaparato.model.Venta;
import com.elaparato.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class VentaController {


    @Autowired
    private IVentaService ventServ;

    //crear una nueva venta
    @PostMapping("/ventas/create") //Errorupdate
    public String createVenta(@RequestBody Venta vent) {
        ventServ.saveVenta(vent);
        return "Venta creada correctamente";
    }

    //obtener todas las ventas
    @GetMapping("/ventas/getall") //OK
    public List<Venta> getVentas () {
        return ventServ.getVentas();
    }

    //Modificar los datos de una venta
    @PutMapping("/ventas/update") //OK
    public String updateVenta(@RequestBody Venta vent) {
        ventServ.updateVenta(vent);
        return "Venta editada correctamente";
    }


 @DeleteMapping("/ventas/delete/{id}") //Error
 public ResponseEntity<?> eliminarVenta(@PathVariable int id) {
     ResponseEntity<?> response;
     try {
         Optional<Venta> ventaOptional = Optional.ofNullable(ventServ.findVenta(id));
         if (ventaOptional.isPresent()) {
             ventServ.deleteVenta(id);
             response = ResponseEntity.status(HttpStatus.OK).body("Venta eliminada correctamente");
         } else {
             response = ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró ninguna venta con el ID proporcionado");
         }
     } catch (Exception e) {
         response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocurrió un error al intentar eliminar la venta");
     }
     return response;
 }

}
