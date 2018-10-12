package com.verizon.adb.util;

import java.util.Comparator;

import com.verizon.adb.model.Subject;

public class BookIdComparator implements Comparator<Subject> {

	@Override
	public int compare(Subject o1, Subject o2) {
		// TODO Auto-generated method stub
		Long p1 = o1.getSubjectId();
		Long p2 = o2.getSubjectId();
		return p1.compareTo(p2);
	}

}
