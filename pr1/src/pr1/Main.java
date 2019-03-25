package pr1;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException 
	{
		String name,surname,stdId;
		double grade1,grade2,grade3,gpa;
		
		//menu
		System.out.println("1-Add Student\n2-List Students\n3-Delete Student\n4-Update Studentn\n5-Select Student\n6-Show GPA"
				+ "\n7-Avrage GPA");
		Scanner sc=new Scanner(System.in);
		//user request processing
		switch (sc.nextInt()) 
		{
		case 1:
			
			while (true)
			{
				System.out.println("Write student name , surname , student id , grade1,2,3");
				name=sc.next();
				surname=sc.next();
				stdId=sc.next();
				grade1=sc.nextDouble();
				grade2=sc.nextDouble();
				grade3=sc.nextDouble();
				
				Student s=new Student(name,surname,stdId,grade1,grade2,grade3);
				if( s.studetnWriter())
					System.out.println("student added succesfully\ndo you want to add new student?!Y/N");
				else
					System.out.println("student ID is used\ndo you want to add new student?!Y/N ");
				if (sc.next().charAt(0)=='y'||sc.next().charAt(0)=='Y')
				{}
				else
					break;
			}
				
		case 2:
			Student s1=new Student();
			s1.studentReader();
			break;
		case 3:
			Student s2=new Student();
			s2.studentReader();
			System.out.println("Write StudetnId that you want to be deleted:");
			s2.delete(sc.next());
			break;
		case 4:
			System.out.println("write studentId that you want to be updated");
			String st=sc.next();
			Student s3=new Student();
			System.out.println(s3.select(st)+"\nwhich field you want to be updated?!"+
			"name,surname,grade1,grade2,grade3");
			switch (sc.next()) {
			case "name":
				System.out.println("Write new value");
				s3.update(st, 1,sc.next());
				break;
			case "surname":
				System.out.println("Write new value");
				s3.update(st, 2,sc.next());
				break;
			case "grade1":
				System.out.println("Write new value");
				s3.update(st, 3,sc.next());
				break;
			case "grade2":
				System.out.println("Write new value");
				s3.update(st, 4,sc.next());
				break;
			case "grade3":
				System.out.println("Write new value");
				s3.update(st, 5,sc.next());
				break;

			default:
				break;
			}
			break;
		case 5:
			System.out.println("write studentId that you want to see details");
			Student s4=new Student();
			System.out.println(s4.select(sc.next()));
			break;
		case 6:
			Student s5=new Student();
			System.out.println("write studentId that you want to see GPA");
			System.out.println(s5.GetGPA(sc.next()));
			break;
		case 7:
			Student s6=new Student();
			System.out.println(s6.AvgGpa()); 
			break;
		}
		sc.close();
		
	}

}
