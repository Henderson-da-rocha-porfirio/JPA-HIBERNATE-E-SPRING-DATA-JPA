package com.tuyo.hibernateheranca.entities;

import javax.persistence.*;

@Entity
@Table(name="cartao")
@PrimaryKeyJoinColumn(name="id") // Ao usar o strategie JOINED na super-classe, faz-se necessário o uso de PrimaryKeyJoinColumn nas sub-classes.
public class CartaoCredito extends Pagamento {

	private String cardnumber;

	public String getCardnumber() {
		return cardnumber;
	}

	public void setCardnumber(String cardnumber) {
		this.cardnumber = cardnumber;
	}



}
