package com.verizon.iod.ui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import com.version.io.model.Emplyoee;

public class GetEmplyoee {

	public static void main(String[] args) {
		final String DATA_FOLDER_PATH = "./data/";
		Scanner scan = new Scanner(System.in);
		int empId = scan.nextInt();

		String fnm = "emp#" + empId + ".dat";
		String filePath = DATA_FOLDER_PATH + fnm;
//System.out.println(filePath);
		try (ObjectInputStream fin = new ObjectInputStream(new FileInputStream(
				filePath));) {
			Object obj = fin.readObject();

			if (obj instanceof Emplyoee) {
				Emplyoee emp = (Emplyoee) obj;
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