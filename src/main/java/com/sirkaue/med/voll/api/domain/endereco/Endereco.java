package com.sirkaue.med.voll.api.domain.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    private String logradouro;
    private String bairro;
    private String cep;
    private String cidade;
    private String uf;
    private String complemento;
    private String numero;

    public Endereco(DadosEndereco dados) {
        logradouro = dados.logradouro();
        bairro = dados.bairro();
        cep = dados.cep();
        cidade = dados.cidade();
        uf = dados.uf();
        complemento = dados.complemento();
        numero = dados.numero();
    }

    public void atualizarInformacoes(DadosEndereco dados) {
        if (dados.logradouro() != null) {
            logradouro = dados.logradouro();
        }
        if (dados.bairro() != null) {
            bairro = dados.bairro();
        }
        if (dados.cep() != null) {
            cep = dados.cep();
        }
        if (dados.cidade() != null) {
            cidade = dados.cidade();
        }
        if (dados.uf() != null) {
            uf = dados.uf();
        }
        if (dados.complemento() != null) {
            complemento = dados.complemento();
        }
        if (dados.numero() != null) {
            numero = dados.numero();
        }
    }
}
