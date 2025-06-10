package com.example.projeto_esos.controller;

import com.example.projeto_esos.model.Paciente;
import com.example.projeto_esos.repository.mongo.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ListarPacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;

    @GetMapping("/listar_paciente")
    public String mostrarPaginaListarPacientes(Model model) {
        // Buscar todos os pacientes no MongoDB
        List<Paciente> pacientes = pacienteRepository.findAll();
        // Adicionar a lista no model para o Thymeleaf
        model.addAttribute("pacientes", pacientes);
        // Retornar o nome do template
        return "listar_paciente";
    }

    @GetMapping("/paciente/detalhes/{id}")
    @ResponseBody
    public ResponseEntity<Paciente> getPacienteById(@PathVariable String id) {
        return pacienteRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    } 
}
