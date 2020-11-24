package com.sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Jdbc {
	
public static void main(String[] args) {
	Connection con = null;
	
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con  = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "gowthamdn");
		
		String sql ="Select * from stud";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		 while (rs.next()) {
			 
			 String name = rs.getString("firstname");
			 String pass = rs.getString("LASTNAME");
			 System.out.println(name);
			 System.out.println(pass);
			 
		 }	
	} catch (ClassNotFoundException | SQLException e) {
		
		e.printStackTrace();
	}
	
	finally {
		try {
		con.close();
	}
	catch(SQLException e) {
		
		   e.printStackTrace();
		
	}
	}
}		

}
