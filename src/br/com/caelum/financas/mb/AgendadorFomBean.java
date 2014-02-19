package br.com.caelum.financas.mb;

import javax.enterprise.inject.Model;

@Model
public class AgendadorFomBean {

	private String expressaoMinutos;
	private String expressaoSegundos;
	

	public void agendar() {
		
	}

	public String getExpressaoMinutos() {
		return expressaoMinutos;
	}

	public void setExpressaoMinutos(String expressaoMinutos) {
		this.expressaoMinutos = expressaoMinutos;
	}

	public String getExpressaoSegundos() {
		return expressaoSegundos;
	}

	public void setExpressaoSegundos(String expressaoSegundos) {
		this.expressaoSegundos = expressaoSegundos;
	}

}
