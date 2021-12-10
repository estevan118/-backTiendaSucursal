package co.edu.lagenerica.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("consolidado")
public class Consolidado {
	
	private String ciudad;
	private String valor_total_ventas;
	
	
	public Consolidado(String ciudad, String valor_total_ventas) {
		super();
		this.ciudad = ciudad;
		this.valor_total_ventas = valor_total_ventas;
	}


	public String getCiudad() {
		return ciudad;
	}


	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}


	public String getValortotalventas() {
		return valor_total_ventas;
	}


	public void setValortotalventas(String valor_total_ventas) {
		this.valor_total_ventas = valor_total_ventas;
	}
	
	
	
	
}