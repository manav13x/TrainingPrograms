package com.verizon.adb.dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.verizon.adb.exception.AddressBookException;
import com.verizon.adb.model.Contact;

public class ContactFileBasedDao implements IContactDao{

	/*
	 * Mobile number will be key for easy search
	 * and entire contact related to it will be value
	 * */
	public static final String  DATA_STORE = "addressBook.data";

	private Map<String,Contact> contacts;

	public ContactFileBasedDao(){
		boolean isLoaded = loadData();
		if(!isLoaded){
			contacts =  new TreeMap<String,Contact>();		
			}
	}
	private boolean loadData() {
		boolean isLoaded = false;
		try(ObjectInputStream fin = 
				new ObjectInputStream(new FileInputStream(DATA_STORE));){
		Object obj =  fin.readObject();
		if(obj instanceof Map){
			contacts = (Map<String,Contact>)obj;
			}
		}catch(IOException | ClassNotFoundException e){
			isLoaded = false;
		}
		return isLoaded;
	}
	
	private void saveData() throws AddressBookException{
		try(ObjectOutputStream out  = new  ObjectOutputStream(
				new FileOutputStream(DATA_STORE));){
			out.writeObject(contacts);
		}catch (IOException e){
			throw new AddressBookException("this is exception");
		}
		
	}
	@Override
	public Contact add(Contact contact) throws AddressBookException {
		if(contact!=null)
		{
			contacts.put(contact.getMobileNumber(),contact);
			saveData();
		}
		return contact;
	}

	@Override
	public Contact findByMobileNumber(String MobileNumber) throws AddressBookException {
		// TODO Auto-generated method stub
		return contacts.get(MobileNumber);
	}

	@Override
	public Contact update(Contact contact) throws AddressBookException {
		// TODO Auto-generated method stub
		contacts.replace(contact.getMobileNumber(), contact);
		saveData();
		return contact;
	}

	@Override
	public List<Contact> getAllContacts() throws AddressBookException {
		// TODO Auto-generated method stub

		return new ArrayList<Contact>(contacts.values());
	}

	@Override
	public boolean deleteContact(String mobileNumber) throws AddressBookException {
		// TODO Auto-generated method stub
		boolean isDeleted =  false;
		if(contacts.containsKey(mobileNumber)){
			contacts.remove(mobileNumber);
			saveData();
			isDeleted = false;
		}
		return isDeleted;
	}


}
