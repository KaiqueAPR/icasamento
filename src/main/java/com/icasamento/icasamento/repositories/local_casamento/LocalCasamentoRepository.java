package com.icasamento.icasamento.repositories.local_casamento;

import com.icasamento.icasamento.models.local_casamento.LocalCasamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalCasamentoRepository extends JpaRepository<LocalCasamentoModel, Integer> {
}
