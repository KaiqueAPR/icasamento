package com.icasamento.icasamento.dtos.presente;

import com.icasamento.icasamento.models.tipopresente.TipoPresenteModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class PresenteResponseDto {

    private String nmPresente;

    private List<TipoPresenteModel> tipoPresenteModel;

    private String txLink;

    private Float vlPreco;

    private String txCaminhoImagem;
}
