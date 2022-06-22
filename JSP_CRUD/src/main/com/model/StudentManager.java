package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentManager 
{
	String url = "jdbc:mysql://localhost:3306/jsp";
	String dbuser = "root";
	String dbpwd = "postgres"; //MySQL database password
	
	Connection con = null;
	PreparedStatement ps = null;
	
	public String saveData(Student S) throws Exception
	{
		con = DriverManager.getConnection(url, dbuser, dbpwd);
		ps.setInt(1, S.getStudentid());
		ps.setString(2, S.getName());
		ps.setDouble(3, S.getCgpa());
		
		ps.execute();
		con.close();
		return "Data Inserted Sucessfully...";
	}
	public String UpdateData(Student S) throws Exception
	{
		con = DriverManager.getConnection(url, dbuser, dbpwd);
		ps = con.prepareStatement(" update student set name=(?) , cgpa=(?) where studentid=(?)");
		
		ps.setString(1, S.getName());
		ps.setDouble(2, S.getCgpa());
		ps.setInt(3, S.getStudentid());
		ps.execute();
		con.close();
		return "Data Updated Sucessfully...";
	}
			
	public List<Student> readData()
	{
		List<Student> L = new ArrayList<Student>();
		try
		{
			con = DriverManager.getConnection(url, dbuser, dbpwd);
			ps = con.prepareStatement("select * from student");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Student S=new Student();
				S.setStudentid(rs.getInt(1));
				S.setName(rs.getString(2));
				S.setCgpa(rs.getDouble(3));
				L.add(S);
			}
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return L;
	}
	
}
