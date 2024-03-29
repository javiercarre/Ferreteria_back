package com.ferreteria_back.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
    private String usuario;
    private String contrasena;
}
