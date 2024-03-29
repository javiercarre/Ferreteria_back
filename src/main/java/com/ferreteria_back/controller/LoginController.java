package com.ferreteria_back.controller;

import com.ferreteria_back.dto.LoginRequest;
import com.ferreteria_back.entity.Usuario;
import com.ferreteria_back.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;


    @PostMapping
    public ResponseEntity<Boolean> login(@RequestBody LoginRequest loginRequest){
            return ResponseEntity.ok(usuarioService.autenticar(loginRequest));
    }

    @PostMapping(value = "olvido-pass")
    public ResponseEntity<String> olvidoPass(@RequestBody Usuario user){
        Usuario usuario = usuarioService.buscarUsuario(user.getUsuario());
        if(null != usuario){
            return ResponseEntity.ok(usuario.getContrasena());
        }
        return ResponseEntity.ok("error");
    }
}
