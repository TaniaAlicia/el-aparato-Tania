package com.elaparato.service;

import com.elaparato.model.Producto;

import java.util.List;
import java.util.Optional;

public interface IProductoService {

    public List<Producto> getProductos();

    public void saveProducto(Producto prod);

    public void deleteProducto(int id);

    public Optional<Producto> findProducto(int id);

    public void editProducto(Producto prod);

}
