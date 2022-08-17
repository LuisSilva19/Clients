package com.project.serasa.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class VendedorAtuacaoDTO {
    private LocalDate dataInclusa;
    private String nome;
    private String telefone;
    private Integer idade;
    private String cidade;
    private String estado;
    private List<String> estados = new ArrayList<>();
}
