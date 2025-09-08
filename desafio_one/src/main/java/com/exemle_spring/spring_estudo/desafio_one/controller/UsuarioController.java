package com.exemle_spring.spring_estudo.desafio_one.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exemle_spring.spring_estudo.desafio_one.model.Usuario;
import com.exemle_spring.spring_estudo.desafio_one.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping
	public Usuario addUsuario(@RequestBody Usuario usuario) {
	    return usuarioService.addUsuario(usuario);
	}
	
	@GetMapping("/{id}")
	public Usuario getUsuarioPorId(@PathVariable Integer id) {
	    return usuarioService.getUsuario(id);
	}

	@DeleteMapping("/{id}")
	public void deletarUsuario(@PathVariable Integer id) {
	    Usuario usuario = usuarioService.getUsuario(id);
	    usuarioService.delUsuario(usuario);             
	}
	
	@PutMapping
	public void atualizarUsuarios(@RequestBody Usuario usuario) {
		usuarioService.usuarioAtualizar(usuario);
	}

}
