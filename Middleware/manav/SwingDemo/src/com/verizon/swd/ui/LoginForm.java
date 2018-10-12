package com.verizon.swd.ui;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TreeSet;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.table.DefaultTableModel;

import com.verizon.swd.model.Employee;

public class LoginForm extends JFrame{
	
	JPanel head;
	JPanel pButtons;
	JPanel pBody;
	JButton bOk;
	JButton bCancel;
	JLabel loginForm;
	JLabel UserName, Password, Role;
	
	JTextField tfUser;
	JPasswordField tPass;
	//JRadioButton rbMale, rbFemale;
	//ButtonGroup bgrGender;
	
//	ButtonGroup bgrMaternalStatus;
	
	JComboBox<String> cbRole;
	
	//JCheckBox chbSkills[];
	//Employee emp = null;
	
//	JTable table;//table model
	
	//DefaultTableModel tableModel;
	
	//JToggleButton tgbMarried, tgbUnMarried, tgbMarriedButSingle;
	
	public LoginForm(){
		
		createHeadPanel();
		createButtonPanel();
		
		createBodyPanel();
		
		//createTable();
		
		addEventListener();
		
		setTitle("Login From");
		setBounds(30,30,800,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

	private void createHeadPanel() {
		// TODO Auto-generated method stub
		head = new JPanel(null);
		loginForm = new JLabel("LoginForm");
		add(head,loginForm,0,0,20,800);
	}
/*
	private void createTable() {
		// TODO Auto-generated method stub
		tableModel  = new DefaultTableModel();
		table = new JTable(tableModel);
		emp = new Employee();
		tableModel.addColumn("Emp#");
		tableModel.addColumn("Name");
		tableModel.addColumn("Gender");
		tableModel.addColumn("Platform");
		tableModel.addColumn("MartialStatus");
		tableModel.addColumn("Skills");
	
		add(pBody,new JScrollPane(table),390,20,400,400);
	}
*/
	private void addEventListener() {
		// TODO Auto-generated method stub
		bCancel.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e)
		{
			dispose();
		}
		});
		
		bOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//emp = new Employee();
				/*emp.setSkills(new TreeSet<>());
				emp.setEmpId(Integer.parseInt(tfEmpId.getText()));
				emp.setGender(rbMale.isSelected()?"Gent":"Lady");
				emp.setMaternalStatus(
						tgbMarried.isSelected()?"Married":(
								tgbUnMarried.isSelected()?"UnMarried":"MBS"
									));
				emp.setName(tfEName.getText());
				emp.setPlatform(cbPlatform.getSelectedItem().toString());
				*/
				boolean check =false;
				if(cbRole.getSelectedItem().toString().equals("Admin"))
				{
					if(!(tfUser.getText()=="vamsy"&&tPass.getPassword().toString()=="admin"))
					{
						
						check=true;
						System.out.println(check);
						
					}
				}
				else if(cbRole.getSelectedItem().toString().equals("Instructor"))
				{
					if(!(tfUser.getText()=="kiran"&&tPass.getPassword().toString()=="kadmin"))
					{
						check=true;
					}

				}
				else
				{
					if(!(tfUser.getText()=="manav"&&tPass.getPassword().toString()=="manav"))
					{
						check=true;
					}
				}
				
				if(!check)
				{
					System.out.println("Login Successfull");
				}
				else
				{
					System.out.println("Invalid Credentials");
				}
				
				
			}
		});
	}

	private void createBodyPanel() {
		 pBody = new JPanel(null);
		
		 
		 UserName = new JLabel("Username:");
		 Password = new JLabel("Password: ");
		 Role = new JLabel("Role");
		
		tfUser = new JTextField();
		tPass = new JPasswordField();
		/*
		rbMale = new JRadioButton("Gents");
		rbFemale = new JRadioButton("Lady");
		*/
		//bgroup radio buttons so that only one can be selected
		/*
		bgrGender = new ButtonGroup();
		bgrGender.add(rbMale);
		bgrGender.add(rbFemale);
		
		tgbMarried = new JToggleButton("Married");
		tgbUnMarried = new JToggleButton("UnMarried");
		tgbMarriedButSingle = new JToggleButton("Married-But-Single");
		
		bgrMaternalStatus = new ButtonGroup();
		bgrMaternalStatus.add(tgbMarried);
		bgrMaternalStatus.add(tgbUnMarried);
		bgrMaternalStatus.add(tgbMarriedButSingle);
		*/
		cbRole = new JComboBox<>(new String[]{
				"Admin","Instructor","Student"
		});
		
		
		add(pBody, UserName, 20,20,125,25);
		add(pBody, tfUser, 155,20,125,25);
		add(pBody, Password, 20,50,125,25);
		add(pBody, tPass, 155,50,125,25);
		add(pBody, Role, 20,80,125,25);
		add(pBody, cbRole, 155,80,75,25);
		
		add(pBody, "Center");
	}

	private void createButtonPanel() {
		pButtons = new JPanel (new FlowLayout(FlowLayout.RIGHT));
		bOk = new JButton("Login");
		bCancel = new JButton("Quit");
		
		pButtons.add(bOk);
		pButtons.add(bCancel);
		
		add(pButtons, "South");
	}
	
	public void add(Container ct, JComponent cmp, int x, int y, int w, int h){
		cmp.setBounds(x,y,w,h);
		ct.add(cmp);
	}

}
