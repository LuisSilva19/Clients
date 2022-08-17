package com.project.serasa.service;

import com.project.serasa.domain.Atuacao;
import com.project.serasa.dto.AtuacaoDTO;
import com.project.serasa.repository.AtuacaoRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class AtuacaoService {

    private final AtuacaoRepository atuacaoRepository;
    private final ModelMapper modelMapper;

    public AtuacaoDTO findByRegiao(String regiao) {
        Atuacao atuacao = atuacaoRepository.findById(regiao)
                .orElseThrow(()-> new EntityNotFoundException());

        return modelMapper.map(atuacao, AtuacaoDTO.class);
    }

    public AtuacaoDTO createAtuacao(AtuacaoDTO atuacaoDTO){
        Atuacao atuacao = modelMapper.map(atuacaoDTO, Atuacao.class);
        Atuacao atuacaoSave = atuacaoRepository.save(atuacao);
        return modelMapper.map(atuacaoSave, AtuacaoDTO.class);
    }
}
