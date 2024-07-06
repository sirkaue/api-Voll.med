package com.sirkaue.med.voll.api.endereco;

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
}
