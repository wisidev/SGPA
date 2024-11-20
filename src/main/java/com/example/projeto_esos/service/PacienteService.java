package com.example.projeto_esos.service;

import com.example.projeto_esos.model.Paciente;
import com.example.projeto_esos.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    // Método para salvar um paciente
    public Paciente salvarPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    // Método para buscar todos os pacientes
    public List<Paciente> buscarTodosPacientes() {
        return pacienteRepository.findAll();
    }

    // Método para buscar um paciente pelo id
    public Optional<Paciente> buscarPacientePorId(Long id) {
        return pacienteRepository.findById(id);
    }

    // Método para atualizar um paciente
    public Paciente atualizarPaciente(Long id, Paciente paciente) {
        if (pacienteRepository.existsById(id)) {
            paciente.setId(id);
            return pacienteRepository.save(paciente);
        }
        return null;  // Retorna null se o paciente não existir
    }

    // Método para deletar um paciente
    public void deletarPaciente(Long id) {
        pacienteRepository.deleteById(id);
    }
}
