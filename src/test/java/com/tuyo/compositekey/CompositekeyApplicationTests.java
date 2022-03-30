package com.tuyo.compositekey;

import com.tuyo.compositekey.entities.Consumidor;
import com.tuyo.compositekey.entities.ConsumidorId;
import com.tuyo.compositekey.repository.ConsumidorRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CompositekeyApplicationTests {

	@Autowired
	ConsumidorRepo repo;

	@Test
	void testSaveConsumidor() {
		Consumidor consumidor = new Consumidor();
		ConsumidorId id = new ConsumidorId();
		id.setId(6789);
		id.setEmail("teste@teste.com");
		consumidor.setId(id);
		consumidor.setName("teste");
		repo.save(consumidor);
	}

}
