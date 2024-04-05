package com.makro.Inventario.controller;

import com.makro.Inventario.DTO.DTOAgregarCliente;
import com.makro.Inventario.DTO.DTOListarCliente;
import com.makro.Inventario.model.Cliente;
import com.makro.Inventario.service.cliente.ClienteInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteInterface clienteInterface;
    @Autowired
    public ClienteController(ClienteInterface clienteInterface){
        this.clienteInterface = clienteInterface;
    }
    @PostMapping("/agregar-cliente")
    public ResponseEntity<DTOListarCliente> agregar(@RequestBody DTOAgregarCliente data){
          Cliente cliente = clienteInterface.agregar(new Cliente(data));
          return ResponseEntity.ok(new DTOListarCliente(cliente));
    }
    @GetMapping("/listar-cliente")
    public Page<DTOListarCliente> listar(Pageable pageable){
        return clienteInterface.listar(pageable).map(DTOListarCliente::new);
    }
}
