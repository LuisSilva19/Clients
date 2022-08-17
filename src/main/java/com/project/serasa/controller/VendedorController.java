package com.project.serasa.controller;

import com.project.serasa.dto.VendedorAtuacaoDTO;
import com.project.serasa.dto.VendedorDTO;
import com.project.serasa.service.VendedorService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/vendedor")
@RequiredArgsConstructor
public class VendedorController {

    private final VendedorService vendedorService;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<VendedorAtuacaoDTO>> findAll(){
        return vendedorService.findAll()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.noContent().build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VendedorDTO> findById(@PathVariable("id") Integer id){
        return vendedorService.findById(id)
                .map(vendedor -> modelMapper.map(vendedor, VendedorDTO.class))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.noContent().build());
    }

    @PostMapping
    public ResponseEntity<VendedorDTO> createVendedor(@RequestBody @Valid VendedorDTO vendedorDTO, UriComponentsBuilder uriComponentsBuilder){
        VendedorDTO vendedor = vendedorService.createVendedor(vendedorDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(vendedor);
    }

}
