package com.verizon.gua.service;

import java.time.LocalDate;

import com.verizon.gua.exception.UserValidationException;
import com.verizon.gua.model.User;

public interface IUserService {

	boolean isValidUser(User user) throws UserValidationException;

	int getAge(LocalDate dob);

	String getTitle(User user);

	String getTimlyGreeting();

}
