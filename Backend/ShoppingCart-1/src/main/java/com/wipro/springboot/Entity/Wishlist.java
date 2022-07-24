package com.wipro.springboot.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Wishlist {
    private Integer id;
    private String name;
    private float product_price;
    private int quantity;
    private float total_amt;
    private String img_url;
	 private String username;

	public Wishlist() {
		super();
	}

	public Wishlist(Integer id, String name, float product_price, int quantity, float total_amt, String username, String img_url) {
		super();
		this.id = id;
		this.name = name;
		this.product_price = product_price;
		this.quantity = quantity;
		this.total_amt = total_amt;
		this.img_url = img_url;
		this.username = username;
		
	}
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getProduct_price() {
		return product_price;
	}

	public void setProduct_price(float product_price) {
		this.product_price = product_price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getTotal_amt() {
		return total_amt;
	}

	public void setTotal_amt(float total_amt) {
		this.total_amt = total_amt;
	}

	public String getimg_url() {
		return img_url;
	}


	public void setimg_url(String img_url) {
		this.img_url = img_url;
	}

	public String getusername() {
		return username;
	}


	public void setusername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "Wishlist [id=" + id + ", name=" + name + ", product_price=" + product_price + ", quantity=" + quantity
				+ ", total_amt=" + total_amt + ", img_url=" + img_url+", username="+ username+"]";
	}
	
    
}
