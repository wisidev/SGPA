package com.example.projeto_esos.controller;

import com.example.projeto_esos.model.Paciente;
import com.example.projeto_esos.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    // Endpoint para exibir a página de listagem de pacientes
    @GetMapping
    public String listarPacientes(Model model) {
        List<Paciente> pacientes = pacienteService.buscarTodosPacientes();
        model.addAttribute("pacientes", pacientes);
        return "listar_pacientes"; 
    }

    // Endpoint para exibir o formulário de cadastro de paciente
    @GetMapping("/novo")
    public String exibirFormularioCadastro(Model model) {
        model.addAttribute("paciente", new Paciente());
        return "cadastro_pacientes"; // Nome correto do arquivo HTML
    }

    // Endpoint para salvar um paciente
    @PostMapping
    public String salvarPaciente(@ModelAttribute("paciente") Paciente paciente) {
        pacienteService.salvarPaciente(paciente);
        return "redirect:/pacientes"; // Redireciona para a lista de pacientes
    }

    // Endpoint para exibir o formulário de edição de paciente
    @GetMapping("/editar/{id}")
    public String exibirFormularioEdicao(@PathVariable Long id, Model model) {
        Paciente paciente = pacienteService.buscarPacientePorId(id).orElse(null);
        model.addAttribute("paciente", paciente);
        return "cadastro_pacientes"; // Reutiliza o mesmo arquivo de cadastro para edição
    }

    // Endpoint para atualizar um paciente
    @PostMapping("/atualizar/{id}")
    public String atualizarPaciente(@PathVariable Long id, @ModelAttribute("paciente") Paciente pacienteAtualizado) {
        pacienteService.atualizarPaciente(id, pacienteAtualizado);
        return "redirect:/pacientes"; // Redireciona para a lista de
    }
}