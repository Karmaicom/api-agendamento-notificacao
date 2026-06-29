package br.com.javanauta.apiagendamentonotificacao.repositories;

import br.com.javanauta.apiagendamentonotificacao.entities.Agendamento;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

}
