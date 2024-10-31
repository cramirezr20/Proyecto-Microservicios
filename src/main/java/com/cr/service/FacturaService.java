package com.cr.service;

import com.cr.model.Factura;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class FacturaService {
	private List<Factura> Facturas = new ArrayList<>();
	private Long nextId = 1L;

	public Factura addFactura(Factura Factura) {
        Factura.setId(nextId++);
        Facturas.add(Factura);
        return Factura;
    }

    public List<Factura> getAllFacturas() {
        return Facturas;
    }

    public Optional<Factura> getFacturaById(Long id) {
        return Facturas.stream().filter(c -> c.getId().equals(id)).findFirst();
    }

    public Factura updateFactura(Long id, Factura FacturaActualizado) {
        Optional<Factura> Factura = getFacturaById(id);
        if (Factura.isPresent()) {
            Factura actualizado = Factura.get();
            actualizado.setClienteId(FacturaActualizado.getClienteId());
            actualizado.setMonto(FacturaActualizado.getMonto());
            actualizado.setFecha(FacturaActualizado.getFecha());
            return actualizado;
        }
        return null;
    }

    public boolean deleteFactura(Long id) {
        return Facturas.removeIf(c -> c.getId().equals(id));
    }
}
