package com.tuyo.agendamentopaciente.entities;

import javax.persistence.Embeddable;

@Embeddable		// Aqui usamos Embeddable ( incorporador ) SeguroSaude dentro de Paciente. Esse tem dentro de si, o SeguroSaude. Precisamos marcar o objeto em Paciente com @Embedded ( incorporado )
public class SeguroSaude {
	
	private String providerName;
	private double copay; 		// co-pay(mesmo que co-participação em plano de saúde no Brasil): pagamento ao médico toda vez que o paciente vai ao médico. "Double" = no banco está decimal.

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public double getCopay() {
		return copay;
	}

	public void setCopay(double copay) {
		this.copay = copay;
	}

	@Override
	public String toString() {
		return "SeguroSaude [providerName=" + providerName + ", copay=" + copay + "]";
	}
	

}
