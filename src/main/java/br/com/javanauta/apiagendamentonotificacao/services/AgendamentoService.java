package br.com.javanauta.apiagendamentonotificacao.services;

import br.com.javanauta.apiagendamentonotificacao.dtos.AgendamentoRequestDTO;
import br.com.javanauta.apiagendamentonotificacao.dtos.AgendamentoResponseDTO;
import br.com.javanauta.apiagendamentonotificacao.mappers.IAgendamentoMapper;
import br.com.javanauta.apiagendamentonotificacao.repositories.AgendamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AgendamentoService {

    private final AgendamentoRepository repository;
    private final IAgendamentoMapper mapper;

    public AgendamentoResponseDTO gravarAgendamento(AgendamentoRequestDTO agendamento) {
        return mapper.paraDto(
                repository.save(
                        mapper.paraEntidade(agendamento)));
    }

}
