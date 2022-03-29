package com.tuyo.agendamentopaciente.repos;

import com.tuyo.agendamentopaciente.entities.Agendamento;
import org.springframework.data.repository.CrudRepository;

public interface AgendamentoRepository extends CrudRepository<Agendamento, Long> {

}
