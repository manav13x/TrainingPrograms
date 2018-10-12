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

import com.verizon.adb.model.Contact;

public class ContactEntryScreen extends JDialog {

		Contact contact;
		boolean shallSave= false;
		JLabel lMobile,lName,lEmail;
		JTextField tMobile,tName,tEmail;
		JButton btnSave,btnCancel;;
		
		public ContactEntryScreen(JFrame parent,Contact contact)
		{
			super(parent,true);
			
			this.contact=contact;
		setLayout(null);
		lMobile = new JLabel("Mobile");
		lName= new JLabel("Name");
		lEmail=new JLabel("Email");
		
		tMobile = new JTextField();
		tName=new JTextField();
		tEmail = new JTextField();
		
		btnCancel = new JButton("Cancel");
		btnSave = new JButton("Save");
		add(this,lMobile,20,20,100,25);
		add(this,tMobile,125,20,100,25);
		add(this,lName,20,50,100,25);
		add(this,tName,125,50,200,25);
		add(this,lEmail,20,80,100,25);
		add(this,tEmail,125,80,200,25);
		add(this,btnSave,140,120,80,25);
		add(this,btnCancel,255,120,80,25);
		
			if(contact==null){
					contact=new Contact();
					setTitle("Add New Contact");
			}
			else
			{
				setTitle("Edit Contact");
				tMobile.setEditable(false);
				
				tMobile.setText(contact.getMobileNumber());
				tName.setText(contact.getName());
				tEmail.setText(contact.getEmail());
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
			contact = new Contact();
			contact.setMobileNumber(tMobile.getText());
			contact.setName(tName.getText());
			contact.setEmail(tEmail.getText());
			shallSave=true;
			dispose();
		}
	}
