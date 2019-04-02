package pr1;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Student extends Connection
{
	private String name,surname,stdId;
	private double grade1,grade2,grade3,gpa;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getStdId() {
		return stdId;
	}
	public void setStdId(String stdId) {
		this.stdId = stdId;
	}
	public double getGrade1() {
		return grade1;
	}
	public void setGrade1(double grade1) {
		this.grade1 = grade1;
	}
	public double getGrade2() {
		return grade2;
	}
	public void setGrade2(double grade2) {
		this.grade2 = grade2;
	}
	public double getGrade3() {
		return grade3;
	}
	public void setGrade3(double grade3) {
		this.grade3 = grade3;
	}
	
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
	//getting a student gpa by id
	public double GetGPA(String id) throws IOException
	{
		//call select method to get info of student and calculate gpa
		String[] parts=select(id).split(" ");
		return (Double.parseDouble(parts[3])+Double.parseDouble(parts[4])+Double.parseDouble(parts[5]))/3;
	}
	//find total average of gpa
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
	//add new student
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
				pw.println(stdId+" "+name+" "+surname+" "+grade1+" "+grade2+" "+grade3);
				pw.close();
				reader.close();
				return true;
		    }
		}
		 
		reader.close();
		return null; 
		
		
	}
	//list all student
	public void studentReader() throws IOException
	{
		Scanner sc=new Scanner(file);
		while(sc.hasNextLine())
			System.out.println(sc.nextLine());
		sc.close();
	}
	//delete student by id
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
	//select single student by id
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
	//update student by id and desired field and the value
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
	//sort students by their gpa
	public ArrayList<Student> gpaSortBubble() throws IOException
	{
		ArrayList<Student> ar=new ArrayList<Student>();
		Scanner sc=new Scanner(file);
		
		while(sc.hasNextLine())
		{
			String[] temp=sc.nextLine().split(" ");
			ar.add(new Student(temp[1],temp[2],temp[0],Double.parseDouble(temp[3]),
					Double.parseDouble(temp[4]),Double.parseDouble(temp[5])));
		}
		sc.close();
		for (int i = 0; i < ar.size()-1; i++) 
		{
			for (int j = 0; j < ar.size()-i-1; j++) 
			{
				double gpa=(ar.get(j).getGrade1()+ar.get(j).getGrade2()+ar.get(j).getGrade3())/3;
				double gpa_sec=(ar.get(j+1).getGrade1()+ar.get(j+1).getGrade2()+ar.get(j+1).getGrade3())/3;
				if(gpa<gpa_sec)
				{
					Student sTemp=ar.get(j);
					ar.set(j, ar.get(j+1));
					ar.set(j+1, sTemp);
				}
			}
		}
		for (int i = 0; i < ar.size(); i++) {
			System.out.println(ar.get(i).getName()+" "+ar.get(i).GetGPA(ar.get(i).getStdId()));
		}
		return ar;
	}
/*	
	public ArrayList<Student> gpaSortQuick () throws IOException
	{
		ArrayList<Student> ar=new ArrayList<Student>();
		Scanner sc=new Scanner(file);
		int high=0,low=100;
		int i=0;
		while(sc.hasNextLine())
		{
			String[] temp=sc.nextLine().split(" ");
			ar.add(new Student(temp[1],temp[2],temp[0],Double.parseDouble(temp[3]),
					Double.parseDouble(temp[4]),Double.parseDouble(temp[5])));
			if ( (Double.parseDouble(temp[3])+
					Double.parseDouble(temp[4])+Double.parseDouble(temp[5]))/3 > high )
				high=i;
			else if ( (Double.parseDouble(temp[3])+
					Double.parseDouble(temp[4])+Double.parseDouble(temp[5]))/3 < low )
				low=i;
			i++;
		}
		sc.close();
		sort(ar, low, high);
		for (int j = 0; j < ar.size(); j++) {
			System.out.println(ar.get(j).getName()+" "+ar.get(j).GetGPA(ar.get(j).getStdId()));
		}
		return null;
	}
	
	private int quickSortPartion( ArrayList<Student> arr ,int low, int high) throws IOException
	{
		double pivot = arr.get(high).GetGPA(arr.get(high).getStdId()); 
        int i = (low-1); // index of smaller element 
        for (int j=low; j<high; j++) 
        { 
            // If current element is smaller than or 
            // equal to pivot 
            if (arr.get(j).GetGPA(arr.get(j).getStdId()) <= pivot) 
            { 
                i++; 
  
                // swap arr[i] and arr[j] 
                Student temp = arr.get(i);  
                arr.set(i, arr.get(j));
                arr.set(j, temp);
                
            } 
        } 
  
        // swap arr[i+1] and arr[high] (or pivot)  
        Student temp = arr.get(i+1);
        arr.set(i+1, arr.get(high));
        arr.set(high, temp);
  
        return i+1; 
			
	}
	void sort(ArrayList<Student> arr ,int low, int high) throws IOException 
    { 
        if (low < high) 
        { 
            /* pi is partitioning index, arr[pi] is  
              now at right place */
 /*           int pi = quickSortPartion(arr, low, high); 
  
            // Recursively sort elements before 
            // partition and after partition 
            sort(arr, low, pi-1); 
            sort(arr, pi+1, high); 
        } 
    } 
		
*/	
	
}
