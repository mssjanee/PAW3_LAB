package com.jsfcourse.calc;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class KredytBB {
	private Double kwota;
	private Integer liczba_lat;
	private Double proc;
	private Double result;

	@Inject
	FacesContext ctx;
	
	

	public Double getKwota() {
		return kwota;
	}

	public void setKwota(Double kwota) {
		this.kwota = kwota;
	}

	public Integer getLiczba_lat() {
		return liczba_lat;
	}

	public void setLiczba_lat(Integer liczba_lat) {
		this.liczba_lat = liczba_lat;
	}

	public Double getProc() {
		return proc;
	}

	public void setProc(Double proc) {
		this.proc = proc;
	}

	public Double getResult() {
		return result;
	}

	public void setResult(Double result) {
		this.result = result;
	}

	public String calc() {
		try {
			result = (((proc/100) * kwota * liczba_lat) + kwota)/(liczba_lat * 12);
			
			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operacja wykonana poprawnie", null));
			return "showresult"; 
		} catch (Exception e) {
			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Blad podczas przetwarzania parametrow", null));
			return null; 
		}
				
	}

	public String info() {
		return "info"; 
	}
}
