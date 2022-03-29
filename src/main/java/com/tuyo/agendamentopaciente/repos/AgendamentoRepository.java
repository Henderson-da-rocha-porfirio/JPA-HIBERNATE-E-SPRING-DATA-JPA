package com.tuyo.agendamentopaciente.repos;

import com.bharath.springdata.patientscheduling.entities.Appointment;
import org.springframework.data.repository.CrudRepository;

public interface AgendamentoRepository extends CrudRepository<Appointment, Long> {

}
