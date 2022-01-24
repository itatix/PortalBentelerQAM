package com.wise.model;

import java.util.Arrays;

import org.springframework.web.multipart.MultipartFile;

public class FreightDto {
	
	private String bukrs;
	private String concepto;
	private MultipartFile[] file;
	private String origen;
	private String destino;
	private String refer;
	private String noRefer;
	private String fechaEmbarque;
	private String tipoSer;
	private String uniTipo;
	private String noRemision;
	private String observacion;
	private String tipoFac;
	private String tipoTrans;
	private String tickets;
	private String currency;
	private String invoiceDate;
	private String totalInvoice;
	public String getBukrs() {
		return bukrs;
	}
	public void setBukrs(String bukrs) {
		this.bukrs = bukrs;
	}
	public String getConcepto() {
		return concepto;
	}
	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
	public MultipartFile[] getFile() {
		return file;
	}
	public void setFile(MultipartFile[] file) {
		this.file = file;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public String getRefer() {
		return refer;
	}
	public void setRefer(String refer) {
		this.refer = refer;
	}
	public String getNoRefer() {
		return noRefer;
	}
	public void setNoRefer(String noRefer) {
		this.noRefer = noRefer;
	}
	public String getFechaEmbarque() {
		return fechaEmbarque;
	}
	public void setFechaEmbarque(String fechaEmbarque) {
		this.fechaEmbarque = fechaEmbarque;
	}
	public String getTipoSer() {
		return tipoSer;
	}
	public void setTipoSer(String tipoSer) {
		this.tipoSer = tipoSer;
	}
	public String getUniTipo() {
		return uniTipo;
	}
	public void setUniTipo(String uniTipo) {
		this.uniTipo = uniTipo;
	}
	public String getNoRemision() {
		return noRemision;
	}
	public void setNoRemision(String noRemision) {
		this.noRemision = noRemision;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	public String getTipoFac() {
		return tipoFac;
	}
	public void setTipoFac(String tipoFac) {
		this.tipoFac = tipoFac;
	}
	public String getTickets() {
		return tickets;
	}
	public void setTickets(String tickets) {
		this.tickets = tickets;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getInvoiceDate() {
		return invoiceDate;
	}
	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	public String getTotalInvoice() {
		return totalInvoice;
	}
	public void setTotalInvoice(String totalInvoice) {
		this.totalInvoice = totalInvoice;
	}
	public String getTipoTrans() {
		return tipoTrans;
	}
	public void setTipoTrans(String tipoTrans) {
		this.tipoTrans = tipoTrans;
	}
	@Override
	public String toString() {
		return "FreightDto [bukrs=" + bukrs + ", concepto=" + concepto
				+ ", file=" + Arrays.toString(file) + ", origen=" + origen
				+ ", destino=" + destino + ", refer=" + refer + ", noRefer="
				+ noRefer + ", fechaEmbarque=" + fechaEmbarque + ", tipoSer="
				+ tipoSer + ", uniTipo=" + uniTipo + ", noRemision="
				+ noRemision + ", observacion=" + observacion + ", tipoFac="
				+ tipoFac + ", tipoTrans=" + tipoTrans + ", tickets=" + tickets
				+ ", currency=" + currency + ", invoiceDate=" + invoiceDate
				+ ", totalInvoice=" + totalInvoice + "]";
	}

}
