package com.project.serasa.controller;

import com.project.serasa.domain.Vendedor;
import com.project.serasa.dto.VendedorAtuacaoDTO;
import com.project.serasa.dto.VendedorDTO;
import com.project.serasa.service.VendedorService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vendedor")
@RequiredArgsConstructor
public class VendedorController {

    private final VendedorService vendedorService;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<VendedorAtuacaoDTO>> findAll(){
        List<VendedorAtuacaoDTO> vendedorAtuacaoDTO = vendedorService.findAll();
        return ResponseEntity.ok(vendedorAtuacaoDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VendedorDTO> findById(@RequestParam("id") Integer id){
        Optional<Vendedor> vendedor = vendedorService.findById(id);
        if(vendedor.isPresent()){
            VendedorDTO vendedorDTO = modelMapper.map(vendedor.get(), VendedorDTO.class);
            return ResponseEntity.ok(vendedorDTO);
        }else{
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping
    public ResponseEntity<VendedorDTO> createVendedor(@RequestBody VendedorDTO vendedorDTO, UriComponentsBuilder uriComponentsBuilder){
        VendedorDTO vendedor = vendedorService.createVendedor(vendedorDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(vendedor);
    }

}
