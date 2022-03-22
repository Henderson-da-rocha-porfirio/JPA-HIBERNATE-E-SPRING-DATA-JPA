package com.tuyo.hibernateheranca.entities;

import javax.persistence.*;

@Entity
@Table(name = "cheque")
@PrimaryKeyJoinColumn(name = "id") // Ao usar o strategie JOINED na super-classe, faz-se necessário o uso de PrimaryKeyJoinColumn nas sub-classes.
public class Cheque extends Pagamento {

	private String checknumber;

	public String getChecknumber() {
		return checknumber;
	}

	public void setChecknumber(String checknumber) {
		this.checknumber = checknumber;
	}

}
