package com.icasamento.icasamento.services.estado;

import com.icasamento.icasamento.models.estado.EstadoModel;
import com.icasamento.icasamento.repositories.estado.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    public List<EstadoModel> buscarTodosEstados() {
        return estadoRepository.findAll();
    }
}

