package com.verizon.iod.ui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import com.verizon.iod.model.Employee;

public class GetEmployee {

	public static void main(String[] args) {
		final String DATA_FOLDER_PATH = "./data/";
		Scanner scan = new Scanner(System.in);
		int empId = scan.nextInt();

		String fnm = "emp#" + empId + ".dat";
		String filePath = DATA_FOLDER_PATH + fnm;

		try (ObjectInputStream fin = new ObjectInputStream(new FileInputStream(
				filePath));) {
			Object obj = fin.readObject();

			if (obj instanceof Employee) {
				Employee emp = (Employee) obj;
				System.out.println(emp);
			} else {
				System.err.println("Invalid Data Found");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		scan.close();
	}
}
