package com.tienda.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Products implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -5880470536188121963L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SKU")
	private Long SKU;

	@Column(name = "prod_name")
	private String prod_name;

	@Column(name = "description")
	private String description;

	@Column(name = "price")
	private Integer price;

	@Column(name = "stock")
	private Integer stock;

	@Column(name = "prod_img")
	private String prod_img;
    
    @ManyToOne
    @JoinColumn(name = "nombre_usuario")
    private Users productos_usuarios;
    
    @ManyToOne
    @JoinColumn(name = "nombre_pedido")
    private Users pedidos_usuarios;
    
    public Products() {
    	
    }

	public Long getSKU() {
		return SKU;
	}

	public void setSKU(Long sKU) {
		SKU = sKU;
	}

	public String getProd_name() {
		return prod_name;
	}

	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getProd_img() {
		return prod_img;
	}

	public void setProd_img(String prod_img) {
		this.prod_img = prod_img;
	}

	public Users getProductos_usuarios() {
		return productos_usuarios;
	}

	public void setProductos_usuarios(Users productos_usuarios) {
		this.productos_usuarios = productos_usuarios;
	}

	public Users getPedidos_usuarios() {
		return pedidos_usuarios;
	}

	public void setPedidos_usuarios(Users pedidos_usuarios) {
		this.pedidos_usuarios = pedidos_usuarios;
	}

	

}

