package com.project.serasa.utils;

import com.project.serasa.dto.VendedorAtuacaoDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.project.serasa.utils.VendedorUtil.getListEstados;

public class VendedorAtuacaoUtil {
    public static VendedorAtuacaoDTO getVendedorAtuacaoDTO(){
        VendedorAtuacaoDTO vendedorAtuacaoDTO = new VendedorAtuacaoDTO();
        vendedorAtuacaoDTO.setNome("Luis");
        vendedorAtuacaoDTO.setCidade("SBC");
        vendedorAtuacaoDTO.setIdade(20);
        vendedorAtuacaoDTO.setEstado("SP");
        vendedorAtuacaoDTO.setTelefone("99 9999-99999");
        vendedorAtuacaoDTO.setEstados(getListEstados());
        return vendedorAtuacaoDTO;
    }

    public static List<VendedorAtuacaoDTO> getListVendedoresAtuacaoDTO(){
        return new ArrayList<>(
                Arrays.asList(getVendedorAtuacaoDTO(),
                        getVendedorAtuacaoDTO(),
                        getVendedorAtuacaoDTO()));
    }
}
