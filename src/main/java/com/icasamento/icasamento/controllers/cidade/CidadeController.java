package com.icasamento.icasamento.controllers.cidade;

import com.icasamento.icasamento.models.cidade.CidadeModel;
import com.icasamento.icasamento.repositories.cidade.CidadeRepository;
import com.icasamento.icasamento.services.cidade.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cidade")
public class CidadeController {

    @Autowired
    private CidadeService cidadeService;

    @GetMapping("/buscar-cidades")
    public ResponseEntity<List<CidadeModel>> buscarCidades(@RequestParam String termo) {
        List<CidadeModel> cidades = cidadeService.buscarCidadesPorTermo(termo);
        if(!cidades.isEmpty()) {
            return ResponseEntity.ok(cidades);
        }
        return ResponseEntity.ofNullable(cidades);
    }
}
