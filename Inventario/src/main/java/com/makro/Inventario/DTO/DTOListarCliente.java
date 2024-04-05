package com.makro.Inventario.DTO;

import com.makro.Inventario.model.Cliente;

public record DTOListarCliente(
        String nombre,
        String direccion,
        String telefono
) {
    public DTOListarCliente(Cliente cliente){
       this(cliente.getNombre(), cliente.getDireccion(),cliente.getTelefono());
    }
}

