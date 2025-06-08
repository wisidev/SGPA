package com.example.projeto_esos.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "pacientes")
public class Paciente {

    @Id
    private String id;
    private String nomePaciente;
    private String queixaPaciente;
    private String endereco;
    private String email;
    private String telefone;
    private String planoSaude;
    private String sexo;
    private LocalDate dataNascimento;
    private String tipoSanguineo;
    private String historicoDoencas;
    private String alergias;
    private String statusProtocoloManchester;
    private String medicacao;

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
