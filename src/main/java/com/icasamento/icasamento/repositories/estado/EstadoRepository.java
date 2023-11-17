package com.icasamento.icasamento.repositories.estado;

import com.icasamento.icasamento.models.estado.EstadoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<EstadoModel, Integer> {
}
