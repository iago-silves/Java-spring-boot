package com.exemle_spring.spring_estudo.desafio_one.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	@NotBlank
	private String nome;

	@Column(nullable = false)
	@NotNull(message = "Idade não pode ser nula")
	@Min(value = 0, message = "Idade não pode ser negativa")
	private Integer idade;

	@Column(nullable = false)
	@NotBlank
	private String senha;

	@Column(nullable = false, unique = true)
	@NotBlank
	private String email;

	public Usuario() {
	}

	public Usuario(String nome, int idade, String senha, String email) {
		this.nome = nome;
		this.idade = idade;
		this.senha = senha;
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
