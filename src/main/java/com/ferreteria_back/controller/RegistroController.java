package com.ferreteria_back.controller;

import com.ferreteria_back.dto.UsuarioDTO;
import com.ferreteria_back.entity.Usuario;
import com.ferreteria_back.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/registro")
public class RegistroController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> crearUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioService.convertDtoToEntity(usuarioDTO);
        Usuario nuevoUsuario = usuarioService.guardarUsuario(usuario);
        return ResponseEntity.ok(nuevoUsuario);
    }
}
