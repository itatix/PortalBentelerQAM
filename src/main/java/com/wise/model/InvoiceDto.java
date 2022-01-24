package com.wise.model;

import org.springframework.web.multipart.MultipartFile;

public class InvoiceDto {
	
	private String hdnRazonSocial;
	private String lifnr;
	private MultipartFile[] files;
	
	
	public String getLifnr() {
		return lifnr;
	}
	public void setLifnr(String lifnr) {
		this.lifnr = lifnr;
	}
	public MultipartFile[] getFiles() {
		return files;
	}
	public void setFiles(MultipartFile[] files) {
		this.files = files;
	}
	public String getHdnRazonSocial() {
		return hdnRazonSocial;
	}
	public void setHdnRazonSocial(String hdnRazonSocial) {
		this.hdnRazonSocial = hdnRazonSocial;
	}

}
