package com.tienda.dtos;

import java.io.Serializable;
import java.util.Date;

public class OrdersDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2457537840768695018L;

	private Long id;
		
	private Date fecha;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	
	
}
