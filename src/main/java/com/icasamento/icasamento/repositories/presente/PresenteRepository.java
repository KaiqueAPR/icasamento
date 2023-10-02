package com.icasamento.icasamento.repositories.presente;

import com.icasamento.icasamento.models.presente.PresenteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PresenteRepository extends JpaRepository<PresenteModel, Integer> {
}
