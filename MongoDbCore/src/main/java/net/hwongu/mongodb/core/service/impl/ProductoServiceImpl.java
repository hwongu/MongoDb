package net.hwongu.mongodb.core.service.impl;

import java.io.Serializable;

import net.hwongu.mongodb.core.repository.ProductoRepository;
import net.hwongu.mongodb.core.service.ProductoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("productoService")
public class ProductoServiceImpl implements ProductoService, Serializable{

	private static final long serialVersionUID = 1L;
	@Autowired
	private ProductoRepository productoRepository;
	
	@Override
	public ProductoRepository getRepository() {
		return productoRepository;
	}

	
}
