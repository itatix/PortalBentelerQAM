package com.wise.model;

public class UnidadTipoDto {
	private String trans;
	private String clave;
	private String texto;
	public UnidadTipoDto(String trans, String clave, String texto) {
		this.trans = trans;
		this.clave = clave;
		this.texto = texto;
	}
	public String getTrans() {
		return trans;
	}
	public void setTrans(String trans) {
		this.trans = trans;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
}
