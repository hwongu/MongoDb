package net.hwongu.mongodb.test;

import net.hwongu.mongodb.core.service.ProductoService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 
 * @author Henry Joe Wong Urquiza
 * @mail hwongu@gmail.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/java//net/hwongu/mongodb/configuration/SpringContext.xml" })
public class ProductoTest {

	@Autowired
	private ProductoService productoDaoRepository;

	@Test
	public void prueba() {
		productoDaoRepository.getRepository().metodoPersonalizado();
	}

}
