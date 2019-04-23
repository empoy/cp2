package com.sampoytech.shopaholic;

import java.util.Date;

public class Product {
	
	private String name,id;
	private int price;
	private Date expiryDate;
	

	Product ()
	{
		
	}
	
	Product (String id,String name,int price,Date expiryDate)
	{
		this.setId(id);
		this.setName(name);;
		this.setPrice(price);
		this.setExpiryDate(expiryDate);
	}

	public Date getExpiryDate() {
		return expiryDate;
	}


	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
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
