package com.springboot.usuario_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.usuario_service.entity.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
