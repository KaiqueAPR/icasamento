package com.icasamento.icasamento.repositories.local_casamento;

import com.icasamento.icasamento.models.local_casamento.LocalCasamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocalCasamentoRepository extends JpaRepository<LocalCasamentoModel, Integer> {

    @Query(value = "SELECT lc FROM LocalCasamentoModel lc WHERE 1=1 AND (:queryString IS NULL OR :queryString = '')")
    List<LocalCasamentoModel> buscarLocaisCasamentoDinamico(@Param("queryString") String queryString);
}
