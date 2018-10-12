package com.verizon.adb.service;

import java.util.List;

import com.verizon.adb.exception.AddressBookException;
import com.verizon.adb.model.Contact;

public interface IContactService {
	boolean isValid(Contact contact) throws AddressBookException;
 Contact add(Contact contact) throws AddressBookException;
 Contact findByMobileNumber(String MobileNumber) throws AddressBookException;
 Contact update(Contact contact)throws AddressBookException;
 List<Contact> getAllCOntacts() throws AddressBookException;
 boolean deleteContact(String mobileNumber) throws AddressBookException;
	
}
