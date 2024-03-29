package com.ferreteria_back.service;

import com.ferreteria_back.dto.LoginRequest;
import com.ferreteria_back.dto.UsuarioDTO;
import com.ferreteria_back.entity.Rol;
import com.ferreteria_back.entity.Usuario;
import com.ferreteria_back.repository.RolRepository;
import com.ferreteria_back.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

    public Usuario convertDtoToEntity(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setNombres(usuarioDTO.getNombres());
        usuario.setNoDocumento(usuarioDTO.getNo_documento());
        usuario.setUsuario(usuarioDTO.getUsuario());
        usuario.setCorreo(usuarioDTO.getCorreo());
        usuario.setTelefono(usuarioDTO.getTelefono());
        usuario.setContrasena(usuarioDTO.getContrasena());

        Rol rol = rolRepository.findById(Integer.parseInt(usuarioDTO.getRol()))
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));
        usuario.setIdRol(rol);

        return usuario;
    }

    public boolean autenticar(LoginRequest datos) {
        return usuarioRepository.findByUsuarioAndContrasena(datos.getUsuario(), datos.getContrasena()) != null;
    }

    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario buscarUsuario(String usuario){
        return usuarioRepository.findByUsuario(usuario);
    }
}
