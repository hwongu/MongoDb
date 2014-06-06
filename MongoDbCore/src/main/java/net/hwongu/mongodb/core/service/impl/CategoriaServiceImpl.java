package net.hwongu.mongodb.core.service.impl;

import java.io.Serializable;

import net.hwongu.mongodb.core.repository.CategoriaRepository;
import net.hwongu.mongodb.core.service.CategoriaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("categoriaService")
public class CategoriaServiceImpl implements CategoriaService, Serializable{

	private static final long serialVersionUID = 1L;
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Override
	public CategoriaRepository getRepository() {
		return categoriaRepository;
	}
	
}
