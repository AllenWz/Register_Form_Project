package com.allen.dao;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

import com.allen.Student;

public class StudentDao {
	
	/*
	 * Insert data from register form into database
	 */
	public int createStudent(String name,String email,LocalDate dob,String phone,String address,String course,String gender) {
		String URL = "jdbc:mysql://localhost:3306/register";
		String USER = "root";
		String PASS = "root";
		
		String sql = "insert into students(name,email,dob,phone,address,gender,course) values(?,?,?,?,?,?,?)";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try(Connection con = DriverManager.getConnection(URL,USER,PASS);
				PreparedStatement stm = con.prepareStatement(sql)) {
			
			stm.setString(1,name);
			stm.setString(2,email);
			stm.setDate(3,Date.valueOf(dob));
			stm.setString(4,phone);
			stm.setString(5,address);
			stm.setString(6,gender);
			stm.setString(7,course);
			
			return stm.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	/*
	 * Select data from database to show as table
	 */
	public ArrayList<Student> showStudents() {
		
		ArrayList<Student> stds = new ArrayList<>();
		
		String URL = "jdbc:mysql://localhost:3306/register";
		String USER = "root";
		String PASS = "root";
		
		String sql = "select * from students";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try(Connection con = DriverManager.getConnection(URL,USER,PASS);
				Statement stm = con.createStatement()) {
			
			ResultSet result= stm.executeQuery(sql);
			
			while(result.next()) {
				stds.add(new Student(
						result.getInt("id"),
						result.getString("name"),
						result.getString("email"),
						result.getDate("dob").toLocalDate(),
						result.getString("phone"),
						result.getString("address"),
						result.getString("gender"),
						result.getString("course")
						));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return stds;
	}
	
	/*
	 * Select with id to edit data
	 */
	public Student selectStudent(int id) {
		String URL = "jdbc:mysql://localhost:3306/register";
		String USER = "root";
		String PASS = "root";
		
		String sql = "select * from students where id = ?";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try(Connection con = DriverManager.getConnection(URL,USER,PASS);
				PreparedStatement stm = con.prepareStatement(sql)) {
			
			stm.setInt(1, id);
			ResultSet result= stm.executeQuery();
			
			while(result.next()) {
				return new Student(
						result.getInt("id"),
						result.getString("name"),
						result.getString("email"),
						result.getDate("dob").toLocalDate(),
						result.getString("phone"),
						result.getString("address"),
						result.getString("gender"),
						result.getString("course")
						);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/*
	 * Update data in database using id
	 */
	public int updateStudentData(Student std) {
		String URL = "jdbc:mysql://localhost:3306/register";
		String USER = "root";
		String PASS = "root";
		
		String sql = "update students set name=?,email=?,dob=?,phone=?,address=?,course=?,gender=? where id=?";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try(Connection con = DriverManager.getConnection(URL,USER,PASS);
				PreparedStatement stm = con.prepareStatement(sql)) {
			
			stm.setString(1, std.name());
			stm.setString(2, std.email());
			stm.setDate(3, Date.valueOf(std.dob()));
			stm.setString(4, std.phone());
			stm.setString(5, std.address());
			stm.setString(6, std.course());
			stm.setString(7, std.gender());
			stm.setInt(8, std.id());
			return stm.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	
	/*
	 * Delete data from database
	 */
	public int deleteStudent(int id) {
		String URL = "jdbc:mysql://localhost:3306/register";
		String USER = "root";
		String PASS = "root";
		
		String sql = "delete from students where id = ?";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try(Connection con = DriverManager.getConnection(URL,USER,PASS);
				PreparedStatement stm = con.prepareStatement(sql)) {
			
			stm.setInt(1, id);
			return stm.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
