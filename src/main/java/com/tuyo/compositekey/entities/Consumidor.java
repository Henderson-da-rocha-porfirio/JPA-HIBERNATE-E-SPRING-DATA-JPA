package com.tuyo.compositekey.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(ConsumidorId.class)                    // 1º Passo para usar o Composite Key ( Chave Composta ). Isso diz o que é a Primary Key.
public class Consumidor {                       // Com a anotação @IdClass, tanto o Hibernate quanto o Spring JPA sabem que essa classe ConsumidorId é a Composite Key para essa Entitidade em particular.

    @Id
    private int id;
    @Id                                         // Com Composite Key, ambos atributos devem ser anotados com @Id
    private String email;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
