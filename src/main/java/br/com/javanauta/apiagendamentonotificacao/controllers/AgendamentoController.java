package br.com.javanauta.apiagendamentonotificacao.controllers;

import br.com.javanauta.apiagendamentonotificacao.dtos.AgendamentoRequestDTO;
import br.com.javanauta.apiagendamentonotificacao.dtos.AgendamentoResponseDTO;
import br.com.javanauta.apiagendamentonotificacao.services.AgendamentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendamento")
@RequiredArgsConstructor
public class AgendamentoController {

    private final AgendamentoService service;

    @Operation(description = "Endpoint responsável por adicionar agendamentos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Agendamento gravado com sucesso."),
            @ApiResponse(responseCode = "400", description = "Falha na requisição"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor.")
    })
    @PostMapping
    public ResponseEntity<AgendamentoResponseDTO> gravarAgendamentos(
            @RequestBody AgendamentoRequestDTO agendamentoRequestDTO
    ) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.gravarAgendamento(agendamentoRequestDTO));
    }

    @Operation(description = "Endpoint responsável por buscar um agendamento pelo id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Agendamento encontrado com sucesso."),
            @ApiResponse(responseCode = "400", description = "Falha na requisição"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor.")
    })
    @GetMapping("/{id}")
    public ResponseEntity<AgendamentoResponseDTO> buscarAgendamentoPorId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarAgendamentoPorId(id));
    }
}
