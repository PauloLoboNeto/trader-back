package com.initializer.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "companyAction")
public class CompanyAction {

	@Id
	private String id;
	private String name;
	private String abreviationName;
	private String value;
	private String porcentage;
	private String minimo;
	private String maximo;
	private String date;
	private String dateTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbreviationName() {
		return abreviationName;
	}

	public void setAbreviationName(String abreviationName) {
		this.abreviationName = abreviationName;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getPorcentage() {
		return porcentage;
	}

	public void setPorcentage(String porcentage) {
		this.porcentage = porcentage;
	}

	public String getMinimo() {
		return minimo;
	}

	public void setMinimo(String minimo) {
		this.minimo = minimo;
	}

	public String getMaximo() {
		return maximo;
	}

	public void setMaximo(String maximo) {
		this.maximo = maximo;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
}