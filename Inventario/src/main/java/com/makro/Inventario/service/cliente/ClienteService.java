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
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente eliminar(Integer id) {
        return null;
    }

    @Override
    public Cliente modificar(Cliente cliente) {
        return null;
    }

    @Override
    public Page<Cliente> listar(Pageable pageable) {
        return this.clienteRepository.findAll(pageable);
    }
}
