package com.verizon.adb.dao;

public interface IQueryMapper {
	
	public static final String INS_CONT_QRY =
			"INSERT INTO Subjects VALUES(?,?,?)";
	
	public static final String DEL_CONT_QRY =
			"DELETE FROM Subjects WHERE sid=?";
	
	public static final String SET_ALL_CONT_ID = 
			"SELECT * FROM Subjects";
	
	public static final String SEL_CONT_BY_MNO_QRY = 
			"SELECT * FROM Subjects WHERE sid=?";
	
	public static final String SEL_ALL_SUB_QUERY_ORD_BY_ID=
			"SELECT * FROM Subjects ORDER BY sid ASC";
	public static final String SEL_ALL_SUB_QUERY_ORD_BY_NAME=
			"SELECT * FROM Subjects ORDER BY subtitle ASC";
	public static final String SEL_ALL_SUB_QUERY_ORD_BY_HRS=
			"SELECT * FROM Subjects ORDER BY duration ASC";

	
}