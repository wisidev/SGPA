package com.example.projeto_esos.controller;

import com.example.projeto_esos.model.Paciente;
import com.example.projeto_esos.repository.mongo.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;

    // Rota para exibir o formulário de cadastro
    @GetMapping("/cadastro_paciente")
    public ModelAndView getCadastroPaciente() {
        ModelAndView mv = new ModelAndView("cadastro_paciente");
        return mv;
    }

    @PostMapping("/cadastro_paciente")
    public ModelAndView salvarPaciente(@ModelAttribute Paciente paciente) {
        pacienteRepository.save(paciente);
        return new ModelAndView("cadastro_paciente");
    }

}