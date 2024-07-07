package com.sirkaue.med.voll.api.medico;

import com.sirkaue.med.voll.api.endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Medico")
@Table(name = "medicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    public Medico(DadosCadastroMedico dados) {
        nome = dados.nome();
        email = dados.email();
        telefone = dados.telefone();
        crm = dados.crm();
        especialidade = dados.especialidade();
        endereco = new Endereco(dados.endereco());
    }

    public void atualizarInformacoes(DadosAtualizacaoMedico dados) {
        if (dados.nome() != null) {
            nome = dados.nome();
        }
        if (dados.telefone() != null) {
            telefone = dados.telefone();
        }
        if (dados.endereco() != null) {
            endereco.atualizarInformacoes(dados.endereco());
        }
    }
}
