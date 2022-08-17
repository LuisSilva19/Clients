package com.project.serasa.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class AtuacaoDTO {
    private String Regiao;
    private List<String> estados = new ArrayList<>();
}
