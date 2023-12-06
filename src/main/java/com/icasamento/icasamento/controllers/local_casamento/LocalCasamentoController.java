package com.icasamento.icasamento.controllers.local_casamento;

import com.icasamento.icasamento.configs.exceptions.LocalCasamentoNotFound;
import com.icasamento.icasamento.dtos.local_casamento.LocalCasamentoRequestDto;
import com.icasamento.icasamento.models.local_casamento.LocalCasamentoModel;
import com.icasamento.icasamento.services.local_casamento.LocalCasamentoService;
import org.aspectj.bridge.IMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/local-casamento")
public class LocalCasamentoController {

    @Autowired
    private LocalCasamentoService localCasamentoService;

    @GetMapping("/buscar-locais-casamento")
    public ResponseEntity<List<LocalCasamentoModel>> buscarLocaisCasamento(
            @RequestBody LocalCasamentoRequestDto localCasamentoRequestDto) {
        List<LocalCasamentoModel> locaisCasamento = localCasamentoService.buscarLocaisCasamento(localCasamentoRequestDto);
        return new ResponseEntity<>(locaisCasamento, HttpStatus.OK);
    }
}
