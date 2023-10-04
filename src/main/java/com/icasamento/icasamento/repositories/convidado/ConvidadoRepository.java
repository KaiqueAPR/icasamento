package com.icasamento.icasamento.repositories.convidado;

import com.icasamento.icasamento.models.convidado.ConvidadoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConvidadoRepository extends JpaRepository<ConvidadoModel, Integer> {
}
