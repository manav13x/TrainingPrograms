package com.verizon.adb.service;

import java.util.List;

import com.verizon.adb.dao.ContactDaoJDBCImpl;
import com.verizon.adb.dao.ContactFileBasedDao;
import com.verizon.adb.dao.IContactDao;
import com.verizon.adb.exception.AddressBookException;
import com.verizon.adb.model.Contact;

public class ContactServiceImpl implements IContactService {

	
	private IContactDao contactDao = null;
	public ContactServiceImpl()
	{
		//contactDao = new ContactFileBasedDao();
		contactDao = new ContactDaoJDBCImpl();
	}	
	
	private boolean isValidName(String name)
	{
		String nameRegEx = "[A-Z][A-Za-z]{3,14}";
		return name!=null && name.matches(nameRegEx);
	}
	
	private boolean isValidEmail(String email)
	{
		return email!=null&&email.contains("@");
	}
	private boolean isValidMobileNumber(String mobileNumber){
		
		String mobRegEx = "\\d{10}";
		return mobileNumber!=null && mobileNumber.matches(mobRegEx);
		}
	@Override
	public boolean isValid(Contact contact) throws AddressBookException {
		// TODO Auto-generated method stub
		boolean isValid = true;
		StringBuilder errs = new StringBuilder();
		if(!isValidMobileNumber(contact.getMobileNumber())){
			errs.append("\n Invalid mobile no more than 10 digits");
			isValid=false;
		}
		if(!isValidName(contact.getName())){
			errs.append("\n Name must be init caped and 4 to 15 chars");
			isValid=false;
		}
		if(!isValidEmail(contact.getEmail())){
			errs.append("\n invalid");
			isValid=false;
		}
		if(!isValid)
			throw new AddressBookException(errs.toString());
		return isValid;
	}

	@Override
	public Contact add(Contact contact) throws AddressBookException {
		// TODO Auto-generated method stub
		if(contact!=null&&isValid(contact))
		{
			//System.out.println("Adding Contact");
			contactDao.add(contact);
		}
		return contact;
	}

	@Override
	public Contact findByMobileNumber(String MobileNumber) throws AddressBookException {
		// TODO Auto-generated method stub
		return contactDao.findByMobileNumber(MobileNumber);
	}

	@Override
	public Contact update(Contact contact) throws AddressBookException {
		// TODO Auto-generated method stub
		if(contact!=null&&isValid(contact))
		{contactDao.update(contact);
			
		}
		return contact;
	}

	@Override
	public List<Contact> getAllCOntacts() throws AddressBookException {
		// TODO Auto-generated method stub
		return contactDao.getAllContacts();
	}

	@Override
	public boolean deleteContact(String mobileNumber) throws AddressBookException {
		// TODO Auto-generated method stub
		return contactDao.deleteContact(mobileNumber);
	}

}
