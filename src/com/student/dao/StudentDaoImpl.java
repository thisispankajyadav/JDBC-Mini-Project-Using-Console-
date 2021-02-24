package com.student.dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import com.student.pojo.Student;
import com.student.utility.DBUtility;

public class StudentDaoImpl implements StudentDao{
	
	DBUtility dbu=new DBUtility();
	Student s= new Student();
	List<Student> l= new ArrayList<Student>();
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	boolean f=false;
	int result=0;
	
	@Override
	public boolean addStudent(Student s)
	{
		try
		{
			con=dbu.getConnection();
			String query="insert into student(name, city, qualification ) values(?,?,?)";
			ps=con.prepareStatement(query);
			ps.setString(1, s.getName());
			ps.setString(2,s.getCity());
			ps.setString(3,s.getQualification());
			result=ps.executeUpdate();
			if(result>0)
			{
				f=true;
			}
			else
			{
				f=false;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return f;
		
	}

	@Override
	public boolean updateStudent(Student s) {
		try
		{
			con=dbu.getConnection();
			String query="update student set name=?,city=?,qualification=? where roll_no=?";
			ps=con.prepareStatement(query);
			ps.setString(1,s.getName());
			ps.setString(2,s.getCity());
			ps.setString(3,s.getQualification());
			ps.setInt(4,s.getRoll_no());
			result=ps.executeUpdate();
			if(result>0)
			{
				f=true;
			}
			else
			{
				f=false;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return f;
	}
	
	@Override
	public boolean deleteStudent(int s_id)
	{
		try
		{
			con=dbu.getConnection();
			String query="delete from student where roll_no=?";
			ps=con.prepareStatement(query);
			ps.setInt(1, s_id);
			int result=ps.executeUpdate();
			if(result>0)
			{
				f=true;
			}
			else
			{
				f=false;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return f;
	}
	
	@Override
	public List<Student> showAllStudent()
	{
		try
		{
			con=dbu.getConnection();
			String query="select * from student";
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
			while(rs.next())
			{
				Student s1= new Student();
				s1.setRoll_no(rs.getInt(1));
				s1.setName(rs.getString(2));
				s1.setCity(rs.getString(3));
				s1.setQualification(rs.getString(4));
				l.add(s1);
			}
			return l;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		
	}
	@Override
	public Student searchStudentById(int id) {
		Student d=new Student();
		try
		{
			con=dbu.getConnection();
			String sql="select * from student where roll_no=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			
			while(rs.next())
			{
				d.setRoll_no(rs.getInt(1));
				d.setName(rs.getString(2));
				d.setCity(rs.getString(3));
				d.setQualification(rs.getString(4));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return d;
	}
}