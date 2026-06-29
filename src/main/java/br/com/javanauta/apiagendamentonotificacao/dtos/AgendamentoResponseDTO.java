package br.com.javanauta.apiagendamentonotificacao.dtos;

import br.com.javanauta.apiagendamentonotificacao.entities.enums.StatusNoficacaoEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record AgendamentoResponseDTO(
        Long id,
        String emailDestinatorio,
        String telefoneDestinatario,
        String mensagem,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
        LocalDateTime dataHoraEnvio,
        StatusNoficacaoEnum statusNoficacao
) {
}
