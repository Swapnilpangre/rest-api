package com.swapnil.demo;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
public class StudentRepository 
{
	Connection con=null;
	public StudentRepository()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
	        con=DriverManager.getConnection("jdbc:mysql://localhost/test","root","P@ssword123");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public List<Student> getStudents()
	{
		List<Student> Students=new ArrayList<>();
		String sql="SELECT * FROM STUDENT";
		try
		{
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next())
			{
				Student s=new Student();
				s.setId(rs.getInt(1));
				s.setDob(rs.getString(2));
				s.setDoj(rs.getString(3));
				s.setName(rs.getString(4));
				
				Students.add(s);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return Students;
	}
	public Student getStudent(int id)
	{
		Student s=new Student();
		String sql="SELECT * FROM STUDENT WHERE STUDENT_NO="+id;
		try
		{
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			if(rs.next())
			{
				
				s.setId(rs.getInt(1));
				s.setDob(rs.getString(2));
				s.setDoj(rs.getString(3));
				s.setName(rs.getString(4));
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return s;
	}
	public void create(Student s1) {
		String sql="INSERT INTO STUDENT(STUDENT_NO,STUDENT_DOB,STUDENT_DOJ,STUDENT_NAME) values (?, ?, ?, ?)";
		
		try
		{
			PreparedStatement st=con.prepareStatement(sql);
			st.setInt(1,s1.getId());
			st.setString(2,s1.getDob());
			st.setString(3,s1.getDoj());
			st.setString(4,s1.getName());
			st.executeUpdate();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public void update(Student s1) {
		String sql="UPDATE STUDENT SET STUDENT_DOB=?,STUDENT_DOJ=?,STUDENT_NAME=? WHERE STUDENT_NO=?";
		
		try
		{
			PreparedStatement st=con.prepareStatement(sql);
			
			st.setString(1,s1.getDob());
			st.setString(2,s1.getDoj());
			st.setString(3,s1.getName());
			st.setInt(4,s1.getId());
			st.executeUpdate();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	public void delete(int id) {
		String sql="DELETE FROM STUDENT WHERE STUDENT_NO=?";
		try
		{
			PreparedStatement st=con.prepareStatement(sql);
			st.setInt(1,id);
			st.executeUpdate();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
	}
	

}
