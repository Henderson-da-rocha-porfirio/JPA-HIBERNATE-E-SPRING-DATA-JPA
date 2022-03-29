package com.tuyo.agendamentopaciente.repos;

import com.bharath.springdata.patientscheduling.entities.Doctor;
import org.springframework.data.repository.CrudRepository;

public interface MedicoRepository extends CrudRepository<Doctor, Long> {

}
