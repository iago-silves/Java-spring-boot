package com.exemle_spring.spring_estudo.desafio_one.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exemle_spring.spring_estudo.desafio_one.model.Tarefa;
import com.exemle_spring.spring_estudo.desafio_one.model.Usuario;
import com.exemle_spring.spring_estudo.desafio_one.model.DTOs.TarefaDTO;
import com.exemle_spring.spring_estudo.desafio_one.repositorie.TarefaRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class TarefaService {
    
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private TarefaRepository tarefaRepository;

    public TarefaDTO addTarefa(TarefaDTO dto) {
        Usuario usuarioRef = entityManager.getReference(Usuario.class, dto.usuarioId());

        Tarefa tarefa = dto.toEntity(usuarioRef);
        Tarefa tarefaSalva = tarefaRepository.save(tarefa);

        return TarefaDTO.fromEntity(tarefaSalva);
    }
}
