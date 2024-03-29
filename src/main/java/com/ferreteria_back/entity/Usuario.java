package com.ferreteria_back.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_rol", nullable = false)
    private Rol idRol;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_documento")
    private TiposDocumento idTipoDocumento;

    @Column(name = "nombres")
    private String nombres;

    @Column(name = "contrasena", nullable = false)
    private String contrasena;

    @Column(name = "usuario", nullable = false)
    private String usuario;

    @Column(name = "no_documento")
    private String noDocumento;

    @Column(name = "correo")
    private String correo;

    @Column(name = "telefono")
    private String telefono;

}