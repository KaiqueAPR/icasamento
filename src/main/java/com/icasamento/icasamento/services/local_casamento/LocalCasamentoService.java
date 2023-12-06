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
     *@return List<LocalCasamentoModel>
     */
    public List<LocalCasamentoModel> buscarLocaisCasamento(LocalCasamentoRequestDto localCasamentoRequestDto) {
        StringBuilder query = getStringBuilder(localCasamentoRequestDto);

        TypedQuery<LocalCasamentoModel> typedQuery = entityManager.createQuery(query.toString(), LocalCasamentoModel.class);

        // Adicione parâmetros à consulta apenas se os valores não forem nulos
        if (localCasamentoRequestDto.getQtdConvidados() != null) {
            typedQuery.setParameter("qtdConvidados", localCasamentoRequestDto.getQtdConvidados());
        }
        if (localCasamentoRequestDto.getEstadoModel() != null && localCasamentoRequestDto.getEstadoModel().getCdEstado() != null) {
            typedQuery.setParameter("cdEstado", localCasamentoRequestDto.getEstadoModel().getCdEstado());
        }
        if (localCasamentoRequestDto.getCidadeModel() != null && localCasamentoRequestDto.getCidadeModel().getCdCidade() != null) {
            typedQuery.setParameter("cdCidade", localCasamentoRequestDto.getCidadeModel().getCdCidade());
        }
        return typedQuery.getResultList();
    }

    private static StringBuilder getStringBuilder(LocalCasamentoRequestDto localCasamentoRequestDto) {
        StringBuilder query = new StringBuilder("SELECT lc FROM LocalCasamentoModel lc WHERE 1=1");

        EstadoModel estadoModel = localCasamentoRequestDto.getEstadoModel();
        CidadeModel cidadeModel = localCasamentoRequestDto.getCidadeModel();

        if (localCasamentoRequestDto.getQtdConvidados() != null) {
            query.append(" AND lc.qtdConvidados <= :qtdConvidados");
        }
        // Se o campo do estado estiver preenchido, adiciona à consulta
        if (localCasamentoRequestDto.getEstadoModel() != null && localCasamentoRequestDto.getEstadoModel().getCdEstado() != null) {
            query.append(" AND lc.estadoModel.cdEstado = :cdEstado");
        }
        // Se o campo da cidade estiver preenchido, adiciona à consulta
        if (localCasamentoRequestDto.getCidadeModel() != null && localCasamentoRequestDto.getCidadeModel().getCdCidade() != null) {
            query.append(" AND lc.cidadeModel.cdCidade = :cdCidade");
        }
        return query;
    }
}
