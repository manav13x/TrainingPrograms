package com.verizon.iod.ui;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import com.verizon.iod.model.Employee;

public class SaveEmployee {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		final String DATA_FOLDER_PATH = "./data/";

		Employee emp = new Employee();

		System.out.println("Employee ID? ");
		emp.setEmpId((int) scan.nextDouble());
		System.out.println("Basic? ");
		emp.setBasic(scan.nextDouble());
		System.out.println("Name? ");
		emp.setName(scan.next());

		String fnm = "emp#" + emp.getEmpId() + ".dat";
		String filePath = DATA_FOLDER_PATH + fnm;

		try (ObjectOutputStream fout = new ObjectOutputStream(
				new FileOutputStream(filePath));) {

			fout.writeObject(emp);
			System.out.println("Object saved");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		scan.close();
	}
}
