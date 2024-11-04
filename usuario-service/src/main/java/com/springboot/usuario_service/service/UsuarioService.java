package com.springboot.usuario_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.usuario_service.entity.Usuario;
import com.springboot.usuario_service.repository.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UsuarioService {
	@Autowired
	UsuarioRepository usuarioRepository;
	
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}
	
	public void save(Usuario usuario) {
		usuarioRepository.save(usuario);
	}
	
	public Optional<Usuario> findById(int id) {
		return usuarioRepository.findById(id);
	}
	
	public void delete(int id) {
		usuarioRepository.deleteById(id);
	}
	
	public boolean existsById(int id) {
		return usuarioRepository.existsById(id);
	}
	
	public void update(int id, Usuario updatedUsuario) {
		Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
		if (optionalUsuario.isPresent()) {
			Usuario usuario = optionalUsuario.get();
			usuario.setUser(updatedUsuario.getUser());
			usuario.setContrasena(updatedUsuario.getContrasena());
			usuarioRepository.save(usuario);
		}
	}
}
