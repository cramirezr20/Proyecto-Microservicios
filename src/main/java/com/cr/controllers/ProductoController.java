package com.cr.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cr.model.Producto;
import com.cr.service.ProductoService;

@RestController
@RequestMapping("/Productos")
public class ProductoController {

	@Autowired
	private ProductoService ProductoService;
	
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Producto createProducto(@RequestBody Producto Producto) {
        return ProductoService.addProducto(Producto);
    }
    
	@GetMapping
    public List<Producto> getAllProductos() {
        return ProductoService.getAllProductos();
    }

    @GetMapping("/{id}")
    public Producto getProductoById(@PathVariable Long id) {
        return ProductoService.getProductoById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado"));
    }

    @PutMapping("/{id}")
    public Producto updateProducto(@PathVariable Long id, @RequestBody Producto ProductoActualizado) {
        Producto Producto = ProductoService.updateProducto(id, ProductoActualizado);
        if (Producto == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado");
        }
        return Producto;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProducto(@PathVariable Long id) {
        if (!ProductoService.deleteProducto(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado");
        }
    }

}
	

