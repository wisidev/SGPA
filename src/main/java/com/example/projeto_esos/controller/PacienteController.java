package com.example.projeto_esos.controller;

import com.example.projeto_esos.model.Paciente;
import com.example.projeto_esos.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    // Endpoint para salvar um novo paciente
    @PostMapping
    public ResponseEntity<Paciente> salvarPaciente(@RequestBody Paciente paciente) {
        Paciente pacienteSalvo = pacienteService.salvarPaciente(paciente);
        return new ResponseEntity<>(pacienteSalvo, HttpStatus.CREATED);
    }

    // Endpoint para listar todos os pacientes
    @GetMapping
    public ResponseEntity<List<Paciente>> listarPacientes() {
        List<Paciente> pacientes = pacienteService.buscarTodosPacientes();
        return new ResponseEntity<>(pacientes, HttpStatus.OK);
    }

    // Endpoint para buscar um paciente por ID
    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscarPacientePorId(@PathVariable Long id) {
        Optional<Paciente> paciente = pacienteService.buscarPacientePorId(id);
        if (paciente.isPresent()) {
            return new ResponseEntity<>(paciente.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Endpoint para atualizar as informações de um paciente
    @PutMapping("/{id}")
    public ResponseEntity<Paciente> atualizarPaciente(@PathVariable Long id, @RequestBody Paciente paciente) {
        Paciente pacienteAtualizado = pacienteService.atualizarPaciente(id, paciente);
        if (pacienteAtualizado != null) {
            return new ResponseEntity<>(pacienteAtualizado, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Endpoint para deletar um paciente
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPaciente(@PathVariable Long id) {
        pacienteService.deletarPaciente(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
