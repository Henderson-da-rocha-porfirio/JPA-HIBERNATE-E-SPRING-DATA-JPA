package com.tuyo.agendamentopaciente.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Medico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String firstName;
	private String lastName;
	private String speciality;

	@ManyToMany(mappedBy = "medicos")
	private List<Paciente> pacientes;

	@OneToMany(mappedBy = "medico", cascade = CascadeType.ALL)
	private List<Agendamento> agendamentos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	@Override
	public String toString() {
		return "Medico [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", speciality=" + speciality
				+ "]";
	}

	public List<Paciente> getPatients() {
		return pacientes;
	}

	public void setPatients(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

	public List<Agendamento> getAppointments() {
		return agendamentos;
	}

	public void setAppointments(List<Agendamento> agendamentos) {
		this.agendamentos = agendamentos;
	}

}
