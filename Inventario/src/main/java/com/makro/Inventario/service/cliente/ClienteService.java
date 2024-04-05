package com.makro.Inventario.service.cliente;

import com.makro.Inventario.DTO.DTOListarCliente;
import com.makro.Inventario.model.Cliente;
import com.makro.Inventario.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements ClienteInterface{
    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }
    @Override
    public Cliente agregar(Cliente cliente) {
        if(buscar(cliente.getDni()) != null){
            return clienteRepository.save(cliente);
        }
        return null;
    }

    @Override
    public Cliente eliminar(String dni) {
        Cliente cliente = buscar(dni);
        if(cliente != null){
            this.clienteRepository.delete(cliente);
        }
        return null;
    }

    @Override
    public Cliente modificar(Cliente nuevoCliente) {
        Cliente cliente = buscar(nuevoCliente.getDni());
        if(cliente != null){
           cliente.actualizar(nuevoCliente);
        }
        return null;
    }

    @Override
    public Page<Cliente> listar(Pageable pageable) {
        return this.clienteRepository.findAll(pageable);
    }

    @Override
    public Cliente buscar(String dni) {
        return this.clienteRepository.getReferenceByDni(dni);
    }
}
