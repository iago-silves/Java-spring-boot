package com.exemle_spring.spring_estudo.desafio_one.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exemle_spring.spring_estudo.desafio_one.model.Tarefas;
import com.exemle_spring.spring_estudo.desafio_one.model.Usuario;
import com.exemle_spring.spring_estudo.desafio_one.repositorie.UsuarioRepositorie;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepositorie usuariosRepositorio;
	
	public Usuario addUsuario(Usuario usuario) {
	    if (usuario.getTarefa() != null) {
	        for (Tarefas tarefa : usuario.getTarefa()) {
	            tarefa.setUsuario(usuario); 
	        }
	    }
	    return usuariosRepositorio.save(usuario);
	}
	
	public Usuario getUsuario(Integer id) {
		return usuariosRepositorio.findById(id).orElseThrow(() -> new RuntimeException());
	}
	
	public void delUsuario(Usuario usuario) {
		usuariosRepositorio.delete(usuario);
	}
	
	public void usuarioAtualizar(Usuario usuario) {
		Usuario usuarioAntigo = getUsuario(usuario.getId());
		
		usuarioAntigo.setIdade(usuario.getIdade());
		usuarioAntigo.setNome(usuario.getNome());;
		usuarioAntigo.setSenha(usuario.getSenha());
	}
}
