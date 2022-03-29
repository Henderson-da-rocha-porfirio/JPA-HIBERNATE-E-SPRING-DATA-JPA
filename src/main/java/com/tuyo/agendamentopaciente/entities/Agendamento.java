package com.tuyo.agendamentopaciente.entities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Agendamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Timestamp appointmentTime;
	private boolean started;
	private boolean ended;
	private String reason;

	@ManyToOne
	@JoinColumn(name = "patient_id")
	private Paciente paciente;

	@ManyToOne
	@JoinColumn(name = "doctor_id")
	private Medico medico;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getAppointmentTime() {
		return appointmentTime;
	}

	public void setAppointmentTime(Timestamp appointmentTime) {
		this.appointmentTime = appointmentTime;
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
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@Override
	public String toString() {
		return "Agendamento [id=" + id + ", appointmentTime=" + appointmentTime + ", started=" + started + ", ended="
				+ ended + ", reason=" + reason + "]";
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
