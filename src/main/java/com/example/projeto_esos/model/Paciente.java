package com.example.projeto_esos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nomePaciente;

    @Column(nullable = false)
    private String queixaPaciente;

    // Informações pessoais
    private String endereco;
    private String email;
    private String telefone;
    private String planoSaude;

    // Informações médicas
    private String sexo;
    private String dataNascimento; // Usar formato dd/mm/aaaa
    private String tipoSanguineo;
    private String historicoDoencas;
    private String alergias;

    // Protocolo de Manchester
    private String statusProtocoloManchester;

    // Medicação
    private String medicacao;

    // Getters e Setters
    // [os getters e setters seguem a mesma estrutura da resposta anterior]

    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", nomePaciente='" + nomePaciente + '\'' +
                ", queixaPaciente='" + queixaPaciente + '\'' +
                ", endereco='" + endereco + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", planoSaude='" + planoSaude + '\'' +
                ", sexo='" + sexo + '\'' +
                ", dataNascimento='" + dataNascimento + '\'' +
                ", tipoSanguineo='" + tipoSanguineo + '\'' +
                ", historicoDoencas='" + historicoDoencas + '\'' +
                ", alergias='" + alergias + '\'' +
                ", statusProtocoloManchester='" + statusProtocoloManchester + '\'' +
                ", medicacao='" + medicacao + '\'' +
                '}';
    }

    public void setId(Long id2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setId'");
    }
}
