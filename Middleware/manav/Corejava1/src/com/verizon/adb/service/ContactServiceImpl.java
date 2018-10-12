package com.verizon.adb.service;

import java.util.List;

import com.verizon.adb.dao.ContactDaoJDBCImpl;
import com.verizon.adb.dao.ContactFileBasedDao;
import com.verizon.adb.dao.SubjectDao;

import com.verizon.adb.exception.SubjectException;

import com.verizon.adb.model.Subject;

public class ContactServiceImpl implements IContactService {

	
	private SubjectDao subjectDao = null;
	public ContactServiceImpl()
	{
		subjectDao = new ContactDaoJDBCImpl();
		//subjectDao = new ContactFileBasedDao();
	}	

	@Override
	public Subject add(Subject subject) throws SubjectException {
		// TODO Auto-generated method stub
			System.out.println("Adding Subject");
			subjectDao.add(subject);
		return subject;
	}

	@Override
	public Subject findByBid(Long bid) throws SubjectException {
		// TODO Auto-generated method stub
		return subjectDao.findByBid(bid);
	}

	@Override
	public boolean deleteContact(Long bid) throws SubjectException {
		// TODO Auto-generated method stub
		
		return subjectDao.deleteContact(bid);
	}
	
	public List<Subject> orderByDuration() throws SubjectException {
		// TODO Auto-generated method stub
		return subjectDao.orderByDuration();
	}

	public List<Subject> orderById() throws SubjectException {
		// TODO Auto-generated method stub
		return subjectDao.orderById();
	}

	public List<Subject> orderBySubtitle() throws SubjectException {
		// TODO Auto-generated method stub
		return subjectDao.orderBySubtitle();
	}


}
