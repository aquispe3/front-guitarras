package com.example.backendicei.Entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;


@Getter
@Setter
@Entity
@Table(name = "menu", schema = "prueba")
public class MenuEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_id")
    private Long menuId;

    @Column(name = "menu_origen_id")
    private Long menuOrigenId;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "url")
    private String url;

    @Column(name = "fecha_registro")
    private Date fechaRegistro;

    @Column(name = "estado_id")
    private Integer estadoId;
}
