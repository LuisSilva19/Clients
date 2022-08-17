package com.project.serasa.repository;

import com.project.serasa.domain.Atuacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtuacaoRepository extends JpaRepository<Atuacao, String> {

}
