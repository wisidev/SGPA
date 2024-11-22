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

    // Salvar um novo paciente
    public Paciente salvarPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    // Buscar todos os pacientes
    public List<Paciente> buscarTodosPacientes() {
        return pacienteRepository.findAll();
    }

    // Buscar paciente por ID
    public Optional<Paciente> buscarPacientePorId(Long id) {
        return pacienteRepository.findById(id);
    }

    // Atualizar paciente existente
    public Paciente atualizarPaciente(Long id, Paciente pacienteAtualizado) {
        return pacienteRepository.findById(id).map(paciente -> {
            paciente.setNomePaciente(pacienteAtualizado.getNomePaciente());
            paciente.setQueixaPaciente(pacienteAtualizado.getQueixaPaciente());
            paciente.setEndereco(pacienteAtualizado.getEndereco());
            paciente.setEmail(pacienteAtualizado.getEmail());
            paciente.setTelefone(pacienteAtualizado.getTelefone());
            paciente.setPlanoSaude(pacienteAtualizado.getPlanoSaude());
            paciente.setSexo(pacienteAtualizado.getSexo());
            paciente.setDataNascimento(pacienteAtualizado.getDataNascimento());
            paciente.setTipoSanguineo(pacienteAtualizado.getTipoSanguineo());
            paciente.setHistoricoDoencas(pacienteAtualizado.getHistoricoDoencas());
            paciente.setAlergias(pacienteAtualizado.getAlergias());
            paciente.setStatusProtocoloManchester(pacienteAtualizado.getStatusProtocoloManchester());
            paciente.setMedicacao(pacienteAtualizado.getMedicacao());
            return pacienteRepository.save(paciente);
        }).orElse(null); // Retorna null caso o paciente não seja encontrado
    }

    // Deletar paciente por ID
    public void deletarPaciente(Long id) {
        pacienteRepository.deleteById(id);
    }
}
