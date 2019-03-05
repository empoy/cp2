package com.sampoytech.shopaholic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LoginChecker {
	
	private String username,password;
	private String loginFile="Login.txt";
	public LoginChecker()
	{
		
	}
	public void setPassword(String password) 
	{
		this.password=password;
	}
	public void setUsername(String username) 
	{
		this.username=username;
	}
	public String[] check() throws IOException {
		String[] a={"0"};
		
		File fileLogin = new File(loginFile);

		BufferedReader reader = new BufferedReader(new FileReader(fileLogin));
		//String select = id;
		String currentLine;
		while((currentLine = reader.readLine()) != null) {
		    
			
			String[] parts =currentLine.split(" ");
		    
		    if(parts[1].equals(username)&& parts[2].equals(password)) {
		    	a=new String[] {parts[0],parts[3],parts[4],parts[5]};
		    }
		} 
		reader.close(); 
		return a;
	}

}
