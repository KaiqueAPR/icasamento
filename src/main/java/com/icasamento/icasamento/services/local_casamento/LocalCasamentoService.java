package com.icasamento.icasamento.services.local_casamento;

import com.icasamento.icasamento.dtos.local_casamento.LocalCasamentoRequestDto;
import com.icasamento.icasamento.dtos.local_casamento.LocalCasamentoResponseDto;
import com.icasamento.icasamento.models.local_casamento.LocalCasamentoModel;
import com.icasamento.icasamento.repositories.local_casamento.LocalCasamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

@Service
public class LocalCasamentoService {

    @Autowired
    private LocalCasamentoRepository localCasamentoRepository;

    /*
     *@param LocalCasamentoRequestDto
     *@return LocalCasamentoResponseDto
     */
    public LocalCasamentoResponseDto populaDashboard(LocalCasamentoRequestDto localCasamentoRequestDto){
// TODO: 01/12/2023
        return new LocalCasamentoResponseDto();
    }

}
