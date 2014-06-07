package net.hwongu.mongodb.web.controller;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import net.hwongu.mongodb.core.model.Categoria;
import net.hwongu.mongodb.core.model.Producto;
import net.hwongu.mongodb.core.service.CategoriaService;
import net.hwongu.mongodb.core.service.ProductoService;

import com.google.common.collect.Lists;

/**
 * 
 * @author Henry Joe Wong Urquiza
 * @mail hwongu@hwongu.net
 */
@ManagedBean
@SessionScoped
public class ProductoController implements Serializable {

	private static final long serialVersionUID = 1L;
	private Producto producto;
	private Producto productoSeleccionado;
	private List<Producto> listaProductos;
	private List<SelectItem> itemsCategorias;
	private BigInteger idCategoria;
	@ManagedProperty(value = "#{productoService}")
	private ProductoService productoService;
	@ManagedProperty(value = "#{categoriaService}")
	private CategoriaService categoriaService;

	public ProductoController() {
		this.producto = new Producto();
		this.productoSeleccionado = new Producto();
		this.listaProductos = new ArrayList<Producto>();
		this.itemsCategorias = new ArrayList<SelectItem>();
		this.idCategoria = new BigInteger("0");
	}

	@PostConstruct
	public void postConstructor() {
		this.listarCategorias();
		this.listarProductos();
	}

	private void listarProductos() {
		try {
			this.listaProductos = new ArrayList<Producto>();
			this.listaProductos = Lists.newArrayList(this.productoService
					.getRepository().findAll());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void listarCategorias() {
		List<Categoria> listaCategorias = Lists
				.newArrayList(this.categoriaService.getRepository().findAll());
		this.itemsCategorias = new ArrayList<SelectItem>();
		for (Categoria c : listaCategorias) {
			this.itemsCategorias.add(new SelectItem(c.getId(), c.getNombre()));
		}
	}

	public void guardar() {
		try {
			this.producto.setCategoria(categoriaService.getRepository()
					.findOne(this.idCategoria));
			this.productoService.getRepository().save(this.producto);
			this.producto = new Producto();
			this.listarProductos();
			this.enviarMensaje("Se registro satisfactoriamente");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void eliminar() {
		try {
			this.productoService.getRepository().delete(
					this.productoSeleccionado);
			this.listarProductos();
			this.productoSeleccionado = new Producto();
			this.enviarMensaje("Se elimino satisfactoriamente");
		} catch (Exception e) {
			e.printStackTrace();
		}
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

	public BigInteger getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(BigInteger idCategoria) {
		this.idCategoria = idCategoria;
	}

	public List<SelectItem> getItemsCategorias() {
		return itemsCategorias;
	}

	public void setItemsCategorias(List<SelectItem> itemsCategorias) {
		this.itemsCategorias = itemsCategorias;
	}

	public CategoriaService getCategoriaService() {
		return categoriaService;
	}

	public void setCategoriaService(CategoriaService categoriaService) {
		this.categoriaService = categoriaService;
	}

	public ProductoService getProductoService() {
		return productoService;
	}

	public void setProductoService(ProductoService productoService) {
		this.productoService = productoService;
	}

	public Producto getProductoSeleccionado() {
		return productoSeleccionado;
	}

	public void setProductoSeleccionado(Producto productoSeleccionado) {
		this.productoSeleccionado = productoSeleccionado;
	}

	public void enviarMensaje(String mensaje) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Información", mensaje));

	}

}
