package com.sampoytech.shopaholic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class UserConnection {
	
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
	
	public ArrayList<User> userLister() throws IOException
	{
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
	
	public Boolean userAdder(User u) throws IOException 
	{
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
	
	public Boolean deleteUser(String id) throws IOException 
	{
		BufferedReader br=new BufferedReader(new FileReader(file));
		BufferedWriter bw=new BufferedWriter(new FileWriter(fileT));
		
		String lineToRemove = id;
		String currentLine;

		while((currentLine = br.readLine()) != null) {
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
	
	public Boolean updateUser(User user)
	{
		
		
		return null;
		
	}
	

}
