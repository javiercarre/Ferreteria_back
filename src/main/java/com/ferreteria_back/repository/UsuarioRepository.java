package com.ferreteria_back.repository;

import com.ferreteria_back.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    Usuario findByUsuario(String usuario);

    Usuario findByUsuarioAndContrasena(String usuario, String contrasena);
}