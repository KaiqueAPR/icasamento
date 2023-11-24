package com.icasamento.icasamento.services.cidade;

import com.icasamento.icasamento.models.cidade.CidadeModel;
import com.icasamento.icasamento.repositories.cidade.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    public List<CidadeModel> buscarCidadesPorTermo(String nmCidade) {
        try {
            return cidadeRepository.findByNmCidadeContainingIgnoreCase(nmCidade);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao buscar cidades por termo: " + e.getMessage(), e);
        }
    }
}

