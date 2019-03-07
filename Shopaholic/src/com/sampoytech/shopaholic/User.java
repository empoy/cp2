package com.sampoytech.shopaholic;

public class User {
	private String id,username,password,name,surname,accessLevel,number,address;
	
	public User ()
	{
		
	}
	public User(String id, String username, String password,String name,
			String surname,String accessLevel,String number,String address )
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
	
	public void setId(String id)
	{
		this.id=id;
	}
	public void setUsername(String username)
	{
		this.username=username;
	}
	public void setPassword(String password)
	{
		this.password=password;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public void setSurname(String surname)
	{
		this.surname=surname;
	}
	public void setAccessLevel(String accessLevel)
	{
		this.accessLevel=accessLevel;
	}
	public void setNumber(String number)
	{
		this.number=number;
	}
	public void setAddress(String address)
	{
		this.address=address;
	}
	
	public String getId()
	{
		return id;
	}
	public String getUsername()
	{
		return username;
	}
	public String getPassword()
	{
		return password;
	}
	public String getName()
	{
		return name;
	}
	public String getSurname()
	{
		return surname;
	}
	public String getAccessLevel()
	{
		return accessLevel;
	}
	public String getNumber()
	{
		return number;
	}
	public String getAddress()
	{
		return address;
	}
	
	

}
