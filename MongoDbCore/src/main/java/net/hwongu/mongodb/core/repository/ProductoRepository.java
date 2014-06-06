package net.hwongu.mongodb.core.repository;

import java.math.BigInteger;

import net.hwongu.mongodb.core.model.Producto;
import net.hwongu.mongodb.core.repository.custom.ProductoRepositoryCustom;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Las clases tienen que tener el formato de XxxxxRepository para que Spring data lo reconozca
 * @author Henry Joe Wong Urquiza
 * @mail hwongu@hwongu.net
 */
@Repository
public interface ProductoRepository extends
		MongoRepository<Producto, BigInteger>, ProductoRepositoryCustom {

}
