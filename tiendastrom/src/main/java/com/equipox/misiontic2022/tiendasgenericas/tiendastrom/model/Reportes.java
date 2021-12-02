package com.equipox.misiontic2022.tiendasgenericas.tiendastrom.model;

import java.util.ArrayList;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ventas")
public class Reportes {
	
	private String cedula;
	private String codigo_venta;
	private ArrayList<String> detalleventa;
	private String ivaventa;
	private String totalventa;
	private String valorventa;
	
	
	public Reportes(String cedula, String codigo_venta, ArrayList<String> detalleventa, String ivaventa,
			String totalventa, String valorventa) {
		super();
		this.cedula = cedula;
		this.codigo_venta = codigo_venta;
		this.detalleventa = detalleventa;
		this.ivaventa = ivaventa;
		this.totalventa = totalventa;
		this.valorventa = valorventa;
	}


	


	public String getCedula() {
		return cedula;
	}




	public void setCedula(String cedula) {
		this.cedula = cedula;
	}





	public String getCodigo_venta() {
		return codigo_venta;
	}


	public void setCodigo_venta(String codigo_venta) {
		this.codigo_venta = codigo_venta;
	}


	public ArrayList<String> getDetalleventa() {
		return detalleventa;
	}


	public void setDetalleventa(ArrayList<String> detalleventa) {
		this.detalleventa = detalleventa;
	}


	public String getIvaventa() {
		return ivaventa;
	}


	public void setIvaventa(String ivaventa) {
		this.ivaventa = ivaventa;
	}


	public String getTotalventa() {
		return totalventa;
	}


	public void setTotalventa(String totalventa) {
		this.totalventa = totalventa;
	}


	public String getValorventa() {
		return valorventa;
	}


	public void setValorventa(String valorventa) {
		this.valorventa = valorventa;
	}
	
	
}
