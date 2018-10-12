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


public class Program4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try(Connection con = ConnectionProvider.getInstance().getConnection();
			//Statement stmt = con.createStatement();
			PreparedStatement pst = (PreparedStatement) con.prepareStatement("delete from book where bid=?");
			Scanner scan = new Scanner(System.in);	
				){
			System.out.println("Enter Bcode");
			int bcode = scan.nextInt();
			pst.setInt(1,bcode);
			int count = pst.executeUpdate();
			System.out.println(count +"Row deleted");
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
