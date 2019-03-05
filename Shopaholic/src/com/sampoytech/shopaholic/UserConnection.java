package com.sampoytech.shopaholic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class UserConnection {
	
	private String id,username,password,name,surname,accessLevel,number,address;
	
	String f="Login.txt";
	String tempF="Login_temp.txt";
	File file=new File(f);
	File fileT=new File(tempF);
	public UserConnection()
	{}
	public UserConnection(String id,String username,String password,String name,
			String surname,String accessLevel,String number,String address) 
	{
		this.id=id;
		this.username=username;
		this.password=password;
		this.name=name;
		this.surname=surname;
		this.accessLevel=accessLevel;
		this.number=number;
		this.address=address;
	}
	
	public Boolean userAdder(String id,String username,String password,String name,
			String surname,String accessLevel,String number,String address) throws IOException 
	{
		BufferedReader br=new BufferedReader(new FileReader(file) );
		String check = id;
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
				pw.println(id+" "+username+" "+password+" "+name
						+" "+surname+" "+accessLevel+" "+number+" "+address);
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

}
