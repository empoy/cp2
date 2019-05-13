package com.sampoytech.shopaholic;

public class Product {
	
	private String name,id;
	private int price;
	

	Product ()
	{
		
	}
	
	Product (String id,String name,int price)
	{
		this.setId(id);
		this.setName(name);;
		this.setPrice(price);
		
	}

	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
