package com.sirkaue.med.voll.api.domain.consulta.validacoes;

import com.sirkaue.med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import com.sirkaue.med.voll.api.domain.consulta.exceptions.ValidacaoException;
import com.sirkaue.med.voll.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPacienteAtivo implements ValidadorAgendamentoDeConsulta {

    @Autowired
    private PacienteRepository repository;

    public void validar(DadosAgendamentoConsulta dados) {
        var pacienteEstaAtivo = repository.findAtivoById(dados.idPaciente());
        if (!pacienteEstaAtivo) {
            throw new ValidacaoException("Consulta não pode ser agendada com paciente excluído");
        }
    }
}
