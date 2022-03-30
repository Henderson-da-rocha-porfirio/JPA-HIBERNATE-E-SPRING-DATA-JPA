package com.tuyo.compositekey.repository;

import com.tuyo.compositekey.entities.Consumidor;
import com.tuyo.compositekey.entities.ConsumidorId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsumidorRepo extends JpaRepository<Consumidor, ConsumidorId> { // Poderia utilizar CrudRepository. Na verdade, dependerá muito dos métodos que precisa e das coleções envolvidas.
                                                                                    // Aqui é passado em <T, ID> = T: type: Classe Tipo para justificar a Interface:Consumidor e como se trata de uma composite, passar em id:ConsumidorId
}
