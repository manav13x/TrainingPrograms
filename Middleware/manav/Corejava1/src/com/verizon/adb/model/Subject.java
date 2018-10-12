package com.verizon.adb.model;

import java.io.Serializable;
public class Subject implements Comparable<Subject>,Serializable {

	private long subjectId;
	private String subtitle;
	private int durationInHours;
	public long getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}
	public String getSubtitle() {
		return subtitle;
	}
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}
	public int getDurationInHours() {
		return durationInHours;
	}
	public void setDurationInHours(int durationInHours) {
		this.durationInHours = durationInHours;
	}
	public Subject(long subjectId, String subtitle, int durationInHours) {
		super();
		this.subjectId = subjectId;
		this.subtitle = subtitle;
		this.durationInHours = durationInHours;
	}
	public Subject() {
		super();
	}
	@Override
	public String toString() {
		return "Subject [subjectId=" + subjectId + ", subtitle=" + subtitle + ", durationInHours=" + durationInHours
				+ "]";
	}
	@Override
	public int compareTo(Subject o) {
		// TODO Auto-generated method stub
		Long o1 = this.subjectId;
		Long o2 = o.subjectId;
		return o1.compareTo(o2);
	}
	
	
}