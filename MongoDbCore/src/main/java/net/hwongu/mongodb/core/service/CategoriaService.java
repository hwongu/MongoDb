package net.hwongu.mongodb.core.service;

import java.io.Serializable;

import net.hwongu.mongodb.core.repository.CategoriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
 * @author Henry Joe Wong Urquiza
 * @mail hwongu@gmail.com
 */

@Component
public class CategoriaService implements Serializable {

	private static final long serialVersionUID = 1L;
	@Autowired
	private CategoriaRepository categoriaDao;

	public CategoriaRepository getCategoriaDao() {
		return categoriaDao;
	}

	public void setCategoriaDao(CategoriaRepository categoriaDao) {
		this.categoriaDao = categoriaDao;
	}

}
