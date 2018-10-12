package com.verizon.adb.ui;

import java.util.List;
import java.util.Scanner;

import com.verizon.adb.exception.AddressBookException;
import com.verizon.adb.model.Contact;
import com.verizon.adb.service.ContactServiceImpl;
import com.verizon.adb.service.IContactService;
import com.verizon.adb.ui.AddressBookHomeScreen;
public class ContactBookApp {

public static void main(String args[])
	{
	AddressBookHomeScreen screen = new AddressBookHomeScreen();
	screen.setVisible(true);
	}
}