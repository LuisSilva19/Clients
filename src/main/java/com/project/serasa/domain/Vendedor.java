package com.project.serasa.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Vendedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @CreatedDate
    private LocalDate dataInclusa;

    @Size(max=100)
    private String nome;

    @Size(max=15)
    private String telefone;

    @Positive
    @Max(170)
    private Integer idade;

    @Size(max=50)
    private String cidade;

    @Size(max=80)
    private String estado;

    @Size(max=80)
    private String regiao;
}
