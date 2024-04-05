package com.makro.Inventario.service.cliente;

import com.makro.Inventario.DTO.DTOListarCliente;
import com.makro.Inventario.model.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClienteInterface {

    public Cliente agregar(Cliente cliente);
    public Cliente eliminar(Integer id);
    public Cliente modificar(Cliente cliente);
    public Page<Cliente> listar(Pageable pageable);
}
