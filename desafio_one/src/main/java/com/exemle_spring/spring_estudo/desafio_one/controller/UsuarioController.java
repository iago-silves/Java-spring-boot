package com.exemle_spring.spring_estudo.desafio_one.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exemle_spring.spring_estudo.desafio_one.model.DTOs.UsuarioDTO;
import com.exemle_spring.spring_estudo.desafio_one.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public UsuarioDTO criarUsuario(@RequestBody UsuarioDTO dto, @RequestParam String senha) {
        return usuarioService.addUsuario(dto, senha);
    }

    @GetMapping("/{id}")
    public UsuarioDTO buscarUsuario(@PathVariable Integer id) {
        return usuarioService.getUsuario(id);
    }
    
    @DeleteMapping("/{id}")
    public void deletarUsuario(@PathVariable Integer id) {
        usuarioService.delUsuario(id);
    }

    @PutMapping("/{id}")
    public UsuarioDTO atualizarUsuario(@PathVariable Integer id,
                                       @RequestBody UsuarioDTO dto,
                                       @RequestParam String senha) {
        return usuarioService.atualizarUsuario(id, dto, senha);
    }

}

