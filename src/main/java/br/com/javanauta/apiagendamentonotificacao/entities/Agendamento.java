package br.com.javanauta.apiagendamentonotificacao.entities;

import br.com.javanauta.apiagendamentonotificacao.entities.enums.StatusNoficacaoEnum;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "agendamento")
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String emailDestinatario;
    private String telefoneDestinatario;
    private LocalDateTime dataHoraEnvio;
    private LocalDateTime dataHoraAgendamento;
    private LocalDateTime dataHoraModificacao;
    private String mensagem;
    private StatusNoficacaoEnum statusNoficacao;

    @PrePersist
    private void prePersist() {
        dataHoraAgendamento = LocalDateTime.now();
        statusNoficacao = StatusNoficacaoEnum.AGENDADO;
    }

}
