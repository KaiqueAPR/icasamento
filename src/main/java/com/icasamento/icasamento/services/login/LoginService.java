package com.icasamento.icasamento.services.login;

import com.icasamento.icasamento.models.convidado.ConvidadoModel;
import com.icasamento.icasamento.repositories.convidado.ConvidadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    ConvidadoRepository convidadoRepository;

    /*Método responsável por verificar se este usuário existe*/
    public boolean login(String nmEmail, String cdSenha) {
        ConvidadoModel convidado = convidadoRepository.findByNmEmailAndCdSenha(nmEmail, cdSenha);
        return convidado != null;
    }
}
