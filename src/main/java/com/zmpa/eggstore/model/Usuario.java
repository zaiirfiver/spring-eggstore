package com.zmpa.eggstore.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity														//
@Table(name = "usuarios")									//Indica que es una tabla
public class Usuario {
	@Id														//Autoincrementa los datos ingresados
	@GeneratedValue(strategy = GenerationType.IDENTITY)		//Hace que el campo sea autoincrementable
	private Integer id;
	private String nombre;
	private String username;
	private String mail;
	private String dirección;
	private String telefono;
	private String tipo;
	private String password;
	
	@OneToMany(mappedBy = "usuario")
	private List<Producto> productos;						//Obtener la lista de productos
	
	@OneToMany(mappedBy = "usuario")						//Obtener la lista de ordenes
	private List<Orden> ordenes;
	
	
	public Usuario() {
		
	}
	
	public Usuario(Integer id, String nombre, String username, String mail, String dirección, String telefono,
			String tipo, String password) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.username = username;
		this.mail = mail;
		this.dirección = dirección;
		this.telefono = telefono;
		this.tipo = tipo;
		this.password = password;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getDirección() {
		return dirección;
	}
	public void setDirección(String dirección) {
		this.dirección = dirección;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", username=" + username + ", mail=" + mail + ", dirección="
				+ dirección + ", telefono=" + telefono + ", tipo=" + tipo + ", password=" + password + "]";
	}
	
	
	
}
