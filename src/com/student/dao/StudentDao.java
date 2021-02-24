package com.student.dao;
import java.util.List;

import com.student.pojo.Student;
public interface StudentDao
{
	boolean addStudent(Student s);
	boolean updateStudent(Student s);
	boolean deleteStudent(int s_id);
	
	List<Student> showAllStudent();
	Student searchStudentById(int id);
}