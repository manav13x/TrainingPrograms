package com.verizon.util;

import java.util.Comparator;

import com.version.io.model.Subject;

public class DurationSubjectComparator implements Comparator<Subject> {

	@Override
	public int compare(Subject o1, Subject o2) {
		// TODO Auto-generated method stub
		Integer i1 = o1.getDurationInHours();
		Integer i2 = o2.getDurationInHours();
		return i1.compareTo(i2);
	}

}
