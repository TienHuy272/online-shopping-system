package com.fa.mock.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Manufacturer")
public class Manufacturer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Manufacturer_Id")
	private int manufacturerId;
	@Column(name = "Manufacturer_Name")
	private String manufacturerName;

	@Transient
	@OneToMany(mappedBy = "manufacturer")
	private Set<Product> products = new HashSet<Product>();

	public Manufacturer() {
		super();
	}

	public Manufacturer(String manufacturerName, Set<Product> products) {
		super();
		this.manufacturerName = manufacturerName;
		this.products = products;
	}

	public Manufacturer(int manufacturerId, String manufacturerName, Set<Product> products) {
		super();
		this.manufacturerId = manufacturerId;
		this.manufacturerName = manufacturerName;
		this.products = products;
	}

	public int getManufacturerId() {
		return manufacturerId;
	}

	public void setManufacturerId(int manufacturerId) {
		this.manufacturerId = manufacturerId;
	}

	public String getManufacturerName() {
		return manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		return manufacturerName;
	}

}
