package br.com.javanauta.apiagendamentonotificacao.mappers;

import br.com.javanauta.apiagendamentonotificacao.dtos.AgendamentoRequestDTO;
import br.com.javanauta.apiagendamentonotificacao.dtos.AgendamentoResponseDTO;
import br.com.javanauta.apiagendamentonotificacao.entities.Agendamento;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface IAgendamentoMapper {

    Agendamento paraEntidade(AgendamentoRequestDTO dto);

    AgendamentoResponseDTO paraDto(Agendamento entity);

}
