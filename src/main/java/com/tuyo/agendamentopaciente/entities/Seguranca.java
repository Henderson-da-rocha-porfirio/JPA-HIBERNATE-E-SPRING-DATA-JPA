package com.tuyo.agendamentopaciente.entities;

import javax.persistence.Embeddable;

@Embeddable
public class Seguranca {
	
	private String providerName;
	private double copay;

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
		return "Seguranca [providerName=" + providerName + ", copay=" + copay + "]";
	}
	

}
