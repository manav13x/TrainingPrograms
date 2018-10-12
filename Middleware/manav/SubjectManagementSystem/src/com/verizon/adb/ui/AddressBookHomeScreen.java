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

import com.verizon.adb.exception.AddressBookException;
import com.verizon.adb.model.Contact;
import com.verizon.adb.service.ContactServiceImpl;
import com.verizon.adb.service.IContactService;

public class AddressBookHomeScreen extends JFrame {
	JMenuBar menuBar;

	JTable table;
	DefaultTableModel model;

	IContactService contactService;

	public AddressBookHomeScreen() {

		contactService = new ContactServiceImpl();
		createMenuBar();
		model = new DefaultTableModel(new String[] { "Mobile", "Name", "Email" }, 0);
		table = new JTable(model);

		table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);

		add(new JScrollPane(table));

		
		loadData();
		
		setTitle("Address Book 2.0");
		int height = 500;
		int width = 500;
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((int) (dim.getWidth() - width) / 2, ((int) dim.getHeight() - height) / 2, width, height);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void loadData() {
		// TODO Auto-generated method stub
		try{
			List<Contact> contactList = contactService.getAllCOntacts();
			model.setRowCount(0);//remove all data before loading
			
			for(Contact c:contactList){
				Object[] row = new Object[3];
				row[0]=c.getMobileNumber();
				row[1]=c.getName();
				row[2]=c.getEmail();
				model.addRow(row);
			}
		
		
		}catch(AddressBookException e){
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
		JMenuItem m1 = mnFile.add("New Contact");
		m1.setMnemonic('N');
		m1.addActionListener(adp);

		JMenuItem m2 = mnFile.add("Search");
		m2.setMnemonic('S');
		m2.addActionListener(adp);

		JMenuItem m3 = mnFile.add("Edit");
		m3.setMnemonic('E');
		m3.addActionListener(adp);

		JMenuItem m4 = mnFile.add("Delete");
		m4.setMnemonic('D');
		m4.addActionListener(adp);
		mnFile.addSeparator();

		JMenuItem m5 = mnFile.add("Exit");
		m5.setMnemonic('X');
		m5.addActionListener(adp);

		JMenu mnSort = (JMenu) mnView.add(new JMenu("Sort"));
		JMenuItem m6 = mnSort.add("ByName");
		m6.addActionListener(adp);

		JMenuItem m7 = mnSort.add("ByMail");
		m7.addActionListener(adp);

		JMenuItem m8 = mnSort.add("ByMonile");
		m8.addActionListener(adp);

	}

	class HomeScreenActionAdapter implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			String cmd = event.getActionCommand();
			switch (cmd) {
			case "New Contact":
					doNewContact();
					break;
			case "Edit":
				    doEditContact();
				    break;
			case	"Delete":
					doDeleteContact();
				    break;
			case "Search":
						doSearchContact();
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
		
		ContactEntryScreen entryScreen = new ContactEntryScreen(this,null);
		entryScreen.setVisible(true);
		if(entryScreen.shallSave){
			try {
				contactService.add(entryScreen.contact); loadData();
			} catch (AddressBookException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(this, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}

	public void doSearchContact() {
		// TODO Auto-generated method stub
		String mobileNumber = 
				JOptionPane.showInputDialog(this,"enter Existing mobile no");
	try{
		Contact contact = contactService.findByMobileNumber(mobileNumber);
		
		if(contact ==  null)
			{JOptionPane.showMessageDialog(this, "Contact does not exist","Access Denied",JOptionPane.INFORMATION_MESSAGE);
			}
			else{
				JOptionPane.showMessageDialog(this, contact,"Contact found",JOptionPane.INFORMATION_MESSAGE);
			}
	}catch(AddressBookException e)
	{
		JOptionPane.showMessageDialog(this, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
	}
			
	
	}

	public void doDeleteContact() {
		// TODO Auto-generated method stub
		String mobileNumber = 
				JOptionPane.showInputDialog(this,"enter Existing mobile no");
	
		try {
			boolean	isDeleted=contactService.deleteContact(mobileNumber);
			if(isDeleted)
				loadData();
			else
				JOptionPane.showMessageDialog(this, "Contact does not exist","Access Denied",JOptionPane.INFORMATION_MESSAGE);
		} catch (AddressBookException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
		}
	}

	public void doEditContact() {
		// TODO Auto-generated method stub
		String mobileNumber = 
				JOptionPane.showInputDialog(this,"enter Existing mobile no");
	try{
		Contact contact = contactService.findByMobileNumber(mobileNumber);
		
		if(contact ==  null)
			{JOptionPane.showMessageDialog(this, "Contact does not exist","Access Denied",JOptionPane.INFORMATION_MESSAGE);
			}
			else{
				ContactEntryScreen entryScreen = new ContactEntryScreen(this,contact);
				entryScreen.setVisible(true);
				if(entryScreen.shallSave){
					contactService.update(entryScreen.contact);
					loadData();
				}
			}
	}catch(AddressBookException e)
	{
		JOptionPane.showMessageDialog(this, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
	}
			
	
	}
}
