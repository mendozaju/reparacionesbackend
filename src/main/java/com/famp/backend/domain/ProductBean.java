package com.famp.backend.domain;

public class ProductBean {
	
	Integer id;
	String name;
	Double price;
	Integer stock;
	
	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public ProductBean(){
		this.id = null;
		this.name = "";
		this.price = 0.0;
		this.stock = 0;
	}
	
	public void setName(String productName){
		this.name =productName;
	}
	
	public void setId(Integer productId){
		this.id = productId;
	}
	
	public void setPrice(Double productPrice){
		this.price= productPrice;		
	}
	
	public String getName(){
		return this.name;
	}
	
	public Integer getId(){
		return this.id;
	}
	
	public Double getPrice(){
		return this.price;
	}
	

}
