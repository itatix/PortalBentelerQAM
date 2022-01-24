package com.wise.model;

public class MenusDto {
	
	Boolean listFac;
	Boolean ocCFDIC;
	Boolean ocCFDIV;
	Boolean ocCFDIVP;
	Boolean ocCBBC;
	Boolean ocCBBV;
	Boolean ocCBBVP;
	Boolean socCFDI;
	Boolean socCBB;
	Boolean estatusRecepcion;
	Boolean listaOC;
	Boolean buzonAgregar;
	Boolean buzonConsultar;
	Boolean estadoCuenta;
	Boolean division;
	Boolean password;
	Boolean avisos;
	Boolean ocCFDICI;
	Boolean ocCBBCI;
	Boolean opdf;
	Boolean buzonAgregarCFDI;
	Boolean buzonAgregarSCFDI;
	Boolean consignacion;
	Boolean socCFDIAgencias;
	Boolean socCFDIFletes;
	Boolean socCBBAgencias;
	Boolean socCBBFletes;
	
	public Boolean getListFac() {
		return listFac;
	}
	public void setListFac(Boolean listFac) {
		this.listFac = listFac;
	}
	public Boolean getOcCFDIC() {
		return ocCFDIC;
	}
	public void setOcCFDIC(Boolean ocCFDIC) {
		this.ocCFDIC = ocCFDIC;
	}
	public Boolean getOcCFDIV() {
		return ocCFDIV;
	}
	public void setOcCFDIV(Boolean ocCFDIV) {
		this.ocCFDIV = ocCFDIV;
	}
	public Boolean getOcCFDIVP() {
		return ocCFDIVP;
	}
	public void setOcCFDIVP(Boolean ocCFDIVP) {
		this.ocCFDIVP = ocCFDIVP;
	}
	public Boolean getOcCBBC() {
		return ocCBBC;
	}
	public void setOcCBBC(Boolean ocCBBC) {
		this.ocCBBC = ocCBBC;
	}
	public Boolean getOcCBBV() {
		return ocCBBV;
	}
	public void setOcCBBV(Boolean ocCBBV) {
		this.ocCBBV = ocCBBV;
	}
	public Boolean getOcCBBVP() {
		return ocCBBVP;
	}
	public void setOcCBBVP(Boolean ocCBBVP) {
		this.ocCBBVP = ocCBBVP;
	}
	public Boolean getSocCFDI() {
		return socCFDI;
	}
	public void setSocCFDI(Boolean socCFDI) {
		this.socCFDI = socCFDI;
	}
	public Boolean getSocCBB() {
		return socCBB;
	}
	public void setSocCBB(Boolean socCBB) {
		this.socCBB = socCBB;
	}
	public Boolean getEstatusRecepcion() {
		return estatusRecepcion;
	}
	public void setEstatusRecepcion(Boolean estatusRecepcion) {
		this.estatusRecepcion = estatusRecepcion;
	}
	public Boolean getListaOC() {
		return listaOC;
	}
	public void setListaOC(Boolean listaOC) {
		this.listaOC = listaOC;
	}
	public Boolean getBuzonAgregar() {
		return buzonAgregar;
	}
	public void setBuzonAgregar(Boolean buzonAgregar) {
		this.buzonAgregar = buzonAgregar;
	}
	public Boolean getBuzonConsultar() {
		return buzonConsultar;
	}
	public void setBuzonConsultar(Boolean buzonConsultar) {
		this.buzonConsultar = buzonConsultar;
	}
	
	public Boolean isOC() {
		return (this.ocCBBC || this.ocCBBV || this.ocCBBVP || this.ocCFDIC || this.ocCFDIV || this.ocCFDIVP || this.ocCFDICI || this.ocCBBCI);
	}
	
	public Boolean isSOC() {
		return (this.socCBB || this.socCFDI || this.socCFDIAgencias || this.socCFDIFletes || this.socCBBAgencias || this.socCBBFletes);
	}
	
	public Boolean isOCCFDI() {
		return (this.ocCFDIC || this.ocCFDIV || this.ocCFDIVP);
	}
	
	public Boolean isOCCBB() {
		return (this.ocCBBC || this.ocCBBV || this.ocCBBVP);
	}
	
	public Boolean isInbox() {
		return (this.buzonAgregarCFDI || this.buzonAgregarSCFDI);
	}
	public Boolean getEstadoCuenta() {
		return estadoCuenta;
	}
	public void setEstadoCuenta(Boolean estadoCuenta) {
		this.estadoCuenta = estadoCuenta;
	}
	public Boolean getDivision() {
		return division;
	}
	public void setDivision(Boolean division) {
		this.division = division;
	}
	public Boolean getPassword() {
		return password;
	}
	public void setPassword(Boolean password) {
		this.password = password;
	}
	public Boolean getAvisos() {
		return avisos;
	}
	public void setAvisos(Boolean avisos) {
		this.avisos = avisos;
	}
	public Boolean getOcCFDICI() {
		return ocCFDICI;
	}
	public void setOcCFDICI(Boolean ocCFDICI) {
		this.ocCFDICI = ocCFDICI;
	}
	public Boolean getOcCBBCI() {
		return ocCBBCI;
	}
	public void setOcCBBCI(Boolean ocCBBCI) {
		this.ocCBBCI = ocCBBCI;
	}
	public Boolean getOpdf() {
		return opdf;
	}
	public void setOpdf(Boolean opdf) {
		this.opdf = opdf;
	}
	public Boolean getBuzonAgregarCFDI() {
		return buzonAgregarCFDI;
	}
	public void setBuzonAgregarCFDI(Boolean buzonAgregarCFDI) {
		this.buzonAgregarCFDI = buzonAgregarCFDI;
	}
	public Boolean getBuzonAgregarSCFDI() {
		return buzonAgregarSCFDI;
	}
	public void setBuzonAgregarSCFDI(Boolean buzonAgregarSCFDI) {
		this.buzonAgregarSCFDI = buzonAgregarSCFDI;
	}
	public Boolean getConsignacion() {
		return consignacion;
	}
	public void setConsignacion(Boolean consignacion) {
		this.consignacion = consignacion;
	}
	public Boolean getSocCFDIAgencias() {
		return socCFDIAgencias;
	}
	public void setSocCFDIAgencias(Boolean socCFDIAgencias) {
		this.socCFDIAgencias = socCFDIAgencias;
	}
	public Boolean getSocCFDIFletes() {
		return socCFDIFletes;
	}
	public void setSocCFDIFletes(Boolean socCFDIFletes) {
		this.socCFDIFletes = socCFDIFletes;
	}
	public Boolean getSocCBBAgencias() {
		return socCBBAgencias;
	}
	public void setSocCBBAgencias(Boolean socCBBAgencias) {
		this.socCBBAgencias = socCBBAgencias;
	}
	public Boolean getSocCBBFletes() {
		return socCBBFletes;
	}
	public void setSocCBBFletes(Boolean socCBBFletes) {
		this.socCBBFletes = socCBBFletes;
	}

}
