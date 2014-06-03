/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.hwongu.mongodb.web.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.google.common.collect.Lists;

import net.hwongu.mongodb.core.model.Categoria;
import net.hwongu.mongodb.core.model.Producto;
import net.hwongu.mongodb.core.service.ProductoService;

/**
 *
 * @author HWONGU
 */
@ManagedBean
@SessionScoped
public class ProductoController implements Serializable{
    
	private static final long serialVersionUID = 1L;
	private Producto producto;
	private List<Producto> listaProductos;
	private List<Categoria> listaCategorias;
	@ManagedProperty(value="#{productoService}")
    private ProductoService productoService;
    
   
	public ProductoController() {
		this.producto = new Producto();
		this.listaProductos = new ArrayList<Producto>();
		
	}
    
	@PostConstruct
	public void listar(){
		try{
			this.listaProductos = Lists.newArrayList(this.getProductoService().getRepository().findAll());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
    public void guardar(){
        try{
            productoService.getRepository().save(producto);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public List<Categoria> getListaCategorias() {
		return listaCategorias;
	}
    
    public void setListaCategorias(List<Categoria> listaCategorias) {
		this.listaCategorias = listaCategorias;
	}
    
    public List<Producto> getListaProductos() {
		return listaProductos;
	}
    
    public void setListaProductos(List<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}
    
    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public ProductoService getProductoService() {
        return productoService;
    }

    public void setProductoService(ProductoService productoService) {
        this.productoService = productoService;
    }
    
    
    
}
