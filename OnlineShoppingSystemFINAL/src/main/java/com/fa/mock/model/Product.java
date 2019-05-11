package com.fa.mock.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Product")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Product_Id")
	private int productId;
	@Column(name = "Product_Name")
	private String productName;
	@Column(name = "Unit_Price")
	private double unitPrice;
	@Column(name = "Units_In_Stock")
	private int unitInStock;
	@Column(name = "Description")
	private String description;
	@Column(name = "Condition")
	private String condition;
	@Column(name = "Product_Image_File")
	private String productImageFile;

	@JsonIgnore
	@OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
	private transient Set<OrderDetails> orderDetails = new HashSet<OrderDetails>();

	@ManyToOne
	@JoinColumn(name = "Manufacturer_Id", nullable = false)
	private Manufacturer manufacturer;

	@ManyToOne
	@JoinColumn(name = "Category_Id", nullable = false)
	private Category category;

	@Transient
	private MultipartFile file;
	@Column(name = "Code")
	private String code;

	public Product() {
		this.code = "PRD" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	}

	public Product(String productName, float unitPrice, int unitInStock, String description, String condition,
			String productImangeFile, Set<OrderDetails> orderDetails, Manufacturer manufacturer, Category category,
			MultipartFile file, String code) {
		this.productName = productName;
		this.unitPrice = unitPrice;
		this.unitInStock = unitInStock;
		this.description = description;
		this.condition = condition;
		this.productImageFile = productImangeFile;
		this.orderDetails = orderDetails;
		this.manufacturer = manufacturer;
		this.category = category;
		this.file = file;
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getUnitInStock() {
		return unitInStock;
	}

	public void setUnitInStock(int unitInStock) {
		this.unitInStock = unitInStock;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public Set<OrderDetails> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(Set<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public MultipartFile getFile() {
		return file;
	}

	public String getProductImageFile() {
		return productImageFile;
	}

	public void setProductImageFile(String productImageFile) {
		this.productImageFile = productImageFile;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Product) {
			Product product = (Product) obj;
			return this.getProductId() == product.getProductId();
		}
		return false;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.getProductId();
	}

	public String toString() {
		return "{" + "\"productId\":\"" + this.productId + "\"," + "\"productName\":\"" + this.productName + "\","
				+ "\"unitPrice\":\"" + this.unitPrice + "\"," + "\"productImageFile\":\"" + this.productImageFile
				+ "\"," + "\"unitInStock\":\"" + this.unitInStock + "\"," + "\"description\":\"" + this.description
				+ "\"," + "\"condition\":\"" + this.condition + "\"" + "}";
	}
}
