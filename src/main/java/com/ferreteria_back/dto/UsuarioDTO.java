package com.ferreteria_back.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTO {
    private String nombres;
    private String no_documento;
    private String usuario;
    private String correo;
    private String telefono;
    private String rol;
    private String contrasena;
}
