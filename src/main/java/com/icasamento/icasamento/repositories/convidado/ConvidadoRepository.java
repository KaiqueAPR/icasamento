package com.icasamento.icasamento.repositories.convidado;

import com.icasamento.icasamento.models.convidado.ConvidadoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConvidadoRepository extends JpaRepository<ConvidadoModel, Integer> {
    @Query(value = "SELECT * FROM convidado WHERE CONV_NM_EMAIL = ?1 AND CONV_CD_SENHA = ?2", nativeQuery = true)
    ConvidadoModel findByNmEmailAndCdSenha(String nmEmail, String cdSenha);

}
