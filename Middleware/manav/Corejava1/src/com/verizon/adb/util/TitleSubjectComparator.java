package com.verizon.adb.util;

import java.util.Comparator;

import com.verizon.adb.model.Subject;

public class TitleSubjectComparator implements Comparator<Subject>{

	@Override
	public int compare(Subject o1, Subject o2) {
		// TODO Auto-generated method stub
		String s1 = o1.getSubtitle();
		String s2 = o2.getSubtitle();
		return s1.compareTo(s2);
	}

}
