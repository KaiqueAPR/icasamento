package com.icasamento.icasamento.controllers.estado;

import com.icasamento.icasamento.models.estado.EstadoModel;
import com.icasamento.icasamento.repositories.estado.EstadoRepository;
import com.icasamento.icasamento.services.estado.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/estado")
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    @GetMapping("/buscar-estados")
    public ResponseEntity<List<EstadoModel>> buscarEstados() {
        List<EstadoModel> estados = estadoService.buscarTodosEstados();
        return ResponseEntity.ok(estados);
    }
}

