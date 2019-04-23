package com.sampoytech.shopaholic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ProductConnection extends Connection {

	File file;
	ArrayList<Product> productArrayList;
	ProductConnection(String file) throws ParseException,IOException
	{
		this.file=new File(file);
		Scanner sc=new Scanner(file);
		productArrayList=new ArrayList<Product>();
		String temp;
		while (sc.hasNextLine())
		{
			temp=sc.nextLine();
			String[] split=temp.split(" ");
			String dateString = split[3];
	        SimpleDateFormat sd = new SimpleDateFormat("MM/dd/yyyy");
	        Date date = sd.parse(dateString);
			productArrayList.add(new Product(split[0],split[1],Integer.parseInt(split[2]),date));
		}
		sc.close();
	}
	@Override
	Boolean delete(String id) throws IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=new PrintWriter(file);
		Boolean a=false;
		for(int i=0; i<productArrayList.size();i++)
		{
			if (id.equals(productArrayList.get(i).getId()) )
			{
				productArrayList.remove(i);
			a=true;
			}
			pw.println(productArrayList.get(i).getId()+" "+productArrayList.get(i).getName()+" "+
					productArrayList.get(i).getPrice()+" "+productArrayList.get(i).getExpiryDate());
		}
		pw.close();
		return a;
	}
	@Override
	ArrayList<Product> lister() {
		// TODO Auto-generated method stub
		
		return productArrayList;
	}
	@Override
	Product select(String id) throws IOException {
		// TODO Auto-generated method stub
		for (int i = 0; i < productArrayList.size(); i++) {
			if (id.equals(productArrayList.get(i).getId()))
			{
				return productArrayList.get(i);
			}
		}
		return null;
	}
	
	Boolean adderProduct(Product p) throws IOException {
		// TODO Auto-generated method stub
		for (int i = 0; i < productArrayList.size(); i++) {
			if (p.getId().equals(productArrayList.get(i).getId()))
			{
				return false;
			}
		}
		PrintWriter pw=new PrintWriter(new FileWriter(file,true));
		pw.println(p.getId()+" "+p.getName()+" "+p.getPrice()+" "+p.getExpiryDate());
		pw.close();
		return true;
	}

	Boolean updateProduct(Product p) throws IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=new PrintWriter(file);
		Boolean a=false;
		for (int i=0 ; i<productArrayList.size();i++)
		{
			if(p.getId().equals(productArrayList.get(i).getId()))
			{
				pw.println(p.getId()+" "+p.getName()+" "+p.getPrice()+" "+p.getExpiryDate());
				a=true;
				continue;
			}
			pw.println(p.getId()+" "+p.getName()+" "+p.getPrice()+" "+p.getExpiryDate());
		}
		pw.close();
		return a;
	
	}
	

}
