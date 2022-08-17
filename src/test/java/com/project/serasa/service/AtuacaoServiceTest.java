package com.project.serasa.service;

import com.project.serasa.domain.Atuacao;
import com.project.serasa.dto.AtuacaoDTO;
import com.project.serasa.repository.AtuacaoRepository;
import org.hibernate.service.spi.ServiceException;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Any;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static com.project.serasa.utils.AtuacaoUtils.getAtuacao;
import static com.project.serasa.utils.AtuacaoUtils.getAtuacaoDTO;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AtuacaoServiceTest {

    @Mock
    private AtuacaoRepository atuacaoRepository;
    @Mock
    private ModelMapper modelMapper;
    @InjectMocks
    private AtuacaoService atuacaoService;
    private AtuacaoDTO atuacaoDTO;
    private Atuacao atuacao;

    private static final String REGIAO_NAO_CADASTRADA = "Centro-oeste";


    @BeforeEach
    public void initEach(){
        atuacaoDTO = getAtuacaoDTO();
        atuacao = getAtuacao();
    }

    @Test
    void findByRegiao() {
        when(atuacaoRepository.findById(Mockito.any())).thenReturn(Optional.of(getAtuacao()));
        when(modelMapper.map(Mockito.any(), Mockito.any())).thenReturn(atuacaoDTO);

        AtuacaoDTO atuacaoByRegiao = atuacaoService.findByRegiao(atuacaoDTO.getRegiao());

        assertNotNull(atuacaoByRegiao);
        assertEquals(atuacaoDTO, atuacaoByRegiao);
    }

    @Test
    void findByRegiaoException() {
        assertThrows(ServiceException.class,
                () -> atuacaoService.findByRegiao(REGIAO_NAO_CADASTRADA),
                "exception.ar.notfound.id");
    }

    @Test
    void createAtuacao() {
        when(modelMapper.map(atuacaoDTO, Atuacao.class)).thenReturn(atuacao);
        when(atuacaoRepository.save(Mockito.any())).thenReturn(atuacao);
        when(modelMapper.map(atuacao, AtuacaoDTO.class)).thenReturn(atuacaoDTO);

        AtuacaoDTO atuacaoSave = atuacaoService.createAtuacao(atuacaoDTO);

        assertNotNull(atuacaoSave);
        assertEquals(atuacaoDTO, atuacaoSave);
    }
}