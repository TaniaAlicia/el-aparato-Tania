package com.elaparato.repository;

import com.elaparato.model.VentaProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVentaProductoRepository extends JpaRepository<VentaProducto, Integer> {

}
