package com.tuyo.hibernateheranca.entities;

import com.tuyo.hibernateheranca.entities.Pagamento;

import javax.persistence.*;

@Entity
@DiscriminatorValue("ch")
/*@Table(name = "bankcheck")
@PrimaryKeyJoinColumn(name = "id")*/
public class Cheque extends Pagamento {

	private String checknumber;

	public String getChecknumber() {
		return checknumber;
	}

	public void setChecknumber(String checknumber) {
		this.checknumber = checknumber;
	}

}
