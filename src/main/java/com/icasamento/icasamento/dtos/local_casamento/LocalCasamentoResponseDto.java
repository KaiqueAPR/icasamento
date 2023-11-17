package com.icasamento.icasamento.dtos.local_casamento;

import com.icasamento.icasamento.models.cidade.CidadeModel;
import com.icasamento.icasamento.models.estado.EstadoModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class LocalCasamentoResponseDto {
    private String nmLocalCasamento;
    private Integer qtdConvidados;
    private CidadeModel cidadeModel;
    private EstadoModel estadoModel;
}
