package com.project.serasa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Atuacao {
    @Id
    private String Regiao;
    @Column
    @ElementCollection(targetClass=String.class)
    @Size(max=26)
    private List<String> estados;
}
