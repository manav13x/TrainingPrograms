package com.verizon.adb.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.verizon.adb.exception.SubjectException;

import com.verizon.adb.model.Subject;
import com.verizon.adb.util.ConnectionProvider;

public class ContactDaoJDBCImpl implements SubjectDao {

	public ContactDaoJDBCImpl(){
		//default constructor
	}
	

	@Override
	public Subject add(Subject subject) throws SubjectException {
		if(subject!=null){
			try(Connection con = ConnectionProvider.getInstance().getConnection();
					
				PreparedStatement st = con.prepareStatement(IQueryMapper.INS_CONT_QRY);){
				st.setInt(1, (int)subject.getSubjectId());
				st.setString(2, subject.getSubtitle());
				st.setInt(3, subject.getDurationInHours());
				
				st.executeUpdate();
			}catch(SQLException | ClassNotFoundException e){
				throw new SubjectException(
						"Insertion failed! Error: " + e.getMessage());
			}
		}
		return subject;
	}

	@Override
	public Subject findByBid(Long bid) throws SubjectException {
Subject subject = null;
		
		try(Connection con = ConnectionProvider.getInstance().getConnection();
				
			PreparedStatement st = con.prepareStatement(IQueryMapper.SEL_CONT_BY_MNO_QRY);){
			long d =Long.valueOf(bid);
			st.setInt(1,(int)d);
			ResultSet rs = st.executeQuery();
			
			if(rs.next()){
				subject = new  Subject();
				subject.setSubjectId(rs.getInt(1));
				subject.setSubtitle(rs.getString(2));
				subject.setDurationInHours(rs.getInt(3));
			}
			
			
			
			
			}catch(SQLException | ClassNotFoundException e){
				throw new SubjectException(
						"Retrieval failed! Error: " + e.getMessage());
			}
		
		return subject;
	}
	
	
	
	@Override
	public List<Subject> orderByDuration() throws SubjectException {
		// TODO Auto-generated method stub
		List<Subject> list = new ArrayList<>();
		
		try(Connection con = ConnectionProvider.getInstance().getConnection();
				
			PreparedStatement st = con.prepareStatement(IQueryMapper.SEL_ALL_SUB_QUERY_ORD_BY_HRS);){
				
			ResultSet rs = st.executeQuery();
			
			while(rs.next()){
				
				Subject subject = new Subject();
				subject.setSubjectId(rs.getInt(1));
				subject.setSubtitle(rs.getString(2));
				subject.setDurationInHours(rs.getInt(3));
				list.add(subject);
				
			}
			
			}catch(SQLException | ClassNotFoundException e){
				throw new SubjectException(
						"Retreival failed! Error: " + e.getMessage());
			}
		return list;
	}
	@Override
	public List<Subject> orderById() throws SubjectException {
		// TODO Auto-generated method stub
		List<Subject> list = new ArrayList<>();
		
		try(Connection con = ConnectionProvider.getInstance().getConnection();
				
			PreparedStatement st = con.prepareStatement(IQueryMapper.SEL_ALL_SUB_QUERY_ORD_BY_ID);){
				
			ResultSet rs = st.executeQuery();
			
			while(rs.next()){
				
				Subject subject = new Subject();
				subject.setSubjectId(rs.getInt(1));
				subject.setSubtitle(rs.getString(2));
				subject.setDurationInHours(rs.getInt(3));
				list.add(subject);
				
			}
			
			}catch(SQLException | ClassNotFoundException e){
				throw new SubjectException(
						"Retreival failed! Error: " + e.getMessage());
			}
		return list;
	}
	@Override
	public List<Subject> orderBySubtitle() throws SubjectException {
		// TODO Auto-generated method stub
		List<Subject> list = new ArrayList<>();
		
		try(Connection con = ConnectionProvider.getInstance().getConnection();
				
			PreparedStatement st = con.prepareStatement(IQueryMapper.SEL_ALL_SUB_QUERY_ORD_BY_NAME);){
				
			ResultSet rs = st.executeQuery();
			
			while(rs.next()){
				
				Subject subject = new Subject();
				subject.setSubjectId(rs.getInt(1));
				subject.setSubtitle(rs.getString(2));
				subject.setDurationInHours(rs.getInt(3));
				list.add(subject);
				
			}
			
			}catch(SQLException | ClassNotFoundException e){
				throw new SubjectException(
						"Retreival failed! Error: " + e.getMessage());
			}
		return list;
	}
	@Override
	public boolean deleteContact(Long bid) throws SubjectException {
		// TODO Auto-generated method stub
		boolean isDeleted = false;
		try(Connection con = ConnectionProvider.getInstance().getConnection();
				
				PreparedStatement st = con.prepareStatement(IQueryMapper.DEL_CONT_QRY);){
					long c = Long.valueOf(bid);
				st.setInt(1, (int)c);
				int count = st.executeUpdate();
				
				if(count==0)
					isDeleted = false;
				else
					isDeleted = true;
				
				}catch(SQLException | ClassNotFoundException e){
					throw new SubjectException(
							"Deletion failed! Error: " + e.getMessage());
				}
			return isDeleted;
	}


	@Override
	public List<Subject> getAllContacts() throws SubjectException {
		List<Subject> list = new ArrayList<>();
		
		try(Connection con = ConnectionProvider.getInstance().getConnection();
				
			PreparedStatement st = con.prepareStatement(IQueryMapper.SET_ALL_CONT_ID);){
				
			ResultSet rs = st.executeQuery();
			
			while(rs.next()){
				
				Subject subject = new Subject();
				subject.setSubjectId(rs.getInt(1));
				subject.setSubtitle(rs.getString(2));
				subject.setDurationInHours(rs.getInt(3));
				list.add(subject);
				
			}
			
			}catch(SQLException | ClassNotFoundException e){
				throw new SubjectException(
						"Retreival failed! Error: " + e.getMessage());
			}
		return list;
	}





}