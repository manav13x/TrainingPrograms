package com.verizon.iod.ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileWritingDemo {

	public static void main(String[] args) throws FileNotFoundException,IOException {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a file name\n");
		String fnm = scan.next();
		
		File file = new File(fnm);

		PrintWriter fout = new PrintWriter(new FileOutputStream(file,true),true);//piping
		
		
		//StringBuilder sb = new StringBuilder();
		System.out.print("Enter the file content <EOF> to stop");
		
		String line = "";
		while(!"<EOF>".equals(line))
		{
			line = scan.nextLine();
			//sb.append("\n"+line);
			fout.println(line);
		}
		//Binary Stream to copy
	//	FileOutputStream fout = new FileOutputStream(file,true);
//		fout.write(sb.toString().getBytes());
		fout.close();
			System.out.println("saved as "+fnm);
		scan.close();
		
		
	}

}
