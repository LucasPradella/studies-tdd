package br.com.estudies.tdd.nfe;

import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;

import java.util.Calendar;

import com.google.gson.Gson;

public class NotaFiscal {
	
	private String cliente;
	private double valor;
	private Calendar data;

	
	
	
	
	
	public NotaFiscal(String cliente, double valor, Calendar data) {
		this.cliente = cliente;
		this.valor = valor;
		this.data = data;
	}






	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	
	
	
	
	
	
	
	
	
	

	@Override
	public int hashCode() {		
		return reflectionHashCode(this);
	}



	@Override
	public boolean equals(Object obj) {
		return reflectionEquals(this, obj);
	}


	
	@Override
	public String toString() {
		return new Gson().toJson(this);
	} 
		

}
