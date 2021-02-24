package com.student.test;
import com.student.pojo.Student;
import com.student.dao.StudentDaoImpl;
import com.student.dao.StudentDao;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.*;

public class StudentTest {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		Student s = new Student();
		StudentDaoImpl sdi= new StudentDaoImpl();
		List<Student> l= new ArrayList<Student>();
		int s_id=0;
		int roll;
		int sid;
		String name;
		String city;
		String qualification;
		int choice=0;
		do
		{
			System.out.println("Welcome to the Registration Form");
			System.out.println("1.Add student details \n 2. Update student details \n 3.Delete student details \n 4.Show all student \n 5.Search student by id");

		try
		{
						System.out.println("Enter your choice: ");
			choice=sc.nextInt();
			switch(choice)
			{
			case 1://add student details
				System.out.println("Enter student name: ");
				name=sc.next();
				System.out.println("Enter student city: ");
				city=sc.next();
				System.out.println("Enter student qualification: ");
				qualification= sc.next();
				s= new Student(name, city, qualification);
				s.setQualification(qualification);
				
				
				boolean f= sdi.addStudent(s);
				if(f==true)
				{
					System.out.println("Success");
				}
				else
				{
					System.out.println("Failure");
				}
				break;
			case 2://update student details
				System.out.println("Enter student's name: ");
				name=sc.next();
				System.out.println("Enter student's city: ");
				city=sc.next();
				System.out.println("Enter student's qualification: ");
				qualification =sc.next();
				s= new Student(name, city, qualification);
				System.out.println("Enter student's roll_no: ");
				roll=sc.nextInt();
				s.setRoll_no(roll);
				sdi.updateStudent(s);
				break;
			case 3: // delete student
				System.out.println("Enter the roll_no: ");
				roll=sc.nextInt();
				sdi.deleteStudent(roll);
				
				break;	
			case 4: // show all students
				l=sdi.showAllStudent();
				Iterator <Student> it= l.iterator();
				while(it.hasNext())
				{
					System.out.println(it.next());
				}
				break;
			case 5:
				System.out.println("Enter roll_no to search Student: ");
				sid=sc.nextInt();
				Student s1=sdi.searchStudentById(sid);
				System.out.println(s1);
				break;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
		while(choice<6);
}
}