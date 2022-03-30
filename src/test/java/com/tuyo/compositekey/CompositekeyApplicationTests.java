package com.tuyo.compositekey;

import com.tuyo.compositekey.entities.Consumidor;
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
		consumidor.setId(12345);
		consumidor.setEmail("teste@teste.com");
		consumidor.setName("teste");
		repo.save(consumidor);
	}

}
