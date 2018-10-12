package com.verizon.gua.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

import com.verizon.gua.exception.UserValidationException;
import com.verizon.gua.model.Gender;
import com.verizon.gua.model.User;

public class UserServiceImpl implements IUserService {

	private boolean isValidUserName(String userName) {
		boolean isValid = true;

		if (userName.length() <5 ) {
			isValid = false;
		}
		return isValid;
	}

	private boolean isValidDateOfBirth(LocalDate dob) {
		boolean isValid = true;
		LocalDate today = LocalDate.now();
		if (today.isBefore(dob)) {
			isValid = false;
		}
		return isValid;
	}

	@Override
	public boolean isValidUser(User user) throws UserValidationException {

		boolean isValid = true;

		StringBuffer errMessage = new StringBuffer();

		if (!isValidUserName(user.getUsrName())) {
			isValid = false;
			errMessage.append("UserName cannot be blank");
			errMessage.append("UserName cannot be less than 5 characters in length");
		}

		if (!isValidDateOfBirth(user.getDatOfBirth())) {
			isValid = false;
			errMessage.append("Dob cannot be from the future");
		}
		if (!isValid) {
			throw new UserValidationException(errMessage.toString());
		}

		return isValid;
	}

	@Override
	public int getAge(LocalDate dob) {

		LocalDate now = LocalDate.now();
		Period p = Period.between(dob, now);
		return p.getYears();
	}

	@Override
	public String getTitle(User user) {
		String title = "Miss";

		if (user.getGender() == Gender.MALE) {
			if (user.getAge() < 18) {
				title = "Master";
			} else {
				title = "Mr";
			}
		} else if (user.getGender() == Gender.FEMALE) {
			if (user.getAge() < 18) {
				title = "Miss";
			} else {
				title = "Ms.";
			}
		}
		return title;
	}

	@Override
	public String getTimlyGreeting() {
		String greeting = "";
		int hour = LocalDateTime.now().getHour();
		if (hour >= 3 && hour <= 11) {
			greeting = "GoodMorning";
		} else if (hour >= 12 && hour <= 15) {
			greeting = "GoodNoon";
		} else if (hour >= 16 && hour <= 21) {
			greeting = "Good Evening";
		} else
			greeting = "Good Night";

		return greeting;
	}

}
