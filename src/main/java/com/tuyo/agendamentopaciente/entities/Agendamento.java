package com.tuyo.agendamentopaciente.entities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Agendamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Timestamp agendamento_time;
	private boolean started;
	private boolean ended;
	private String razao;

	@ManyToOne
	@JoinColumn(name = "paciente_id")
	private Paciente paciente;

	@ManyToOne
	@JoinColumn(name = "medico_id")
	private Medico medico;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getAppointmentTime() {
		return agendamento_time;
	}

	public void setAppointmentTime(Timestamp agendamento_time) {
		this.agendamento_time = agendamento_time;
	}

	public boolean isStarted() {
		return started;
	}

	public void setStarted(boolean started) {
		this.started = started;
	}

	public boolean isEnded() {
		return ended;
	}

	public void setEnded(boolean ended) {
		this.ended = ended;
	}

	public String getReason() {
		return razao;
	}

	public void setReason(String razao) {
		this.razao = razao;
	}

	@Override
	public String toString() {
		return "Agendamento [id=" + id + ", agendamento_time=" + agendamento_time + ", started=" + started + ", ended="
				+ ended + ", razao=" + razao + "]";
	}

	public Paciente getPatient() {
		return paciente;
	}

	public void setPatient(Paciente paciente) {
		this.paciente = paciente;
	}

	public Medico getDoctor() {
		return medico;
	}

	public void setDoctor(Medico medico) {
		this.medico = medico;
	}

}
