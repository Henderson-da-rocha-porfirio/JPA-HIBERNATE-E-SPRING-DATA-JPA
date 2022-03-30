package com.tuyo.compositekey.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Consumidor {

    @EmbeddedId                         // Ele Embeddable (incorpora) os campos id e email da Classe Composite: ConsumidorId
    private ConsumidorId id;            // substitui id e email
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ConsumidorId getId() {
        return id;
    }

    public void setId(ConsumidorId id) {
        this.id = id;
    }
}
