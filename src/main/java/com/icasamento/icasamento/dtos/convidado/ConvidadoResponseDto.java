package com.icasamento.icasamento.dtos.convidado;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ConvidadoResponseDto {

    private String nmConvidado;
    private String nrTelefone;
    private String nmEmail;
    private String txCpf;
    private String cdSenha;

}
