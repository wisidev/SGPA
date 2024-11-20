package com.example.projeto_esos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projeto_esos.model.Usuario;
import com.example.projeto_esos.repository.UsuarioRepository;  // Assumindo que você tem um repositório de usuários

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Método para encontrar o usuário pelo nome de usuário
    public Usuario findByUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }

    // Outros métodos, como salvar ou listar usuários
}
