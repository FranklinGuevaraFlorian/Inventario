package com.makro.Inventario.model;

import com.makro.Inventario.DTO.DTOAgregarCliente;
import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(of = "id_cliente" )
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_cliente;

    @Column(length = 100, nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String direccion;

    @Column(nullable = false,length = 9)
    private String telefono;

    @Column(nullable = false,length = 8, unique = true)
    private String dni;

    public Cliente(DTOAgregarCliente data) {
        this.nombre = data.nombre();
        this.direccion = data.direccion();
        this.telefono = data.telefono();
        this.dni = data.dni();
    }
}
