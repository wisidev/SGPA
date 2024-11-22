package com.example.projeto_esos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.projeto_esos.model.Usuario;
import com.example.projeto_esos.service.UsuarioService;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // Tela de login
    @GetMapping("/login")
    public String loginPage() {
        System.out.println("Rota /login acessada"); // Log para debug
        return "login"; // Retorna o template login.html
    }

    // Processa o login
    @PostMapping("/login")
    public String processarLogin(@RequestParam String usuario, @RequestParam String senha, Model model) {
        Usuario usuarioExistente = usuarioService.findByUsername(usuario);

        if (usuarioExistente != null && usuarioExistente.getSenha().equals(senha)) {
            // Redireciona para a página de cadastro de pacientes após login bem-sucedido
            return "redirect:/cadastro_paciente";
        } else {
            model.addAttribute("erro", "Usuário ou senha inválidos.");
            return "login"; // Retorna à página de login com erro
        }
    }

    // Tela de cadastro de usuário
    @GetMapping("/cadastro_usuario")
    public String cadastroUsuarioPage() {
        return "cadastro_usuario"; // Retorna o template cadastro_usuario.html
    }

    // Processa o cadastro de usuário
    @PostMapping("/cadastro_usuario")
    public String processarCadastro(@RequestParam String usuario, @RequestParam String senha, Model model) {
        Usuario novoUsuario = new Usuario(usuario, senha);
        usuarioService.salvarUsuario(novoUsuario);
        return "redirect:/login"; // Redireciona para a página de login após o cadastro
    }

    // Tela de cadastro de pacientes
    @GetMapping("/cadastro_paciente")
    public String cadastroPacientePage() {
        return "cadastro_paciente"; // Retorna o template cadastro_paciente.html
    }
}
