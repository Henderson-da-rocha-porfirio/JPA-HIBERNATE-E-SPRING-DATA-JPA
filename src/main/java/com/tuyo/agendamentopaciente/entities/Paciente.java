package com.tuyo.agendamentopaciente.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Paciente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String firstName;
	private String lastName;
	private String phone;
	@Embedded
	private Seguranca seguranca;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "patients_doctors", joinColumns = @JoinColumn(name = "patient_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "doctor_id", referencedColumnName = "id"))
	private List<Medico> medicos;

	@OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Seguranca getInsurance() {
		return seguranca;
	}

	public void setInsurance(Seguranca seguranca) {
		this.seguranca = seguranca;
	}

	@Override
	public String toString() {
		return "Paciente [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", phone=" + phone
				+ ", seguranca=" + seguranca + "]";
	}

	public List<Medico> getDoctors() {
		return medicos;
	}

	public void setDoctors(List<Medico> medicos) {
		this.medicos = medicos;
	}

	public List<Agendamento> getAppointments() {
		return agendamentos;
	}

	public void setAppointments(List<Agendamento> agendamentos) {
		this.agendamentos = agendamentos;
	}

}
