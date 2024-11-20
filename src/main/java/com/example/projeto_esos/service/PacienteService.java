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

    public Paciente salvarPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public List<Paciente> buscarTodosPacientes() {
        return pacienteRepository.findAll();
    }

    public Optional<Paciente> buscarPacientePorId(Long id) {
        return pacienteRepository.findById(id);
    }

    public Paciente atualizarPaciente(Long id, Paciente pacienteAtualizado) {
        return pacienteRepository.findById(id).map(paciente -> {
            paciente.setNomePaciente(pacienteAtualizado.getNomePaciente());
            paciente.setNomePaciente(pacienteAtualizado.getQueixaPaciente());
            // Atualizar outros campos
            return pacienteRepository.save(paciente);
        }).orElse(null);
    }

    public void deletarPaciente(Long id) {
        pacienteRepository.deleteById(id);
    }
}