package com.wipro.springboot.Entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.web.bind.annotation.CrossOrigin;
 
@CrossOrigin("http://localhost:4200/")
@Entity
public class Product {
    private Integer id;
    private String product_name;
    private String product_type;
    private String product_price;
    private String product_desc;
    private String stocks;
    private String img_url;
	public Product() {
		super();
	}
	
	

	public Product(Integer id, String product_name, String product_type, String product_price, String product_desc, String stocks, String img_url) {
		super();
		this.id = id;
		this.product_name = product_name;
		this.product_type = product_type;
		this.product_price = product_price;
		this.product_desc = product_desc;
		this.stocks = stocks;
		this.img_url = img_url;
	}


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getProduct_name() {
		return product_name;
	}



	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}



	public String getProduct_type() {
		return product_type;
	}



	public void setProduct_type(String product_type) {
		this.product_type = product_type;
	}



	public String getProduct_price() {
		return product_price;
	}



	public void setProduct_price(String product_price) {
		this.product_price = product_price;
	}



	public String getProduct_desc() {
		return product_desc;
	}



	public void setProduct_desc(String product_desc) {
		this.product_desc = product_desc;
	}

	public String getstocks() {
		return stocks;
	}



	public void setstocks(String stocks) {
		this.stocks = stocks;
	}

	public void setimg_url(String img_url) {
		this.img_url = img_url;
	}



	public String getimg_url() {
		return img_url;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", product_name=" + product_name + ", product_type=" + product_type
				+ ", product_price=" + product_price + ", product_desc=" + product_desc + ",stocks="+stocks +",img_url="+img_url+"]";
	}


}



   