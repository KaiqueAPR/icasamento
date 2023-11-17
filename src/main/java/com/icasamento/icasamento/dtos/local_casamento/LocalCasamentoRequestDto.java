package com.icasamento.icasamento.dtos.local_casamento;

import com.icasamento.icasamento.models.cidade.CidadeModel;
import com.icasamento.icasamento.models.estado.EstadoModel;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class LocalCasamentoRequestDto {

    @NotBlank(message = "Nome referente ao Local do Casamento deve ser preenchido!")
    @NotNull(message = "Nome referente ao Local do Casamento não pode ser nulo!")
    @Size(max = 255, message = "Nome referente ao Local do Casamento deve conter no máximo 255 caracteres!")
    private String nmLocalCasamento;

    @NotBlank(message = "Quantidade de Convidados deve ser preenchido!")
    @NotNull(message = "Quantidade de Convidados não pode ser nulo!")
    private Integer qtdConvidados;

    @NotBlank(message = "Cidade deve ser preenchido!")
    @NotNull(message = "Cidade não pode ser nulo!")
    private CidadeModel cidadeModel;

    @NotBlank(message = "Estado deve ser preenchido!")
    @NotNull(message = "Estado não pode ser nulo!")
    private EstadoModel estadoModel;

}
