package com.verizon.jd.ui;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;
import com.verizon.jd.util.ConnectionProvider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Program03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try(Connection con = ConnectionProvider.getInstance().getConnection();
			//Statement stmt = con.createStatement();
			PreparedStatement pst = (PreparedStatement) con.prepareStatement("insert into Book values(?,?,?)");
			Scanner scan = new Scanner(System.in);	
				){
			System.out.println("Enter Bcode");
			int bcode = scan.nextInt();
			System.out.println("Title");
			String title = scan.next();
			System.out.println("Price");
			double price = scan.nextDouble();
			pst.setInt(1,bcode);
			pst.setString(2,title);
			pst.setDouble(3,price);
			int count = pst.executeUpdate();
			System.out.println(count +"Row Inserted");
			//ResultSet  rs = pst.executeQuery();
		
			
		/*	while(rs.next())
			{
				System.out.println(
						rs.getInt(1)+"\t" +
						rs.getString(2)+"\t" +
						rs.getDouble(3)+"\t" 
								
						);
			}*/
		}catch(SQLException e)
		{
			System.out.println(e);
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e);
		}
		
	}

}
