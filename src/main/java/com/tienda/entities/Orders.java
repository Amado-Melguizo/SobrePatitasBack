package com.tienda.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

	
@Entity
@Table(name = "orders")
public class Orders implements Serializable{

	    /**
	 * 
	 */
	private static final long serialVersionUID = -7363931586377032575L;

		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
	    private Long id;

		@Column(name = "fecha")
		@Temporal(TemporalType.DATE)
		private Date fecha;

	    @ManyToOne
	    @JoinColumn(name = "nombre_usuario")
	    private Users pedidos_usuarios;
	    
		@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	    private List<Products> productos;
		
		

		@PrePersist
		public void fecha() {
			fecha = new Date();
			System.out.println(fecha);
		}
		
		public Orders() {
			
		}

		public Orders(Long id, Users pedidos_usuarios, List<Products> productos) {
			super();
			this.id = id;
			this.pedidos_usuarios = pedidos_usuarios;
			this.productos = productos;
		}

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

		public Users getPedidos_usuarios() {
			return pedidos_usuarios;
		}

		public void setPedidos_usuarios(Users pedidos_usuarios) {
			this.pedidos_usuarios = pedidos_usuarios;
		}

		public List<Products> getProductos() {
			return productos;
		}

		public void setProductos(List<Products> productos) {
			this.productos = productos;
		}
		
	
			    
	}

