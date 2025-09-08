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

import com.exemle_spring.spring_estudo.desafio_one.model.Tarefas;
import com.exemle_spring.spring_estudo.desafio_one.service.TarefasService;

@RestController
@RequestMapping("/tarefas")
public class TarefasController {
	@Autowired
	private TarefasService tarefasservice;
	
	@PostMapping
	public Tarefas addTarefas(@RequestBody Tarefas tarefas) {
		return tarefasservice.addTarefa(tarefas);
	}
	
	@GetMapping("/{id}")
	public Tarefas pegarTarefas(@PathVariable Integer id) {
		return tarefasservice.getTarefas(id);
	}
	
	@DeleteMapping("/{id}")
	public void deletarTarefa(@PathVariable Integer id) {
	    Tarefas tarefa = tarefasservice.getTarefas(id);
	    tarefasservice.delTarefas(tarefa);
	}
	
	@PutMapping
	public void atualizartarefa(@RequestBody Tarefas tarefas) {
		tarefasservice.atualizarTarefa(tarefas);
	}
}
