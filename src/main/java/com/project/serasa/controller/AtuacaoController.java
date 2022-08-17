package com.project.serasa.controller;

import com.project.serasa.dto.AtuacaoDTO;
import com.project.serasa.service.AtuacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/atuacao")
@RequiredArgsConstructor
public class AtuacaoController {

    private final AtuacaoService atuacaoService;

    @PostMapping
    public ResponseEntity<AtuacaoDTO> createAtuacao(@RequestBody AtuacaoDTO atuacaoDTO){
        atuacaoService.createAtuacao(atuacaoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(atuacaoDTO);
    }
}
