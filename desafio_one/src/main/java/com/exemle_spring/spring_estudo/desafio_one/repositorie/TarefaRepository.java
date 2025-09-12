package com.exemle_spring.spring_estudo.desafio_one.repositorie;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exemle_spring.spring_estudo.desafio_one.model.Tarefa;

public interface TarefaRepository extends  JpaRepository<Tarefa, Integer>{

}
