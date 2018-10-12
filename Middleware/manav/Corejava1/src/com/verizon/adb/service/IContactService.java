package com.verizon.adb.service;

import java.util.List;
import com.verizon.adb.exception.SubjectException;

import com.verizon.adb.model.Subject;

public interface IContactService {
	
 Subject add(Subject subject) throws SubjectException;
 boolean deleteContact(Long bid) throws SubjectException;
 Subject findByBid(Long bid) throws SubjectException;
 List<Subject> orderById() throws SubjectException;
 List<Subject> orderBySubtitle() throws SubjectException;
 List<Subject> orderByDuration() throws SubjectException;
}
