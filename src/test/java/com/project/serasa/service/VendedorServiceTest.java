package com.project.serasa.service;

import com.project.serasa.domain.Vendedor;
import com.project.serasa.dto.AtuacaoDTO;
import com.project.serasa.dto.VendedorAtuacaoDTO;
import com.project.serasa.dto.VendedorDTO;
import com.project.serasa.repository.AtuacaoRepository;
import com.project.serasa.repository.VendedorRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;

import static com.project.serasa.utils.AtuacaoUtils.getAtuacao;
import static com.project.serasa.utils.AtuacaoUtils.getAtuacaoDTO;
import static com.project.serasa.utils.VendedorAtuacaoUtil.getListVendedoresAtuacaoDTO;
import static com.project.serasa.utils.VendedorUtil.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VendedorServiceTest {

    @Mock
    private ModelMapper modelMapper;
    @Mock
    private VendedorRepository vendedorRepository;
    @Mock
    private AtuacaoService atuacaoService;
    @InjectMocks
    private VendedorService vendedorService;

    private VendedorDTO vendedorDTO;
    private Vendedor vendedor;

    @BeforeEach
    void initEach() {
        vendedorDTO = getVendedorDTO();
        vendedor = getVendedor();
    }

    @Test
    void findAll() {
        List<Vendedor> listVendedores = getListVendedores();
        List<VendedorAtuacaoDTO> listVendedoresAtuacaoDTO = getListVendedoresAtuacaoDTO();

        when(vendedorRepository.findAll()).thenReturn(listVendedores);
        when(atuacaoService.findByRegiao(Mockito.any())).thenReturn(getAtuacaoDTO());

        Optional<List<VendedorAtuacaoDTO>> vendedores = vendedorService.findAll();

        assertNotNull(vendedores.get());
        assertEquals(listVendedoresAtuacaoDTO.get(0).getEstados(), vendedores.get().get(0).getEstados());
        assertEquals(listVendedoresAtuacaoDTO.get(0).getEstado(), vendedores.get().get(0).getEstado());
        assertEquals(listVendedoresAtuacaoDTO.get(0).getCidade(), vendedores.get().get(0).getCidade());
        //TODO: Continuar detalhamento de teste
    }

    @Test
    void findById() {
        when(vendedorRepository.findById(Mockito.any())).thenReturn(Optional.of(vendedor));
        Optional<Vendedor> vendedorById = vendedorService.findById(1);

        assertNotNull(vendedorById);
        assertEquals(vendedor, vendedorById.get());
    }

    @Test
    void createVendedor() {
        when(vendedorRepository.save(Mockito.any())).thenReturn(vendedor);
        when(modelMapper.map(vendedorDTO, Vendedor.class)).thenReturn(vendedor);
        when(modelMapper.map(vendedor, VendedorDTO.class)).thenReturn(vendedorDTO);

        VendedorDTO vendedorSave = vendedorService.createVendedor(vendedorDTO);

        assertNotNull(vendedorSave);
        assertEquals(vendedorDTO, vendedorSave);
    }

    @Test
    void getEstados(){
        List<String> listEstados = getListEstados();
        when(atuacaoService.findByRegiao(Mockito.any())).thenReturn(getAtuacaoDTO());
        List<String> estados = vendedorService.getEstados(vendedor);

        assertNotNull(estados);
        assertEquals(listEstados,estados);
    }
}