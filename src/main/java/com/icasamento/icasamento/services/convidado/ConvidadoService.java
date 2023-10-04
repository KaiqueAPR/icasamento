package com.icasamento.icasamento.services.convidado;

import com.icasamento.icasamento.configs.exceptions.ConvidadoNotFound;
import com.icasamento.icasamento.dtos.convidado.ConvidadoResponseDto;
import com.icasamento.icasamento.dtos.convidado.CriarConvidadoRequestDto;
import com.icasamento.icasamento.models.convidado.ConvidadoModel;
import com.icasamento.icasamento.repositories.convidado.ConvidadoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ConvidadoService {

    @Autowired
    private ConvidadoRepository convidadoRepository;

    /*Método responsável por cirar um novo Convidado*/
    public ConvidadoResponseDto novoCliente(CriarConvidadoRequestDto convidadoRequest) {
        ConvidadoModel convidado = new ConvidadoModel();
        BeanUtils.copyProperties(convidadoRequest, convidado);
        convidado = convidadoRepository.save(convidado);
        return converteParaDto(convidado);
    }

    /*Método responsável por retornar uma lista de todos os Convidados*/
    public Page<ConvidadoResponseDto> listaConvidados(Pageable pageable) {
        Page<ConvidadoModel> all = convidadoRepository.findAll(pageable);
        ModelMapper modelMapper = new ModelMapper();
        return new PageImpl<>(all.stream().map(clienteModel -> modelMapper.map(clienteModel, ConvidadoResponseDto.class)).collect(Collectors.toList()));
    }

    /*Método responsável por achar um Convidado atráves da variável 'cdConvidado'*/
    public ConvidadoResponseDto acharConvidadoPorId(Integer cdConvidado) {
        Optional<ConvidadoModel> optional = convidadoRepository.findById(cdConvidado);

        if (optional.isEmpty()) {
            throw new ConvidadoNotFound("O convidado que você tentou localizar não existe.");
        }
        return converteParaDto(optional.get());
    }

    /*Método responsável por deleter um Convidado atráves da variável 'cdConvidado'*/
    public void deletarConvidado(Integer cdConvidado) {
        if (convidadoRepository.existsById(cdConvidado)) {
            convidadoRepository.deleteById(cdConvidado);
        }
        throw new ConvidadoNotFound("O convidado que você tentou localizar não existe.");
    }

    /*Método responsável por realizar um update no Convidado atráves da variável 'cdConvidado'*/
    public ConvidadoResponseDto updatePorId(CriarConvidadoRequestDto criarConvidadoRequestDto, Integer cdConvidado) {
        Optional<ConvidadoModel> optional = convidadoRepository.findById(cdConvidado);
        if (optional.isPresent()) {
            ConvidadoModel convidado = optional.get();
            BeanUtils.copyProperties(criarConvidadoRequestDto, convidado);
            convidado = convidadoRepository.save(convidado);
            return converteParaDto(convidado);
        }
        throw new ConvidadoNotFound("O usuário que você tentou localizar não existe.");
    }


    /*Método responsável por converter um objeto para DTO*/
    private ConvidadoResponseDto converteParaDto(ConvidadoModel convidado) {
        ConvidadoResponseDto convidadoDto = new ConvidadoResponseDto();
        convidadoDto.setNmConvidado(convidado.getNmConvidado());
        convidadoDto.setNrTelefone(convidado.getNrTelefone());
        convidadoDto.setNmEmail(convidado.getNmEmail());
        convidadoDto.setTxCpf(convidado.getTxCpf());
        return convidadoDto;
    }
}
