package com.icasamento.icasamento.dtos.tipopresente;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CriarTipoPresenteRequestDto {

    @NotBlank(message = "Nome do tipo de presente deve ser preenchido!")
    @NotNull(message = "Nome do tipo de presente não pode ser nulo!")
    @Size(max = 200, message = "Nome do tipo de presente deve conter no máximo 200 caracteres!")
    private String nmTipoPresente;
}
