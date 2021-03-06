package com.sampoytech.shopaholic;

import java.io.File;
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
	ArrayList<User> userArrayList;
	
	public UserConnection() throws IOException
	{
		Scanner sc=new Scanner(file);
		String temp;
		userArrayList=new ArrayList<User>();
		//userArrayList.add(new User());
		while(sc.hasNextLine()) 
		{
			temp=sc.nextLine();
			String[] split=temp.split(" ");
			userArrayList.add(new User(split[0],split[1],split[2],split[3],split[4],split[5],
					split[6],split[7]));
		}
		sc.close();
		
	}
	public UserConnection(User u) throws IOException 
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
		PrintWriter pw=new PrintWriter(file);
		Boolean a=false;
		for(int i=0; i<userArrayList.size();i++)
		{
			if (id.equals(userArrayList.get(i).getId()) )
			{
			userArrayList.remove(i);
			a=true;
			}
			if(i!=userArrayList.size())
			pw.println(userArrayList.get(i).getId()+" "+userArrayList.get(i).getUsername()+" "+
				userArrayList.get(i).getPassword()+" "+userArrayList.get(i).getName()+" "+
				userArrayList.get(i).getSurname()+" "+userArrayList.get(i).getAccessLevel()+" "+
				userArrayList.get(i).getNumber()+" "+userArrayList.get(i).getAddress());
		}
		pw.close();
		return a;
	}

	Boolean updateUser(User user) throws IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=new PrintWriter(file);
		Boolean a=false;
		for (int i=0 ; i<userArrayList.size();i++)
		{
			if(user.getId().equals(userArrayList.get(i).getId()))
			{
				pw.println(user.getId()+" "+user.getUsername()+" "+user.getPassword()+" "+
						user.getName()+" "+user.getSurname()+" "+user.getAccessLevel()+" "+
						user.getNumber()+" "+user.getAddress());
				a=true;
				continue;
			}
			pw.println(userArrayList.get(i).getId()+" "+userArrayList.get(i).getUsername()+" "+
					userArrayList.get(i).getPassword()+" "+userArrayList.get(i).getName()+" "+
					userArrayList.get(i).getSurname()+" "+userArrayList.get(i).getAccessLevel()+" "+
					userArrayList.get(i).getNumber()+" "+userArrayList.get(i).getAddress());
		}
		pw.close();
		return a;
	
	}

	
	Boolean adderUser(User u) throws IOException {
		// TODO Auto-generated method stub
		for (int i = 0; i < userArrayList.size(); i++) {
			if (u.getId().equals(userArrayList.get(i).getId()))
			{
				return false;
			}
		}
		PrintWriter pw=new PrintWriter(new FileWriter(file,true));
		pw.println(u.getId()+" "+u.getUsername()+" "+u.getPassword()+" "+u.getName()
				+" "+u.getSurname()+" "+u.getAccessLevel()+" "+u.getNumber()+" "+u.getAddress());
		pw.close();
		return true;
		
	}

	@Override
	ArrayList<User> lister() throws IOException {
		// TODO Auto-generated method stub
		return userArrayList;
	}

	@Override
	User select(String id) throws IOException {
		// TODO Auto-generated method stub
		for (int i = 0; i < userArrayList.size(); i++) {
			if (id.equals(userArrayList.get(i).getId()))
			{
				return userArrayList.get(i);
			}
		}
		return null;
	}
	
}
