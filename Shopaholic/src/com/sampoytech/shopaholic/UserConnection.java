package com.sampoytech.shopaholic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class UserConnection extends Connection {

	
private String id,username,password,name,surname,accessLevel,number,address;
	
	String f="Login.txt";
	String tempF="Login_temp.txt";
	File file=new File(f);
	File fileT=new File(tempF);
	public UserConnection()
	{}
	public UserConnection(User u) 
	{
		this.id=u.getId();
		this.username=u.getUsername();
		this.password=u.getPassword();
		this.name=u.getName();
		this.surname=u.getSurname();
		this.accessLevel=u.getAccessLevel();
		this.number=u.getNumber();
		this.address=u.getAddress();
	}
	
	
	
	
	
	
	@Override
	Boolean delete(String id) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new FileReader(file));
		BufferedWriter bw=new BufferedWriter(new FileWriter(fileT));
		
		String lineToRemove = id;
		String currentLine;

		while((currentLine = br.readLine()) != null) 
		{
			String[] parts =currentLine.split(" ");
		    if(parts[0].equals(lineToRemove)) continue;
		    bw.write(currentLine + System.getProperty("line.separator"));
		}
		bw.close(); 
		br.close(); 
		file.setWritable(true);
		fileT.setWritable(true);
		boolean successful1=file.delete();
		boolean successful = fileT.renameTo(file);
		if (successful==true && successful1==true) 
		return successful;
		return false;
		
	}

	@Override
	Boolean updateUser(User user) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new FileReader(file));
		BufferedWriter writer = new BufferedWriter(new FileWriter(fileT));
		String select = user.getId();
		String currentLine;
		while((currentLine = reader.readLine()) != null) 
		{
			String[] parts =currentLine.split(" ");
		        		    	
		    	if(parts[0].equals(select)) 
		    		writer.write(user.getId()+" "+user.getUsername()+" "+user.getPassword()+" "+user.getName()+" "
		    				+user.getSurname()+" "+user.getAccessLevel()+" "+user.getNumber()+" "+user.getAddress()+"\n");
		    	else
		    		writer.write(currentLine + System.getProperty("line.separator"));
		} 
		reader.close();
		writer.close();
		boolean successful1=file.delete();
		boolean successful = fileT.renameTo(file);
		
		return (successful&&successful1);
		
	}

	@Override
	Boolean updateProduct(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	Boolean adderUser(User u) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new FileReader(file) );
		String check = u.getId();
		String currentLine;
		while((currentLine = br.readLine()) != null) 
		{
			String[] parts =currentLine.split(" ");
		    if(parts[0].equals(check)) 
		    {
		    	br.close();
		    	return false;
		    }
		    else
		    {
		    	PrintWriter pw=new PrintWriter(new FileWriter(file,true));
				pw.println(u.getId()+" "+u.getUsername()+" "+u.getPassword()+" "+u.getName()
						+" "+u.getSurname()+" "+u.getPassword()+" "+u.getName()+" "+u.getAddress());
				pw.close();
				br.close();
				return true;
		    }
		}
		br.close();
		return null;
		
	}

	@Override
	ArrayList<User> listerUser() throws IOException {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(file);
		String temp;
		ArrayList<User> u=new ArrayList<User>();
		u.add(new User());
		String[][] reader = new String[100][8];
		int i=0;
		while(sc.hasNextLine()) 
		{
			temp=sc.nextLine();
			String[] split=temp.split(" ");
			u.add(new User(split[0],split[1],split[2],split[3],split[4],split[5],
					split[6],split[7]));
		}
		sc.close();
		return u;
		
	}

	@Override
	ArrayList<Product> listerProduct() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	User selectUser(String id) throws IOException {
		// TODO Auto-generated method stub
		User u=new User();
		BufferedReader br=new BufferedReader(new FileReader(file));
		
		String currentLine;

		while((currentLine = br.readLine()) != null) 
		{
			String[] parts =currentLine.split(" ");
		    if(parts[0].equals(id)) 
		    {
		    u.setId(id);
		    u.setUsername(parts[1]);
		    u.setPassword(parts[2]);
		    u.setName(parts[3]);
		    u.setSurname(parts[4]);
		    u.setAccessLevel(parts[5]);
		    u.setNumber(parts[6]);
		    u.setAddress(parts[7]);
		    }
		}
		br.close();
		return u;
	}
	@Override
	Boolean adderProduct(Product product) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	Product selectProduct(String id) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}
	

}
