package com.icasamento.icasamento.services.local_casamento;

import com.icasamento.icasamento.configs.exceptions.LocalCasamentoNotFound;
import com.icasamento.icasamento.dtos.local_casamento.LocalCasamentoRequestDto;
import com.icasamento.icasamento.dtos.local_casamento.LocalCasamentoResponseDto;
import com.icasamento.icasamento.models.cidade.CidadeModel;
import com.icasamento.icasamento.models.estado.EstadoModel;
import com.icasamento.icasamento.models.local_casamento.LocalCasamentoModel;
import com.icasamento.icasamento.repositories.local_casamento.LocalCasamentoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalCasamentoService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private LocalCasamentoRepository localCasamentoRepository;

    /*
     *@param LocalCasamentoRequestDto
     *@return LocalCasamentoResponseDto
     */

    public List<LocalCasamentoModel> buscarLocaisCasamento(LocalCasamentoRequestDto localCasamentoRequestDto) {
        StringBuilder query = new StringBuilder("SELECT lc FROM LocalCasamentoModel lc WHERE 1=1");

        EstadoModel estadoModel = localCasamentoRequestDto.getEstadoModel();
        CidadeModel cidadeModel = localCasamentoRequestDto.getCidadeModel();

        // Se o campo do estado estiver preenchido, adiciona à consulta
        if (estadoModel.getCdEstado() != null) {
            query.append(" AND lc.estadoModel.cdEstado = :cdEstado");
        }

        // Se o campo da cidade estiver preenchido, adiciona à consulta
        if (cidadeModel.getCdCidade() != null) {
            query.append(" AND lc.cidadeModel.cdCidade = :cdCidade");
        }

        TypedQuery<LocalCasamentoModel> typedQuery = entityManager.createQuery(query.toString(), LocalCasamentoModel.class);

        // Adicione parâmetros à consulta se os valores não forem nulos
        if (estadoModel.getCdEstado() != null) {
            typedQuery.setParameter("cdEstado", estadoModel.getCdEstado());
        }

        if (cidadeModel.getCdCidade() != null) {
            typedQuery.setParameter("cdCidade", cidadeModel.getCdCidade());
        }
        return typedQuery.getResultList();
    }
}
