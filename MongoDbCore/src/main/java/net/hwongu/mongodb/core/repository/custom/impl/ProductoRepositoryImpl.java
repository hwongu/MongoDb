package net.hwongu.mongodb.core.repository.custom.impl;

import java.io.Serializable;
import java.util.List;

import net.hwongu.mongodb.core.model.Producto;
import net.hwongu.mongodb.core.repository.custom.ProductoRepositoryCustom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.google.common.collect.Lists;

/**
 * Las clases tienen que tener el formato de XxxxxRepositoryCustomImpl para que Spring Data lo reconozca
 * @author Henry Joe Wong Urquiza
 * @mail hwongu@hwongu.net
 */
public class ProductoRepositoryImpl implements ProductoRepositoryCustom, Serializable {

	private static final long serialVersionUID = 1L;
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public void metodoPersonalizado() {
		List<Producto> productos =  Lists.newArrayList(mongoTemplate.findAll(Producto.class));
		for(Producto p : productos){
			System.out.println("_id: " + p.getId());
			System.out.println("_nombre: " + p.getNombre());
			System.out.println("========================================================");
		}
	}

}
