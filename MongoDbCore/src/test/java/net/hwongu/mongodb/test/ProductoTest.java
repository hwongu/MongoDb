package net.hwongu.mongodb.test;

import net.hwongu.mongodb.core.model.Categoria;
import net.hwongu.mongodb.core.model.Producto;
import net.hwongu.mongodb.core.service.CategoriaService;
import net.hwongu.mongodb.core.service.ProductoService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 
 * @author Henry Joe Wong Urquiza
 * @mail hwongu@hwongu.net
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/java//net/hwongu/mongodb/configuration/SpringContext.xml" })
public class ProductoTest {

	@Autowired
	private ProductoService productoDaoRepository;
	@Autowired
	private CategoriaService categoriaService;

	@Test
	public void prueba() {
		Categoria c = categoriaService.getRepository().findByNombre("GASEOSA").get(0);
		Producto p = new Producto();
		p.setNombre("COCA COLA");
		p.setPrecio(1.5D);
		p.setCategoria(c);
		//productoDaoRepository.getRepository().save(p);
		productoDaoRepository.getRepository().metodoPersonalizado();
	}

}
