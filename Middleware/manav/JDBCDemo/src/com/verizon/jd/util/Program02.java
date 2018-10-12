package com.verizon.jd.util;

import java.sql.SQLException;

import java.sql.Connection;

public class Program02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(Connection con = ConnectionProvider.getInstance().getConnection()){
			System.out.println("Established Connection");
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
