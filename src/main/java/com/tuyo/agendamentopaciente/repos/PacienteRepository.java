package com.tuyo.agendamentopaciente.repos;

import com.bharath.springdata.patientscheduling.entities.Patient;
import org.springframework.data.repository.CrudRepository;

public interface PacienteRepository extends CrudRepository<Patient, Long> {

}
