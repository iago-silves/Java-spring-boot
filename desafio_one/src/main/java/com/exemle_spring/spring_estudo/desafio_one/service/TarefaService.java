package com.exemle_spring.spring_estudo.desafio_one.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exemle_spring.spring_estudo.desafio_one.model.Tarefa;
import com.exemle_spring.spring_estudo.desafio_one.model.Usuario;
import com.exemle_spring.spring_estudo.desafio_one.model.DTOs.TarefaDTO;
import com.exemle_spring.spring_estudo.desafio_one.repositorie.TarefaRepository;
import com.exemle_spring.spring_estudo.desafio_one.repositorie.UsuarioRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;

@Service
public class TarefaService {
    
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private TarefaRepository tarefaRepository;
    
    @Autowired
    private UsuarioRepository user;

    public TarefaDTO addTarefa(TarefaDTO dto, Integer Id) {
    	Usuario usuario = user.findById(Id).orElseThrow(() -> new RuntimeException());
    	Tarefa tarefa = new Tarefa(dto.nome(), dto.descricao(), usuario);
    	
    	tarefaRepository.save(tarefa);
    	
    	return dto;
    }
    
    public TarefaDTO getTarefas(Integer id) {
        return tarefaRepository.findById(id)
            .map(TarefaDTO::fromEntity)
            .orElseThrow(() -> new RuntimeException("Tarefa com ID " + id + " não encontrada."));
    }
    
    public void delTarefas(Integer id) {
        tarefaRepository.deleteById(id);
    }

    public TarefaDTO atualizarTarefa(TarefaDTO dto, Integer id) {
        Tarefa dadoAntigo = tarefaRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Tarefa com ID " + id + " não encontrada"));

        dadoAntigo.setNome(dto.nome());
        dadoAntigo.setDescricao(dto.descricao());

        Tarefa tarefaAtualizada = tarefaRepository.save(dadoAntigo);

        return TarefaDTO.fromEntity(tarefaAtualizada);
    }

}
