package com.icasamento.icasamento.controllers.convidado;

import com.icasamento.icasamento.dtos.convidado.ConvidadoResponseDto;
import com.icasamento.icasamento.dtos.convidado.CriarConvidadoRequestDto;
import com.icasamento.icasamento.services.convidado.ConvidadoService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/convidado")
public class ConvidadoController {

    private final ConvidadoService convidadoService;

    public ConvidadoController(ConvidadoService convidadoService) {
        this.convidadoService = convidadoService;
    }

    @GetMapping
    public Page<ConvidadoResponseDto> lista(@PageableDefault(page = 0, size = 10, sort = "cdConvidado", direction = Sort.Direction.ASC) Pageable pageable) {
        return convidadoService.listaConvidados(pageable);
    }

    @GetMapping("/{cdConvidado}")
    public ConvidadoResponseDto acharConvidadoPorId(@PathVariable("cdConvidado") Integer cdConvidado) {
        return convidadoService.acharConvidadoPorId(cdConvidado);
    }

    @PostMapping("/novo")
    public ConvidadoResponseDto novoCliente(@RequestBody @Valid CriarConvidadoRequestDto convidadoRequest) {
        return convidadoService.novoCliente(convidadoRequest);
    }

    @PutMapping("/{cdConvidado}")
    public ConvidadoResponseDto updatePorId(@RequestBody @Valid CriarConvidadoRequestDto criarConvidadoRequestDto, @PathVariable("cdConvidado") Integer cdConvidado) {
        return convidadoService.updatePorId(criarConvidadoRequestDto, cdConvidado);
    }

    @DeleteMapping("/{cdConvidado}")
    public void deletePorId(@PathVariable("cdConvidado") Integer cdConvidado) {
        convidadoService.deletarConvidado(cdConvidado  );
    }
}
