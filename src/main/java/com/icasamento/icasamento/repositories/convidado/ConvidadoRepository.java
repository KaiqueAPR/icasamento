package com.icasamento.icasamento.repositories.convidado;

import com.icasamento.icasamento.models.convidado.ConvidadoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConvidadoRepository extends JpaRepository<ConvidadoModel, Integer> {
}
