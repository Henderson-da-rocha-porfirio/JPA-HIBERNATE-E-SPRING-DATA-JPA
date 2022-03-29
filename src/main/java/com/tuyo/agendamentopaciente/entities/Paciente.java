package com.tuyo.agendamentopaciente.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Paciente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Anotação utilizada quando o tipo é de auto-incremento no database.
	private Long id;
	private String firstName;
	private String lastName;
	private String phone;
	@Embedded		// Precisamos marcar o objeto em Paciente com @Embedded ( incorporado ). Incorporado dentro de Paciente, uma vez que em SeguroSaude estamos incorporando: Embeddable
	private SeguroSaude seguroSaude; 	// Isso facilita porque qualquer operação de salvar ou rollback que for dado em Paciente, SeguroSaude também responderá da mesma forma pela incorporação nele.

	@ManyToMany(fetch = FetchType.EAGER)	//Usa-se Fetch porque os médicos serão buscados de maneira lazy. Lazy Loading na associação.
	@JoinTable(name = "pacientes_medicos", joinColumns = @JoinColumn(name = "paciente_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "medico_id", referencedColumnName = "id")) // Referência ao Join.
	private List<Medico> medicos;	// Devido ao relacionamento ManyToMany com Medico, precisamos dessa listagem aqui.

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

	public SeguroSaude getInsurance() {
		return seguroSaude;
	}

	public void setInsurance(SeguroSaude seguroSaude) {
		this.seguroSaude = seguroSaude;
	}

	@Override
	public String toString() {
		return "Paciente [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", phone=" + phone
				+ ", seguroSaude=" + seguroSaude + "]";
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
