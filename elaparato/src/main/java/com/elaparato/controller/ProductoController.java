package com.elaparato.controller;
import com.elaparato.model.Producto;
import com.elaparato.service.IProductoService;
import com.elaparato.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductoController {

    @Autowired
    private ProductoService prodServ;

    //OK con SEQUENCE
    @PostMapping("/productos/create")
    public String createProducto(@RequestBody Producto prod) {prodServ.saveProducto(prod);
        return "Producto creado correctamente";
    }

    //obtener todos los productos
    @GetMapping("/productos/getall") //OK
    //@PreAuthorize("hasAnyRole('app_repositor', 'app_admin')")
    public List<Producto> getProductos() {
        return prodServ.getProductos();
    }

    //Modificar los datos de un producto //probar
    @PutMapping("/productos/edit") //OK
    public String editProducto(@RequestBody Producto prod) {
        prodServ.editProducto(prod);
        return "Producto editado correctamente";
    }


    @DeleteMapping("/productos/delete/{id}") //OK
    public ResponseEntity<?> eliminarProducto(@PathVariable int id) {
        ResponseEntity<?> response;
        try {
            Optional<Producto> productoOptional = prodServ.findProducto(id);
            if (productoOptional.isPresent()) {
                prodServ.deleteProducto(id);
                response = ResponseEntity.status(HttpStatus.OK).body("Producto eliminado correctamente");
            } else {
                response = ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró ningún producto con el ID proporcionado");
            }
        } catch (Exception e) {
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocurrió un error al intentar eliminar el producto");
        }
        return response;
    }
}

