package com.exemle_spring.spring_estudo.desafio_one.model.DTOs;

import com.exemle_spring.spring_estudo.desafio_one.model.Usuario;

public record UsuarioDTO(String nome, Integer idade, String email) {
    public Usuario toEntity(String senha) {
        return new Usuario(nome, idade, senha, email);
    }

    public static UsuarioDTO fromEntity(Usuario usuario) {
        return new UsuarioDTO(
            usuario.getNome(),
            usuario.getIdade(),
            usuario.getEmail()
        );
    }
}
