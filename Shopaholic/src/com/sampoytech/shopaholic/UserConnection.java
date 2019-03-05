package com.sampoytech.shopaholic;

import java.io.File;

public class UserConnection {
	
	private String id,username,password,name,surname,accessLevel,number,address;
	
	String f="Login.txt";
	String tempF="Login_temp.txt";
	File file=new File(f);
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
	
	public Boolean userAdder(String Id) {
		
		return null;
		
	}

}
