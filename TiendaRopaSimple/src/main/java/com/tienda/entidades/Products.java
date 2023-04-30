package com.tienda.entidades;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "Products")
public class Products implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4581260781007347521L;

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



	public Products() {

	}

	public Products(Long SKU, String prod_name, String description, Integer price, Integer stock, String prod_img) {
		super();
		this.SKU = SKU;
		this.prod_name = prod_name;
		this.description = description;
		this.price = price;
		this.stock = stock;
		this.prod_img = prod_img;
	}

	public Long getSKU() {
		return SKU;
	}

	public void setSKU(Long SKU) {
		this.SKU = SKU;
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

}
