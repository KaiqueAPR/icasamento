package com.icasamento.icasamento.repositories.cidade;

import com.icasamento.icasamento.models.cidade.CidadeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<CidadeModel, Integer> {
}
