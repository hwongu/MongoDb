package net.hwongu.mongodb.web.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import net.hwongu.mongodb.core.model.Categoria;
import net.hwongu.mongodb.core.service.CategoriaService;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.google.common.collect.Lists;

@ManagedBean
@SessionScoped
public class CategoriaController implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Categoria categoria;
	private List<Categoria> listaCategorias;
	@ManagedProperty(value="#{categoriaService}")
    private CategoriaService categoriaService;
	
	public CategoriaController() {
		
	}
	
	@PostConstruct
	public void inicializar(){
		this.categoria = new Categoria();
		this.listaCategorias = new ArrayList<Categoria>();
		this.listar();
	}
	
	public void guardar(){
		try{
			categoriaService.getCategoriaDao().save(categoria);
			this.categoria = new Categoria();
			this.listar();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void listar(){
		try{
			 
			this.listaCategorias = Lists.newArrayList(this.categoriaService.getCategoriaDao().findAll());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	public Categoria getCategoria() {
		return categoria;
	}
	
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public List<Categoria> getListaCategorias() {
		return listaCategorias;
	}
	
	public void setListaCategorias(List<Categoria> listaCategorias) {
		this.listaCategorias = listaCategorias;
	}
	
	public CategoriaService getCategoriaService() {
		return categoriaService;
	}
	
	public void setCategoriaService(CategoriaService categoriaService) {
		this.categoriaService = categoriaService;
	}

}
