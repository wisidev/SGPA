package com.example.projeto_esos.model;

import jakarta.persistence.*;
import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String senha;

    // Construtores
    public Usuario() {}

    public Usuario(String username, String senha) {
        this.username = username;
        this.senha = senha;
    }
}
