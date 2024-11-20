package com.example.projeto_esos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.projeto_esos.model.Usuario;
import com.example.projeto_esos.service.UsuarioService; // Crie o serviço para interagir com o banco de dados

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // Tela de login
    @GetMapping("/login")
    public String loginPage() {
        return "login";  // login.html
    }

    // Tela de consulta se o usuário está no banco
    @GetMapping("/usuario/consulta")
    public String consultaUsuarioPage() {
        return "usuario_consulta";  // usuario_consulta.html
    }

    // Verificar se o usuário existe no banco
    @PostMapping("/usuario/consulta")
    public String verificarUsuario(@RequestParam String username, Model model) {
        Usuario usuario = usuarioService.findByUsername(username);
        if (usuario != null) {
            model.addAttribute("usuario", usuario);
            return "usuario_consulta";  // Exibe os dados do usuário
        } else {
            model.addAttribute("erro", "Usuário não encontrado.");
            return "usuario_consulta";  // Exibe a mensagem de erro
        }
    }
}
