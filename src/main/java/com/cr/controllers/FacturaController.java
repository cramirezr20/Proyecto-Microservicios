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

import com.cr.model.Factura;
import com.cr.service.FacturaService;

@RestController
@RequestMapping("/Facturas")
public class FacturaController {

	@Autowired
	private FacturaService FacturaService;
	
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Factura createFactura(@RequestBody Factura Factura) {
        return FacturaService.addFactura(Factura);
    }
    
	@GetMapping
    public List<Factura> getAllFacturas() {
        return FacturaService.getAllFacturas();
    }

    @GetMapping("/{id}")
    public Factura getFacturaById(@PathVariable Long id) {
        return FacturaService.getFacturaById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Factura no encontrado"));
    }

    @PutMapping("/{id}")
    public Factura updateFactura(@PathVariable Long id, @RequestBody Factura FacturaActualizado) {
        Factura Factura = FacturaService.updateFactura(id, FacturaActualizado);
        if (Factura == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Factura no encontrado");
        }
        return Factura;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFactura(@PathVariable Long id) {
        if (!FacturaService.deleteFactura(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Factura no encontrado");
        }
    }

}
	

