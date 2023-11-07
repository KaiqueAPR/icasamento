package com.icasamento.icasamento.dtos.login;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class LoginRequestDto {

    @NotBlank(message = "Email deve ser preenchido!")
    @NotNull(message = "Email não pode ser nulo!")
    @Email(message = "Email inválido!")
    @Size(max = 200, message = "Email deve ter no máximo 200 caracteres!")
    private String nmEmail;

    @NotBlank(message = "Senha deve ser preenchido!")
    @NotNull(message = "Senha não pode ser nulo!")
    @Size(max = 20, message = "Senha deve ter no máximo 20 caracteres!")
    private String cdSenha;

}
