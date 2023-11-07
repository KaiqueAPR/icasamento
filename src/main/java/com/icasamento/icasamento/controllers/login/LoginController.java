package com.icasamento.icasamento.controllers.login;

import com.icasamento.icasamento.dtos.login.LoginRequestDto;
import com.icasamento.icasamento.services.login.LoginService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/entrar")
    public Boolean entrar(@RequestBody @Valid LoginRequestDto loginRequestDTO) {
        return loginService.login(loginRequestDTO.getNmEmail(), loginRequestDTO.getCdSenha());
    }

}
