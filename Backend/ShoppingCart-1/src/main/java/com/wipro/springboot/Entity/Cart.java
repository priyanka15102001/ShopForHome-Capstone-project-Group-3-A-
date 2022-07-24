package com.wipro.springboot.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
 
@Entity
public class Cart {
	 private Integer id;
	 private Integer product_id;
	 private String item_name;
	 private String quantity;
	 private float product_price;
	 private float discount_amt;
	 private String img_url;
	 private String username;
	 
	 
	public Cart() {
		super();
	}
	
	
	public Cart(Integer id,Integer product_id, String item_name, String quantity, float product_price, float discount_amt, String username, String img_url) {
		super();
		this.id = id;
		this.item_name = item_name;
		this.quantity = quantity;
		this.product_price = product_price;
		this.discount_amt = discount_amt;
		this.img_url = img_url;
		this.username = username;
		this.product_id = product_id;
	}

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getproduct_id() {
		return product_id;
	}


	public void setproduct_id(Integer product_id) {
		this.product_id = product_id;
	}


	public String getItem_name() {
		return item_name;
	}


	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}


	public String getQuantity() {
		return quantity;
	}


	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}


	public float getProduct_price() {
		return product_price;
	}


	public void setProduct_price(float product_price) {
		this.product_price = product_price;
	}


	public float getDiscount_amt() {
		return discount_amt;
	}


	public void setDiscount_amt(float discount_amt) {
		this.discount_amt = discount_amt;
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
		return "Cart [id=" + id + ",product_id=" + product_id +", item_name=" + item_name + ", quantity=" + quantity + ", product_price="
				+ product_price + ", discount_amt=" + discount_amt + ", img_url=" + img_url+", username="+ username+"]";
	}


}
