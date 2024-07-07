package com.sirkaue.med.voll.api.controller;

import com.sirkaue.med.voll.api.medico.DadosCadastroMedico;
import com.sirkaue.med.voll.api.medico.DadosListagemMedico;
import com.sirkaue.med.voll.api.medico.Medico;
import com.sirkaue.med.voll.api.medico.MedicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados) {
        repository.save(new Medico(dados));
    }

    @GetMapping
    public Page<DadosListagemMedico> listar(Pageable pageable) {
        return repository.findAll(pageable).map(DadosListagemMedico::new);
    }
}
