package com.project.serasa.utils;

import com.project.serasa.domain.Vendedor;
import com.project.serasa.dto.VendedorDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VendedorUtil {

    public static VendedorDTO getVendedorDTO(){
        VendedorDTO vendedorDTO = new VendedorDTO();
        vendedorDTO.setNome("Luis");
        vendedorDTO.setCidade("SBC");
        vendedorDTO.setIdade(20);
        vendedorDTO.setEstado("SP");
        vendedorDTO.setTelefone("99 9999-99999");
        return vendedorDTO;
    }

    public static Vendedor getVendedor(){
        Vendedor vendedor = new Vendedor();
        vendedor.setNome("Luis");
        vendedor.setCidade("SBC");
        vendedor.setIdade(20);
        vendedor.setEstado("SP");
        vendedor.setTelefone("99 9999-99999");
        return vendedor;
    }

    public static List<Vendedor> getListVendedores(){
        return new ArrayList<>(
                Arrays.asList(getVendedor(),
                        getVendedor(),
                        getVendedor()));
    }

    public static List<String> getListEstados(){
        return Arrays.asList("RS", "PR", "SC");
    }
}
