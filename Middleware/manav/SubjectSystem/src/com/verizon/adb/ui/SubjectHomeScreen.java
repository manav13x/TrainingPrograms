package com.verizon.adb.ui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.verizon.adb.exception.SubjectException;
import com.verizon.adb.model.Subject;
import com.verizon.adb.service.ContactServiceImpl;
import com.verizon.adb.service.IContactService;

public class SubjectHomeScreen extends JFrame {
	JMenuBar menuBar;

	JTable table;
	DefaultTableModel model;

	IContactService contactService;

	public SubjectHomeScreen() {

		contactService = new ContactServiceImpl();
		createMenuBar();
		model = new DefaultTableModel(new String[] { "SubjectID", "Title", "Duration" }, 0);
		table = new JTable(model);

		table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);

		add(new JScrollPane(table));

		
		loadData();
		
		setTitle("Subject Model");
		int height = 500;
		int width = 500;
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((int) (dim.getWidth() - width) / 2, ((int) dim.getHeight() - height) / 2, width, height);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void loadData() {
		// TODO Auto-generated method stub
		try{
			List<Subject> contactList = contactService.getAllContacts();
			model.setRowCount(0);//remove all data before loading
			
			for(Subject c:contactList){
				Object[] row = new Object[3];
				row[0]=c.getSubjectId();
				row[1]=c.getSubtitle();
				row[2]=c.getDurationInHours();
				model.addRow(row);
			}
		
		
		}catch(SubjectException e){
		JOptionPane.showMessageDialog(this, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
	}
		}

	private void createMenuBar() {
		HomeScreenActionAdapter adp = new HomeScreenActionAdapter();
		menuBar = new JMenuBar();
		JMenu mnFile = menuBar.add(new JMenu("File"));
		JMenu mnView = menuBar.add(new JMenu("View"));
		mnFile.setMnemonic('F');
		mnFile.setMnemonic('V');

		setJMenuBar(menuBar);
		JMenuItem m1 = mnFile.add("New Subject");
		m1.setMnemonic('N');
		m1.addActionListener(adp);

		JMenuItem m2 = mnFile.add("Search");
		m2.setMnemonic('S');
		m2.addActionListener(adp);
/*
		JMenuItem m3 = mnFile.add("Edit");
		m3.setMnemonic('E');
		m3.addActionListener(adp);*/

		JMenuItem m4 = mnFile.add("Delete");
		m4.setMnemonic('D');
		m4.addActionListener(adp);
		mnFile.addSeparator();

		JMenuItem m5 = mnFile.add("Exit");
		m5.setMnemonic('X');
		m5.addActionListener(adp);

		JMenu mnSort = (JMenu) mnView.add(new JMenu("Sort"));
		JMenuItem m6 = mnSort.add("By Id");
		m6.addActionListener(adp);

		JMenuItem m7 = mnSort.add("By Subtitle");
		m7.addActionListener(adp);

		JMenuItem m8 = mnSort.add("By Duration");
		m8.addActionListener(adp);

	}

	class HomeScreenActionAdapter implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			String cmd = event.getActionCommand();
			switch (cmd) {
			case "New Subject":
					doNewContact();
					break;
			case "Search":
				doSearchContact();
				    break;
			case	"Delete":
					doDeleteContact();
				    break;
			case "By Id":
						doSortId();
						break;
			case "By Subtitle":
						doSortTitle();
						break;
			case "By Duration":
						doSortDuration();
						break;
			case "Exit":
				dispose();
				break;
			default:
				JOptionPane.showMessageDialog(null, event.getActionCommand() + "Not Implemented ");
			}
		}	
	}
	private void doNewContact() {
		
	SubjectEntryScreen entryScreen = new SubjectEntryScreen(this,null);
		entryScreen.setVisible(true);
		if(entryScreen.shallSave){
			try {
				contactService.add(entryScreen.contact); loadData();
			} catch (SubjectException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(this, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}

	public void doSortDuration() {
		// TODO Auto-generated method stub
		try{
			List<Subject> contactList=contactService.orderByDuration();
			model.setRowCount(0);//remove all data before loading
			
			for(Subject c:contactList){
				Object[] row = new Object[3];
				row[0]=c.getSubjectId();
				row[1]=c.getSubtitle();
				row[2]=c.getDurationInHours();
				model.addRow(row);
			}
		
		
		}catch(SubjectException e){
		JOptionPane.showMessageDialog(this, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
	}	
}

	public void doSortTitle() {
		// TODO Auto-generated method stub
		try{
			List<Subject> contactList=contactService.orderBySubtitle();
			model.setRowCount(0);//remove all data before loading
			
			for(Subject c:contactList){
				Object[] row = new Object[3];
				row[0]=c.getSubjectId();
				row[1]=c.getSubtitle();
				row[2]=c.getDurationInHours();
				model.addRow(row);
			}
		
		
		}catch(SubjectException e){
		JOptionPane.showMessageDialog(this, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
	}	
	}

	public void doSortId() {
		// TODO Auto-generated method stub
		try{
			List<Subject> contactList=contactService.orderById();
			model.setRowCount(0);//remove all data before loading
			
			for(Subject c:contactList){
				Object[] row = new Object[3];
				row[0]=c.getSubjectId();
				row[1]=c.getSubtitle();
				row[2]=c.getDurationInHours();
				model.addRow(row);
			}
		
		
		}catch(SubjectException e){
		JOptionPane.showMessageDialog(this, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
	}	
	}

	public void doSearchContact() {
		// TODO Auto-generated method stub
		String bid = 
				JOptionPane.showInputDialog(this,"Enter Existing Subject Id");
	Long l =	new Long((long)Integer.parseInt(bid));
	try{
		Subject contact = contactService.findByBid(l);
		
		if(contact ==  null)
			{JOptionPane.showMessageDialog(this, "Subjectt does not exist","Access Denied",JOptionPane.INFORMATION_MESSAGE);
			}
			else{
				JOptionPane.showMessageDialog(this, contact,"Subject found",JOptionPane.INFORMATION_MESSAGE);
			}
	}catch(SubjectException e)
	{
		JOptionPane.showMessageDialog(this, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
	}
			
	
	}

	public void doDeleteContact() {
		// TODO Auto-generated method stub
		String bid = 
				JOptionPane.showInputDialog(this,"Enter the Existing Subject ID");
		Long l =	new Long((long)Integer.parseInt(bid));
	
		try {
			boolean	isDeleted=contactService.deleteContact(l);
			if(isDeleted)
				loadData();
			else
				JOptionPane.showMessageDialog(this, "Subject does not exist","Access Denied",JOptionPane.INFORMATION_MESSAGE);
		} catch (SubjectException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
		}
	}
/*
	public void doEditContact() {
		// TODO Auto-generated method stub
		String bid = 
				JOptionPane.showInputDialog(this,"Enter The Existing Subject Id");
		Long l =	new Long((long)Integer.parseInt(bid));
	try{
		Subject contact = contactService.findByBid(l);
		
		if(contact ==  null)
			{JOptionPane.showMessageDialog(this, "Contact does not exist","Access Denied",JOptionPane.INFORMATION_MESSAGE);
			}
			else{
			SubjectEntryScreen entryScreen = new SubjectEntryScreen(this,contact);
				entryScreen.setVisible(true);
				if(entryScreen.shallSave){
					contactService.update(entryScreen.contact);
					loadData();
				}
			}
	}catch(SubjectException e)
	{
		JOptionPane.showMessageDialog(this, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
	}
			
	
	}*/
}
