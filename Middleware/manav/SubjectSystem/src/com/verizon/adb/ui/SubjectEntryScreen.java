package com.verizon.adb.ui;


import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.verizon.adb.model.Subject;

public class SubjectEntryScreen extends JDialog {

		Subject contact;
		boolean shallSave= false;
		JLabel lId,lTitle,lDuration;
		JTextField tId,tTitle,tDuration;
		JButton btnSave,btnCancel;;
		
		public SubjectEntryScreen(JFrame parent,Subject contact)
		{
			super(parent,true);
			
			this.contact=contact;
		setLayout(null);
		lId = new JLabel("Id");
		lTitle= new JLabel("Title");
		lDuration=new JLabel("Duration");
		
		tId = new JTextField();
		tTitle=new JTextField();
		tDuration = new JTextField();
		
		btnCancel = new JButton("Cancel");
		btnSave = new JButton("Save");
		add(this,lId,20,20,100,25);
		add(this,tId,125,20,100,25);
		add(this,lTitle,20,50,100,25);
		add(this,tTitle,125,50,200,25);
		add(this,lDuration,20,80,100,25);
		add(this,tDuration,125,80,200,25);
		add(this,btnSave,140,120,80,25);
		add(this,btnCancel,255,120,80,25);
		
			if(contact==null){
					contact=new Subject();
					setTitle("Add New Subjectt");
			}
			else
			{
				setTitle("Edit Subject");
				tId.setEditable(false);
				
				tId.setText(contact.getSubjectId()+"");
				tTitle.setText(contact.getSubtitle());
				tDuration.setText(contact.getDurationInHours()+"");
			}
			
			btnCancel.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					shallSave=false;
					dispose();
				}
			});
		
			btnSave.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					sendContact();
				}
			});
			
			setBounds(35,35,400,200);
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		}
		
		
		public void add(Container ct,Component cmp,int x,int y, int w,int h)
		{
			cmp.setBounds(x,y,w,h);
			ct.add(cmp);
		}
		private void sendContact() {
			contact = new Subject();
			contact.setSubjectId(new Long((long)Integer.parseInt(tId.getText())));
			contact.setSubtitle(tTitle.getText());
			contact.setDurationInHours(Integer.parseInt(tDuration.getText()));
			shallSave=true;
			dispose();
		}
	}
