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


import com.verizon.adb.exception.SubjectException;

import com.verizon.adb.model.Subject;

public class ContactFileBasedDao implements SubjectDao{

	/*
	 * Mobile number will be key for easy search
	 * and entire contact related to it will be value
	 * */
	public static final String  DATA_STORE = "addressBook.data";

	private Map<String,Subject> subjects;

	public ContactFileBasedDao(){
		boolean isLoaded = loadData();
		if(!isLoaded){
			subjects =  new TreeMap<String,Subject>();		
			}
	}
	private boolean loadData() {
		boolean isLoaded = false;
		try(ObjectInputStream fin = 
				new ObjectInputStream(new FileInputStream(DATA_STORE));){
		Object obj =  fin.readObject();
		if(obj instanceof Map){
			subjects = (Map<String,Subject>)obj;
			}
		}catch(IOException | ClassNotFoundException e){
			isLoaded = false;
		}
		return isLoaded;
	}
	
	private void saveData() throws SubjectException{
		try(ObjectOutputStream out  = new  ObjectOutputStream(
				new FileOutputStream(DATA_STORE));){
			out.writeObject(subjects);
		}catch (IOException e){
			throw new SubjectException("this is exception");
		}
		
	}
	@Override
	public Subject add(Subject subject) throws SubjectException {
		if(subject!=null)
		{
			subjects.put(subject.getSubjectId()+"",subject);
			saveData();
		}
		return subject;
	}
	@Override
	public boolean deleteContact(Long bid) throws SubjectException {
		// TODO Auto-generated method stub
		boolean isDeleted =  false;
		
		if(subjects.containsKey(bid+"")){
			subjects.remove(bid+"");
			saveData();
			isDeleted = false;
			System.out.println("Deleting");
		}
		return isDeleted;
	}
	@Override
	public Subject findByBid(Long bid) throws SubjectException {
		// TODO Auto-generated method stub
		return subjects.get(bid+"");
	}
	/*0
	@Override
	public List<Subject> getAllCOntacts() throws SubjectException {
		// TODO Auto-generated method stub

		return new ArrayList<Subject>(subjects.values());
	}*/
	@Override
	public List<Subject> orderById() throws SubjectException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Subject> orderBySubtitle() throws SubjectException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Subject> orderByDuration() throws SubjectException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Subject> getAllContacts() throws SubjectException {
		// TODO Auto-generated method stub
		return null;
	}

}
