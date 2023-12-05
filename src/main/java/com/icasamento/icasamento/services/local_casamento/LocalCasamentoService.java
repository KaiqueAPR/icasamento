package com.icasamento.icasamento.services.local_casamento;

import com.icasamento.icasamento.configs.exceptions.LocalCasamentoNotFound;
import com.icasamento.icasamento.dtos.local_casamento.LocalCasamentoRequestDto;
import com.icasamento.icasamento.dtos.local_casamento.LocalCasamentoResponseDto;
import com.icasamento.icasamento.models.cidade.CidadeModel;
import com.icasamento.icasamento.models.estado.EstadoModel;
import com.icasamento.icasamento.models.local_casamento.LocalCasamentoModel;
import com.icasamento.icasamento.repositories.local_casamento.LocalCasamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalCasamentoService {

    @Autowired
    private LocalCasamentoRepository localCasamentoRepository;

    /*
     *@param LocalCasamentoRequestDto
     *@return LocalCasamentoResponseDto
     */
    public List<LocalCasamentoModel> buscarLocaisCasamento(LocalCasamentoRequestDto localCasamentoRequestDto){
        StringBuilder query  = new StringBuilder("SELECT lc FROM LocalCasamentoModel lc WHERE 1=1");

        CidadeModel cidadeModel = localCasamentoRequestDto.getCidadeModel();
        EstadoModel estadoModel = localCasamentoRequestDto.getEstadoModel();

        // Se o campo da quantidade de convidados vier preenchdio então ele é adicionado a Query
        //if (localCasamentoRequestDto.getQtdConvidados() != null) {
        //    query.append(" AND lc.qtdConvidados >= ").append(localCasamentoRequestDto.getQtdConvidados());
        //}

        // Se o campo do estado vier preenchdio então ele é adicionado a Query
        if(estadoModel.getCdEstado() != null){
            query.append(" AND lc.ESTA_CD_ESTADO = ").append(estadoModel.getCdEstado());
        }

        // Se o campo da cidade vier preenchdio então ele é adicionado a Query
        if(cidadeModel.getCdCidade() != null){
            query.append(" AND lc.CIDA_CD_CIDADE = ").append(cidadeModel.getCdCidade());
        }

        String queryString = query.toString();

        List<LocalCasamentoModel> listaLocalCasamento = localCasamentoRepository.buscarLocaisCasamentoDinamico(queryString);

        if(listaLocalCasamento.isEmpty()){
                throw new LocalCasamentoNotFound("O Local de Casamento que você tentou localizar não existe.");
        }
        return listaLocalCasamento;
    }

}
