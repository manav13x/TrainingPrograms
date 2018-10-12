package com.verizon.iod.ui;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import com.verizon.util.DurationSubjectComparator;
import com.verizon.util.TitleSubjectComparator;
import com.version.io.model.Subject;

public class MainSubject {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean f = true;
		int ch;long sid;
		Scanner sc =new Scanner(System.in);
		Set<Subject> set = new TreeSet<>();
		Set<Subject> set1 = new TreeSet<>(new DurationSubjectComparator());
		Set<Subject> set2 = new TreeSet<>(new TitleSubjectComparator());
		Subject sub = null;
		while(f){
			System.out.println("Enter ur choice");
			System.out.println("press 1 to  Add a Subject");
			System.out.println("Press 2 to Delete a Subject");
			System.out.println(" Press 3 to Search a subject by ID");
			System.out.println(" Press 4 to Display subject list sorted in ID");
			System.out.println("Press 5 to Display subject list sorted in Duration");
			System.out.println("Press 6 to Display subject list sorted in Title");
			ch = sc.nextInt();
			switch(ch){
			case 1: System.out.println("Enter the Subject ID Title and Duration");
					sub = new Subject();
					sub.setSubjectId(sc.nextLong());
					sub.setSubtitle(sc.next());
					sub.setDurationInHours(sc.nextInt());
					set.add(sub);set1.add(sub);set2.add(sub);
					System.out.println("Subject Added Successfully");
					break;		
			case 2: System.out.println("Enter the id of subject to delete");
					sid = sc.nextLong();
					boolean flag = true;
					for(Subject s : set)
					{
						if(s.getSubjectId()==sid)
						{
							System.out.println("Found");
							set.remove((Object)s);
							set1.remove((Object)s);
							set2.remove((Object)s);
							flag = false;
							break;
						}
						
					}
					if(flag == true)
					{
						System.out.println("Subject Not Found");
					}
					else
					{
		
						System.out.println("Removed Successfully");
					}
					
					break;
					
			case 3: System.out.println("Enter the id of subject to retrieve");
					sid = sc.nextLong();
					boolean flag1 = true;
					for(Subject s : set)
					{
						if(s.getSubjectId()==sid)
						{
							System.out.println(s);
							flag1 = false;
							break;
						}
					}
					if(flag1==true)
					{
						System.out.println("Subject Not Found");
					}
					break;
			case 4: 
					for(Subject b : set)
						System.out.println(b);
					System.out.println("Sorted As Subject Id");
					break;
			case 5: 
					for(Subject b : set1)
				System.out.println(b);
			System.out.println("Sorted As Duration");
					break;
			case 6: 
					for(Subject b : set2)
					System.out.println(b);
					System.out.println("Sorted As Title");
					break;
			default:System.exit(0);
					break;		
					
			}
		}
		
	}

}