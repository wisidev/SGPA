package com.example.projeto_esos.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.projeto_esos.model.Paciente;

@Repository
public interface PacienteRepository extends MongoRepository<Paciente, String> {
    Paciente findByNomePaciente(String nomePaciente);
}

