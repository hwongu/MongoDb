package net.hwongu.mongodb.core.service.impl;

import net.hwongu.mongodb.core.repository.ProductoRepository;
import net.hwongu.mongodb.core.service.ProductoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("productoService")
public class ProductoServiceImpl implements ProductoService{

	@Autowired
	private ProductoRepository productoRepository;
	
	@Override
	public ProductoRepository getRepository() {
		return productoRepository;
	}

	
}
