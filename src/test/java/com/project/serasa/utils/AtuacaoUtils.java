package com.project.serasa.utils;

import com.project.serasa.domain.Atuacao;
import com.project.serasa.dto.AtuacaoDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AtuacaoUtils {
    public static AtuacaoDTO getAtuacaoDTO(){
        AtuacaoDTO atuacaoDTO = new AtuacaoDTO();
        atuacaoDTO.setRegiao("Sudeste");
        atuacaoDTO.setEstados(Arrays.asList("RS", "PR", "SC"));
        return atuacaoDTO;
    }

    public static Atuacao getAtuacao(){
        Atuacao atuacao = new Atuacao();
        atuacao.setRegiao("Sudeste");
        atuacao.setEstados(Arrays.asList("RS", "PR", "SC"));
        return atuacao;
    }
}
