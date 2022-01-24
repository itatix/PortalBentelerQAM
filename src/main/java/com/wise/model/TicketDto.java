package com.wise.model;

public class TicketDto {

	public TicketDto(String fecha, String ticket, String lifnr) {
		this.fecha = fecha;
		this.ticket = ticket;
		this.lifnr = lifnr;
	}
	private String fecha;
	private String ticket;
	private String lifnr;
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	public String getLifnr() {
		return lifnr;
	}
	public void setLifnr(String lifnr) {
		this.lifnr = lifnr;
	}
	
}
