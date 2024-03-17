package com.example.backendicei.Entity;



import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "cliente", schema = "prueba")
public class ClienteEntity implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cliente_id")
    private Long clienteId;

    @Column(name = "nombre_completo")
    private String nombreCompleto;
    @Column(name = "correo")
    private String correo;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "fecha_registro")
    private Date fechaRegistro;

    @Column(name = "estado_id")
    private Integer estadoId;

}

