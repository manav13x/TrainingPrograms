package com.verizon.adb.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.verizon.adb.exception.AddressBookException;
import com.verizon.adb.model.Contact;
import com.verizon.adb.util.ConnectionProvider;

public class ContactDaoJDBCImpl implements IContactDao {

	public ContactDaoJDBCImpl(){
		//default constructor
	}
	

	@Override
	public Contact add(Contact contact) throws AddressBookException {
		if(contact!=null){
			try(Connection con = ConnectionProvider.getInstance().getConnection();
					
				PreparedStatement st = con.prepareStatement(IQueryMapper.INS_CONT_QRY);){
				st.setString(1, contact.getMobileNumber());
				st.setString(2, contact.getName());
				st.setString(3, contact.getEmail());
				
				st.executeUpdate();
			}catch(SQLException | ClassNotFoundException e){
				throw new AddressBookException(
						"Insertion failed! Error: " + e.getMessage());
			}
		}
		return contact;
	}

	@Override
	public Contact findByMobileNumber(String mobileNumber) throws AddressBookException {
		Contact contact = null;
		
		try(Connection con = ConnectionProvider.getInstance().getConnection();
				
			PreparedStatement st = con.prepareStatement(IQueryMapper.SEL_CONT_BY_MNO_QRY);){
			
			st.setString(1, mobileNumber);
			ResultSet rs = st.executeQuery();
			
			if(rs.next()){
				contact = new Contact();
				contact.setMobileNumber(rs.getString(1));
				contact.setName(rs.getString(2));
				contact.setEmail(rs.getString(3));
			}
			
			
			
			
			}catch(SQLException | ClassNotFoundException e){
				throw new AddressBookException(
						"Retrieval failed! Error: " + e.getMessage());
			}
		
		return contact;
		
	}

	@Override
	public Contact update(Contact contact) throws AddressBookException {
		if(contact!=null){
			try(Connection con = ConnectionProvider.getInstance().getConnection();
					
				PreparedStatement st = con.prepareStatement(IQueryMapper.UPD_CONT_QRY);){
				
				st.setString(1, contact.getName());
				st.setString(2, contact.getEmail());
				st.setString(3, contact.getMobileNumber());
				
				st.executeUpdate();
			}catch(SQLException | ClassNotFoundException e){
				throw new AddressBookException(
						"Updation failed! Error: " + e.getMessage());
			}
		}
		return contact;
	}

	@Override
	public List<Contact> getAllContacts() throws AddressBookException {
		List<Contact> list = new ArrayList<>();
		
		try(Connection con = ConnectionProvider.getInstance().getConnection();
				
			PreparedStatement st = con.prepareStatement(IQueryMapper.SET_ALL_CONT_QRY);){
				
			ResultSet rs = st.executeQuery();
			
			while(rs.next()){
				
				Contact contact = new Contact();
				contact.setMobileNumber(rs.getString(1));
				contact.setName(rs.getString(2));
				contact.setEmail(rs.getString(3));
				list.add(contact);
				
			}
			
			}catch(SQLException | ClassNotFoundException e){
				throw new AddressBookException(
						"Retreival failed! Error: " + e.getMessage());
			}
		return list;
	}

	@Override
	public boolean deleteContact(String mobileNumber) throws AddressBookException {
		
		boolean isDeleted = false;
		
		
		try(Connection con = ConnectionProvider.getInstance().getConnection();
				
			PreparedStatement st = con.prepareStatement(IQueryMapper.DEL_CONT_QRY);){
				
			st.setString(1, mobileNumber);
			int count = st.executeUpdate();
			
			if(count==0)
				isDeleted = false;
			else
				isDeleted = true;
			
			}catch(SQLException | ClassNotFoundException e){
				throw new AddressBookException(
						"Deletion failed! Error: " + e.getMessage());
			}
		return isDeleted;
		
	}

}