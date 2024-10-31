package com.cr.service;

import com.cr.model.Producto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class ProductoService {
	private List<Producto> Productos = new ArrayList<>();
	private Long nextId = 1L;

	public Producto addProducto(Producto Producto) {
        Producto.setId(nextId++);
        Productos.add(Producto);
        return Producto;
    }

    public List<Producto> getAllProductos() {
        return Productos;
    }

    public Optional<Producto> getProductoById(Long id) {
        return Productos.stream().filter(c -> c.getId().equals(id)).findFirst();
    }

    public Producto updateProducto(Long id, Producto ProductoActualizado) {
        Optional<Producto> Producto = getProductoById(id);
        if (Producto.isPresent()) {
            Producto actualizado = Producto.get();
            actualizado.setNombre(ProductoActualizado.getNombre());
            actualizado.setDescripcion(ProductoActualizado.getDescripcion());
            actualizado.setPrecio(ProductoActualizado.getPrecio());
            actualizado.setStock(ProductoActualizado.getStock());
            return actualizado;
        }
        return null;
    }

    public boolean deleteProducto(Long id) {
        return Productos.removeIf(c -> c.getId().equals(id));
    }
}
