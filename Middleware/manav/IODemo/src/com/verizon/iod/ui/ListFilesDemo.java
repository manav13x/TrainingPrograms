package com.verizon.iod.ui;

import java.io.File;
import java.util.Scanner;

public class ListFilesDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter the folder path");
		
		String path = scan.next();
		File file = new File(path);
		if(!file.exists()){
			System.err.println("The path is not found");
			System.exit(0);
		}
		if(file .isFile())
		{
			System.err.println("Found File Expecting Folder");
			System.exit(0);
		}
		
		File files[]=file.listFiles();
		
		System.out.println("Size \t CanRead\t CanWrite\tName");
		for(File f : files){
			System.out.println(f.length()+"\t"+f.canRead()+"\t"+f.canWrite()+"\t"+
		    (f.isDirectory()?"DIR":"Fil")+"\t"
					+f.getName());
			scan.close();
		}
	}

}
