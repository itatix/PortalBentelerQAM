package com.wise.model;

public class ServiceType {
	private String type;
	private String clave;
	private String spras;
	private String texto;
	
	public ServiceType(String type, String clave, String spras, String texto) {
		this.type = type;
		this.clave = clave;
		this.spras = spras;
		this.texto = texto;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getSpras() {
		return spras;
	}
	public void setSpras(String spras) {
		this.spras = spras;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
}
