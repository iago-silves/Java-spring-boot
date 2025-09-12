package com.exemle_spring.spring_estudo.desafio_one.model.DTOs;

import com.exemle_spring.spring_estudo.desafio_one.model.Tarefa;
import com.exemle_spring.spring_estudo.desafio_one.model.Usuario;

public record TarefaDTO(String nome, String descricao, Integer usuarioId) {
    public Tarefa toEntity(Usuario usuario) {
        return new Tarefa(nome, descricao, usuario);
    }

    public static TarefaDTO fromEntity(Tarefa tarefa) {
        return new TarefaDTO(
            tarefa.getNome(),
            tarefa.getDescricao(),
            tarefa.getUsuario().getId()
        );
    }
}
