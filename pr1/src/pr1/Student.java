package pr1;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.Scanner;

public class Student extends Connection
{
	private String name,surname,stdId;
	private double grade1,grade2,grade3,gpa;
	String f="student.txt";
	String tf="student_temp.txt";
	File file=new File(f);
	String reader[] ;
	
	public Student()
	{
		
	}
	public Student(String name, String surname, String stdId, double grade1, double grade2, double grade3) throws IOException 
	{
		this.name=name;
		this.surname=surname;
		this.stdId=stdId;
		this.grade1=grade1;
		this.grade2=grade2;
		this.grade3=grade3;
		this.gpa=(this.grade1+this.grade2+this.grade3)/3;
		
	}
	public double GetGPA(String id) throws IOException
	{
		//call select method to get info of student and calculate gpa
		String[] parts=select(id).split(" ");
		return (Double.parseDouble(parts[3])+Double.parseDouble(parts[4])+Double.parseDouble(parts[5]))/3;
	}
	
	public double AvgGpa() throws IOException
	{
		Scanner sc=new Scanner(file);
		String[] parts;
		double gPA=0;
		int counter=0;
		while(sc.hasNextLine())
		{
			parts= sc.nextLine().split(" ");
			gPA+=(Double.parseDouble(parts[3])+Double.parseDouble(parts[4])+Double.parseDouble(parts[5]))/3;
			counter ++;
		}
		sc.close();
		return gPA/counter;
	}
	
	public Boolean studetnWriter () throws IOException 
	{
		File inputFile = new File(f);
		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		String check = stdId;
		String currentLine;
		
		while((currentLine = reader.readLine()) != null) 
		{
			String[] parts =currentLine.split(" ");
		    //String trimmedLine = currentLine.trim();
		    if(parts[0].equals(check)) 
		    {
		    	reader.close();
		    	return false;
		    }
		    else
		    {
		    	
		    	PrintWriter pw=new PrintWriter(new FileWriter(file,true));
				pw.println(stdId+" "+name+" "+surname+" "+grade1+" "+grade2+" "+grade3+" "+gpa);
				pw.close();
				reader.close();
				return true;
		    }
		}
		 
		reader.close();
		return null; 
		
		
	}
	public void studentReader() throws IOException
	{
		Scanner sc=new Scanner(file);
		while(sc.hasNextLine())
			System.out.println(sc.nextLine());
		sc.close();
	}
	public Boolean delete(String id) throws IOException
	{
		File inputFile = new File(f);
		File tempFile = new File(tf);

		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

		String lineToRemove = id;
		String currentLine;

		while((currentLine = reader.readLine()) != null) 
		{
		    // trim newline when comparing with lineToRemove
			String[] parts =currentLine.split(" ");
		    if(parts[0].equals(lineToRemove)) 
		    	continue;
		    writer.write(currentLine + System.getProperty("line.separator"));
		}
		writer.close(); 
		reader.close(); 
		inputFile.setWritable(true);
		tempFile.setWritable(true);
		boolean successful1=inputFile.delete();
		boolean successful = tempFile.renameTo(inputFile);
		System.out.println(successful+" "+successful1);
		return successful;
	}
	public String select(String id) throws IOException
	{
		File inputFile = new File(f);

		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		String select = id;
		String currentLine;
		while((currentLine = reader.readLine()) != null) {
		    
			
			String[] parts =currentLine.split(" ");
		    
		    if(parts[0].equals(select)) {
		    	reader.close();
		    	return currentLine;
		    }
		} 
		reader.close();
		return "student ID not found"; 
		
	}
	public void update(String id,int field,String value) throws IOException
	{
		File inputFile = new File(f);
		File tempFile = new File(tf);

		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
		String select = id;
		String currentLine;
		while((currentLine = reader.readLine()) != null) {
		    
			
			String[] parts =currentLine.split(" ");
		    parts[field]=value;
		    
		    	
		    	if(parts[0].equals(select)) 
		    		writer.write(parts[0]+" "+parts[1]+" "+parts[2]+" "+parts[3]+" "
		    				+parts[4]+" "+parts[5]+"\n");
		    	else
		    		writer.write(currentLine + System.getProperty("line.separator"));
		} 
		reader.close();
		writer.close();
		boolean successful1=inputFile.delete();
		boolean successful = tempFile.renameTo(inputFile);
		System.out.println(successful+" "+successful1);
	}
	

	
	
	
	
}
