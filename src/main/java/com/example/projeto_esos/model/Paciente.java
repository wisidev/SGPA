package com.example.projeto_esos.model;

import jakarta.persistence.*;
import java.time.LocalDate;

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

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    private String tipoSanguineo;
    private String historicoDoencas;
    private String alergias;

    // Protocolo de Manchester
    private String statusProtocoloManchester;

    // Medicação
    private String medicacao;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public String getQueixaPaciente() {
        return queixaPaciente;
    }

    public void setQueixaPaciente(String queixaPaciente) {
        this.queixaPaciente = queixaPaciente;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getPlanoSaude() {
        return planoSaude;
    }

    public void setPlanoSaude(String planoSaude) {
        this.planoSaude = planoSaude;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    public String getHistoricoDoencas() {
        return historicoDoencas;
    }

    public void setHistoricoDoencas(String historicoDoencas) {
        this.historicoDoencas = historicoDoencas;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getStatusProtocoloManchester() {
        return statusProtocoloManchester;
    }

    public void setStatusProtocoloManchester(String statusProtocoloManchester) {
        this.statusProtocoloManchester = statusProtocoloManchester;
    }

    public String getMedicacao() {
        return medicacao;
    }

    public void setMedicacao(String medicacao) {
        this.medicacao = medicacao;
    }

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
                ", dataNascimento=" + dataNascimento +
                ", tipoSanguineo='" + tipoSanguineo + '\'' +
                ", historicoDoencas='" + historicoDoencas + '\'' +
                ", alergias='" + alergias + '\'' +
                ", statusProtocoloManchester='" + statusProtocoloManchester + '\'' +
                ", medicacao='" + medicacao + '\'' +
                '}';
    }
}
