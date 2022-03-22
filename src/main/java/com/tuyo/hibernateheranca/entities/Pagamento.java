package com.tuyo.hibernateheranca.entities;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED) 		// Exemplo com JOINED = strategy em que os campos são específicos a sub-classes
public abstract class Pagamento { 						// que são mapeadas para uma tabela separada onde os campos são comuns a classe pai, e um "join" é realizado para instanciar a uma subclasse
														// abstract porque não será utilizado diretamente este Pagamento. É uma classe genérica.
														// os campos das entidades Pai são alojados na tabela pai e as os campos das entidades filhas são alojados na tabela-filha
														// e esse usa um " join " para acessar todos os deles e então por isso usar o JOINED.
														// Ao usar o strategie JOINED na super-classe, faz-se necessário o uso de @PrimaryKeyJoinColumn(name = "id") nas sub-classes.

	@Id
	private int id;
	private double amount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
