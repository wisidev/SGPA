package com.example.projeto_esos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.projeto_esos.model.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    // Métodos de consulta personalizados podem ser adicionados aqui, se necessário
    Paciente findByNomePaciente(String nomePaciente);
}
