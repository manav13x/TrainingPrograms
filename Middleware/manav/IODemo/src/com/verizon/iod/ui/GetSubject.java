package com.verizon.iod.ui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import com.version.io.model.Subject;

public class GetSubject {

	final String DATA_FOLDER_PATH = "./data/";
	Subject sb = new Subject();String fpath;
	final File folder = new File(DATA_FOLDER_PATH);
	public void listFilesForFolder()
	{
		
	    for (final File fileEntry : folder.listFiles()) {
	            fpath=DATA_FOLDER_PATH + fileEntry.getName();
	    		try (ObjectInputStream fin = new ObjectInputStream(new FileInputStream(
	    				fpath));) {
	    			Object obj = fin.readObject();

	    			if (obj instanceof Subject) {
	    				Subject sbe = (Subject) obj;
	    				SaveSubject.set3.add(sbe);
	    				SaveSubject.set4.add(sbe);
	    				SaveSubject.set5.add(sbe);
	    			}
	            
	        }catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
	    }
	}
	public void delete_and_retrieve(long sid,boolean ch){
		
		String fnm = "sub#" + sid + ".dat";
		String filePath = DATA_FOLDER_PATH + fnm;
		try (ObjectInputStream fin = new ObjectInputStream(new FileInputStream(
				filePath));) {
			Object obj = fin.readObject();

			if (obj instanceof Subject) {
				Subject sbe = (Subject) obj;
				System.out.println("Object Found Succesfully");
				System.out.println(sbe);
				if(ch){
				SaveSubject.set3.remove(obj);
				SaveSubject.set4.remove(obj);
				SaveSubject.set5.remove(obj);
				sbe = null;
				File file = new File(filePath);
				if(file.delete())	
				System.out.println("Object Deleted Succesfully");
				}
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
		
	}//end of delete_subject
	
	
}