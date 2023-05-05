package com.tienda.dtos;

import java.io.Serializable;

public class ProductsDTO implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -4612596270686553602L;

	private Long SKU;

	private String prod_name;

	private String description;

	private Integer price;

	private Integer stock;

	private String prod_img;

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
	
   

}


