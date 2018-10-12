package com.verizon.iod.ui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class CopyFile{

	public static void main(String[] args) throws FileNotFoundException,IOException {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a file name1\n");
		
		String fnm1 = scan.next();
		System.out.println("Enter a file name2\n");
		String fnm2 = scan.next();
		
		File file1 = new File(fnm1);
		File file2 = new File(fnm2);
		BufferedReader fin = new BufferedReader(new InputStreamReader(new FileInputStream(file1))) ;
		
		PrintWriter fout = new PrintWriter(new FileOutputStream(file2,true),true);
		
		String line = "";
		while((line = fin.readLine())!=null)
		{
			fout.println(line);
		}
		System.out.println("Done");
		fout.close();
		scan.close();
		
	}
	
}