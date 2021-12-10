package co.edu.lagenerica.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "consolidado")
public class Consolidated {

	@Id
	private String id;
	private String city;
	private long totalventas;
	
	public Consolidated() {
	}

	public Consolidated(String city, long totalventas) {
		super();
		this.city = city;
		this.totalventas = totalventas;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCiudad() {
		return city;
	}

	public void setCiudad(String ciudad) {
		this.city = ciudad;
	}

	public long getTotalventas() {
		return totalventas;
	}

	public void setTotalventas(long totalventas) {
		this.totalventas = totalventas;
	}
}