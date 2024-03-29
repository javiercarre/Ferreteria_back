package com.ferreteria_back.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "herramientas")
public class Herramienta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_marca")
    private Marca idMarca;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_tipo", nullable = false)
    private Tipo idTipo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_estado")
    private Estado idEstado;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_proveedor")
    private Proveedor idProveedor;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "cantidad")
    private String cantidad;

}