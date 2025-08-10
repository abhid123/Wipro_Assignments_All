package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
//import java.sql.SQLException;
import java.util.Scanner;

import com.dao.DepUnimpl;
import com.exception.DepartmentNotFoundException;
import com.util.DB_Connection;

public class Services implements DepUnimpl
{
	Scanner sc = new Scanner(System.in);
	
	@Override
	public void addNewDepartment() 
	{
		try 
		{
			Connection con = DB_Connection.connectToDB();
			
			PreparedStatement ps = con.prepareStatement("insert into department(deptId, deptName, location) values(?, ?, ?)");
			
			System.out.println("Enter deptid");
			int id = sc.nextInt();
			
			System.out.println("Enter deptName");
			String name = sc.next();
			
			System.out.println("Enter location");
			String location = sc.next();
			
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3, location);
			
			int rows = ps.executeUpdate();
			
			System.out.println(rows+" record inserted");
			
			ps.close();
			con.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
	}
	
	@Override
	public void getSingleDepartment() 
	{
		System.out.println("Enter id of which department you want data");
		int id = sc.nextInt();
		
		
		try 
		{
			Connection con = DB_Connection.connectToDB();
			
			PreparedStatement ps = con.prepareStatement("SELECT * FROM department WHERE deptId = ?");
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			System.out.println("deptId\tdeptName\tlocation");
			System.out.println("--------------------------");
			
			while(rs.next())
			{
				int i = rs.getInt(1);
				String name = rs.getString(2);
				String location = rs.getString(3);
				
				System.out.println(i+"\t"+name+"\t"+location);
			}
			
			rs.close();
			ps.close();
			con.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		
	}
	
	@Override
	public void getAllDepartment()
	{
		try 
		{
			Connection con = DB_Connection.connectToDB();
			
			Statement st = con.createStatement();
			
			String query = "Select * from department";
			
			ResultSet rs = st.executeQuery(query);
			
			System.out.println("deptId\tdeptName\tlocation");
			System.out.println("--------------------------");
			
			while(rs.next())
			{
				int i = rs.getInt(1);
				String name = rs.getString(2);
				String location = rs.getString(3);
				
				System.out.println(i+"\t"+name+"\t"+location);
			}
			
			rs.close();
			st.close();
			con.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	@Override
	public void updateDepartment()
	{
		System.out.println("Enter deptId that you want to update");
		int id = sc.nextInt();
		
		try 
		{
			Connection con = DB_Connection.connectToDB();
			
			PreparedStatement ps = con.prepareStatement("Update department set deptName = ?, location = ? where deptId = ?");
			
			System.out.println("Enter new deptName");
			String name = sc.next();
			
			System.out.println("Enter new location");
			String location = sc.next();
			
			ps.setString(1, name);
			ps.setString(2, location);
			ps.setInt(3, id);
			
			int row = ps.executeUpdate();
			
			if(row>0)
			{
				System.out.println(row+" New record updated");
			}
			else
			{
				throw new DepartmentNotFoundException("Department ID not found: " + id);
			}
			
			ps.close();
			con.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	@Override
	public void deleteDepartment()
	{
		System.out.println("Enter deptId that you want to delete");
		int id = sc.nextInt();
		
		try 
		{
			Connection con = DB_Connection.connectToDB();
			
			PreparedStatement ps = con.prepareStatement("Delete from department where deptid = ?");
			
			ps.setInt(1, id);
			
			int row = ps.executeUpdate();
			if(row>0)
			{
				System.out.println(row+" record deleted");
			}
			else
			{
				throw new DepartmentNotFoundException("Department ID not found: " + id);
			}
			
			ps.close();
			con.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
