package com.project.serasa.service;

import com.project.serasa.domain.Vendedor;
import com.project.serasa.dto.AtuacaoDTO;
import com.project.serasa.dto.VendedorAtuacaoDTO;
import com.project.serasa.dto.VendedorDTO;
import com.project.serasa.repository.VendedorRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VendedorService {
    private final ModelMapper modelMapper;
    private final AtuacaoService atuacaoService;
    private final VendedorRepository vendedorRepository;

    public List<VendedorAtuacaoDTO> findAll() {
        List<Vendedor> vendedores = vendedorRepository.findAll();

        return vendedores.stream()
                .map(this::getVendedorAtuacaoDTO)
                .collect(Collectors.toList());
    }

    private VendedorAtuacaoDTO getVendedorAtuacaoDTO(Vendedor vendedor) {
            VendedorAtuacaoDTO vendededorAtuacao = new VendedorAtuacaoDTO();
            vendededorAtuacao.setNome(vendedor.getNome());
            vendededorAtuacao.setCidade(vendedor.getCidade());
            vendededorAtuacao.setIdade(vendedor.getIdade());
            vendededorAtuacao.setEstado(vendedor.getEstado());
            vendededorAtuacao.setEstados(getEstados(vendedor));
            vendededorAtuacao.setDataInclusa(vendedor.getDataInclusa());
            vendededorAtuacao.setTelefone(vendedor.getTelefone());
            return vendededorAtuacao;
    }

    private List<String> getEstados(Vendedor vendedor) {
        return atuacaoService.findByRegiao(vendedor.getRegiao()).getEstados();
    }

    private List<String> getListEstados(List<AtuacaoDTO> atuacoes) {
        return atuacoes.stream()
                .map(AtuacaoDTO::getEstados)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    public Optional<Vendedor> findById(Integer id) {
        return vendedorRepository.findById(id);
    }

    public VendedorDTO createVendedor(VendedorDTO vendedorDTO){
        Vendedor vendedor = modelMapper.map(vendedorDTO, Vendedor.class);
        Vendedor vendedorSave = vendedorRepository.save(vendedor);
        return modelMapper.map(vendedorSave, VendedorDTO.class);
    }
}
