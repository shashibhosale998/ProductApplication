package com.restapi.entity;

import com.restapi.category.Category;

//import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
//import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int product_id;
	@Column
	private String product_name;

	@Column
	private double product_price;

	@ManyToOne
	@JoinColumn(name = "category_ID")
	private Category category;

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public double getProduct_price() {
		return product_price;
	}

	public void setProduct_price(double product_price) {
		this.product_price = product_price;
	}

	public Category getCategory_id() {
		return category;
	}

	public void setCategory_id(Category category_id) {
		this.category = category_id;
	}

	public Product() {
//		this()
	}

	public Product(String product_name, double product_price, Category category_id) {
		super();
		this.product_name = product_name;
		this.product_price = product_price;
		this.category = category_id;
	}

	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", product_name=" + product_name + ", product_price="
				+ product_price + ", category=" + category + "]";
	}

}
