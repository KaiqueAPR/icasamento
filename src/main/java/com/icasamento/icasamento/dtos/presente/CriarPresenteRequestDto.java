package com.icasamento.icasamento.dtos.presente;

import com.icasamento.icasamento.models.tipopresente.TipoPresenteModel;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

import java.util.List;


@Builder
@Data
public class CriarPresenteRequestDto {

    @NotBlank(message = "Nome do presente deve ser preenchido!")
    @NotNull(message = "Nome do presente não pode ser nulo!")
    @Size(max = 200, message = "Nome do presente deve conter no máximo 200 caracteres!")
    private String nmPresente;

    private List<@Valid TipoPresenteModel> tipoPresenteModel;

    @NotBlank(message = "O link deve ser preenchido!")
    @NotNull(message = "O link não pode ser nulo!")
    private String txLink;

    @NotBlank(message = "O preço deve ser preenchido!")
    @NotNull(message = "O preço não pode ser nulo!")
    private Float vlPreco;

    @NotBlank(message = "A imagem deve ser preenchida!")
    @NotNull(message = "A imagem não pode ser nula!")
    private String txCaminhoImagem;
}
