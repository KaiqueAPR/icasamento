package com.icasamento.icasamento.dtos.convidado;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CriarConvidadoRequestDto {

    @NotBlank(message = "Nome deve ser preenchido!")
    @NotNull(message = "Nome não pode ser nulo!")
    @Size(max = 200, message = "Nome deve conter no máximo 200 caracteres!")
    private String nmConvidado;

    @NotBlank(message = "Telefone deve ser preenchido!")
    @NotNull(message = "Telefone não pode ser nulo!")
    @Size(min = 10, max = 11, message = "Telefone deve conter entre 10 e 11 números!")
    private String nrTelefone;

    @NotBlank(message = "Email deve ser preenchido!")
    @NotNull(message = "Email não pode ser nulo!")
    @Email(message = "Email inválido!")
    @Size(max = 200, message = "Email deve ter no máximo 200 caracteres!")
    private String nmEmail;

    @NotBlank(message = "CPF deve ser preenchido!")
    @NotNull(message = "CPF não pode ser nulo!")
    @Size(max = 11, message = "CPF deve contre no máximo 11 caracteres!")
    private String txCpf;

    @NotBlank(message = "Senha deve ser preenchido!")
    @NotNull(message = "Senha não pode ser nulo!")
    @Size(max = 20, message = "Senha deve ter no máximo 20 caracteres!")
    private String cdSenha;

}
