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

import com.exemle_spring.spring_estudo.desafio_one.model.DTOs.TarefaDTO;
import com.exemle_spring.spring_estudo.desafio_one.service.TarefaService;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {
	@Autowired
	private TarefaService tarefaService;
	
	@PostMapping("/{Id}")
	public TarefaDTO addTarefa(@RequestBody TarefaDTO dto, @PathVariable(name = "Id") Integer Id) {
		return tarefaService.addTarefa(dto, Id);
	}
	
	@GetMapping
	public TarefaDTO getTarefa(@PathVariable Integer id) {
		return tarefaService.getTarefas(id);
	}
	
	@DeleteMapping("/{id}")
	public void deletarTarefa(@PathVariable Integer id) {
		tarefaService.delTarefas(id);
	}
	
	@PutMapping
	public TarefaDTO atualizarTarefa(@RequestBody TarefaDTO dto, @PathVariable(name = "Id") Integer Id) {
		return tarefaService.atualizarTarefa(dto, Id);
	}
}
