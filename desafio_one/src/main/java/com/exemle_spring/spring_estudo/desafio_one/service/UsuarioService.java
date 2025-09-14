package com.exemle_spring.spring_estudo.desafio_one.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exemle_spring.spring_estudo.desafio_one.model.Usuario;
import com.exemle_spring.spring_estudo.desafio_one.model.DTOs.UsuarioDTO;
import com.exemle_spring.spring_estudo.desafio_one.repositorie.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioDTO addUsuario(UsuarioDTO dto, String senha) {
        Usuario usuario = dto.toEntity(senha);
        Usuario usuarioSalvo = usuarioRepository.save(usuario);
        return UsuarioDTO.fromEntity(usuarioSalvo);
    }

    public UsuarioDTO getUsuario(Integer id) {
        return usuarioRepository.findById(id)
                .map(UsuarioDTO::fromEntity)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    public void delUsuario(Integer id) {
        usuarioRepository.deleteById(id);
    }

    public UsuarioDTO atualizarUsuario(Integer id, UsuarioDTO dto, String senha) {
        Usuario usuarioAntigo = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        usuarioAntigo.setNome(dto.nome());
        usuarioAntigo.setIdade(dto.idade());
        usuarioAntigo.setSenha(senha);

        Usuario atualizado = usuarioRepository.save(usuarioAntigo);
        return UsuarioDTO.fromEntity(atualizado);
    }
}