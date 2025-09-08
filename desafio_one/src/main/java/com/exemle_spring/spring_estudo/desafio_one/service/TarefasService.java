package com.exemle_spring.spring_estudo.desafio_one.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exemle_spring.spring_estudo.desafio_one.model.Tarefas;
import com.exemle_spring.spring_estudo.desafio_one.repositorie.TarefasRepositorie;

@Service
public class TarefasService {

    @Autowired
    private TarefasRepositorie tarefasRepositorie;

    public Tarefas addTarefa(Tarefas tarefa) {
        return tarefasRepositorie.save(tarefa);
    }

    public Tarefas getTarefas(Integer id) {
        return tarefasRepositorie.findById(id)
            .orElseThrow(() -> new RuntimeException("Tarefa com ID " + id + " não encontrada."));
    }

    public void delTarefas(Tarefas tarefa) {
        if (tarefa != null && tarefa.getId() != null) {
            tarefasRepositorie.delete(tarefa);
        }
    }

    public Tarefas atualizarTarefa(Tarefas tarefas) {
        Tarefas dadoAntigo = getTarefas(tarefas.getId());

        dadoAntigo.setNome(tarefas.getNome());
        dadoAntigo.setDescricao(tarefas.getDescricao());

        return tarefasRepositorie.save(dadoAntigo);
    }
}
