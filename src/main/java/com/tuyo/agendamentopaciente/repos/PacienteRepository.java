package com.tuyo.agendamentopaciente.repos;

import com.tuyo.agendamentopaciente.entities.Paciente;
import org.springframework.data.repository.CrudRepository;

public interface PacienteRepository extends CrudRepository<Paciente, Long> {

}
