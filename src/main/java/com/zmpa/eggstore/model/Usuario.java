package com.zmpa.eggstore.model;

public class Usuario {
	private Integer id;
	private String nombre;
	private String username;
	private String mail;
	private String dirección;
	private String telefono;
	private String tipo;
	private String password;
	
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
	
}
