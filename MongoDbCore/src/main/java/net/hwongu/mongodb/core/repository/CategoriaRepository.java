package net.hwongu.mongodb.core.repository;

import java.math.BigInteger;

import net.hwongu.mongodb.core.model.Categoria;
import net.hwongu.mongodb.core.repository.custom.CategoriaRepositoryCustom;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Las clases tienen que tener el formato de XxxxxRepository para que Spring data lo reconozca
 * @author Henry Joe Wong Urquiza
 * @mail hwongu@gmail.com
 */
@Repository
public interface CategoriaRepository extends
		MongoRepository<Categoria, BigInteger>, CategoriaRepositoryCustom {

}
