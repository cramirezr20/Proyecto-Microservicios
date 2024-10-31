package com.cr.service;

import com.cr.model.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class ClienteService {
	private List<Cliente> clientes = new ArrayList<>();
	private Long nextId = 1L;

	public Cliente addCliente(Cliente cliente) {
        cliente.setId(nextId++);
        clientes.add(cliente);
        return cliente;
    }

    public List<Cliente> getAllClientes() {
        return clientes;
    }

    public Optional<Cliente> getClienteById(Long id) {
        return clientes.stream().filter(c -> c.getId().equals(id)).findFirst();
    }

    public Cliente updateCliente(Long id, Cliente clienteActualizado) {
        Optional<Cliente> cliente = getClienteById(id);
        if (cliente.isPresent()) {
            Cliente actualizado = cliente.get();
            actualizado.setNombre(clienteActualizado.getNombre());
            actualizado.setEmail(clienteActualizado.getEmail());
            actualizado.setTelefono(clienteActualizado.getTelefono());
            actualizado.setDireccion(clienteActualizado.getDireccion());
            return actualizado;
        }
        return null;
    }

    public boolean deleteCliente(Long id) {
        return clientes.removeIf(c -> c.getId().equals(id));
    }
}
