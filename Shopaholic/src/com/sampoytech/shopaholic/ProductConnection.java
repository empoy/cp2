package com.sampoytech.shopaholic;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductConnection extends Connection {

	File file;
	ArrayList<Product> productArrayList;
	ProductConnection(String f) throws ParseException,IOException
	{
		f+=".txt";
		this.file=new File(f);
		//PrintWriter pw=new PrintWriter(new FileWriter(this.file,true));
		Scanner sc=new Scanner(file);
		productArrayList=new ArrayList<Product>();
		String temp;
		while (sc.hasNextLine())
		{
			temp=sc.nextLine();
			String[] split=temp.split(" ");
			productArrayList.add(new Product(split[0],split[1],Integer.parseInt(split[2])));
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
			if(i!=productArrayList.size())
				pw.println(productArrayList.get(i).getId()+" "+productArrayList.get(i).getName()+" "+
					productArrayList.get(i).getPrice());
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
		pw.println(p.getId()+" "+p.getName()+" "+p.getPrice());
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
				pw.println(p.getId()+" "+p.getName()+" "+p.getPrice());
				a=true;
				continue;
			}
			pw.println(p.getId()+" "+p.getName()+" "+p.getPrice());
		}
		pw.close();
		return a;
	
	}
	

}
