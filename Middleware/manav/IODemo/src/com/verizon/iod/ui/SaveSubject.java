package com.verizon.iod.ui;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Set;
import java.util.TreeSet;

import com.verizon.util.DurationSubjectComparator;
import com.verizon.util.TitleSubjectComparator;
import com.version.io.model.Subject;

public class SaveSubject {

	final String DATA_FOLDER_PATH = "./data/";
	Subject sb = new Subject();
	static Set<Subject> set3 = new TreeSet<>();
	static Set<Subject> set4 = new TreeSet<>(new DurationSubjectComparator());
	
	static Set<Subject> set5 = new TreeSet<>(new TitleSubjectComparator());
	
	public void saveData(long sid,String tit,int dur){
		sb.setSubjectId(sid);
		sb.setSubtitle(tit);
		sb.setDurationInHours(dur);
	
		
		String fnm = "sub#" + sb.getSubjectId() + ".dat";
		String filePath = DATA_FOLDER_PATH + fnm;
		
		try (ObjectOutputStream fout = new ObjectOutputStream(
				new FileOutputStream(filePath));) {

			fout.writeObject(sb);
			//set3.add(sb);set4.add(sb);set5.add(sb);
			//Add objects to set as well
			System.out.println("Object saved");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}