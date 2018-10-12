package com.verizon.swd.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TreeSet;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.table.DefaultTableModel;

import com.verizon.swd.model.Employee;
/*
 * <applet code  = "AddEmployee width="1000" height="500">
 * </applet>
 * */
public class AddEmplyoeeApplet extends JApplet{
	
	JPanel pButtons;
	JPanel pBody;
	JButton bOk;
	JButton bCancel;
	
	JLabel lEmpId, lEName, lGender, lMaternalStatus, lPlatform, lSkills;
	
	JTextField tfEmpId, tfEName;
	JRadioButton rbMale, rbFemale;
	ButtonGroup bgrGender;
	
	ButtonGroup bgrMaternalStatus;
	
	JComboBox<String> cbPlatform;
	
	JCheckBox chbSkills[];
	Employee emp = null;
	
	JTable table;//table model
	
	DefaultTableModel tableModel;
	
	JToggleButton tgbMarried, tgbUnMarried, tgbMarriedButSingle;
	
	public AddEmplyoeeApplet(){
		
		createButtonPanel();
		
		createBodyPanel();
		
		createTable();
		
		addEventListener();
		setLayout(new BorderLayout());
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

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

	private void addEventListener() {
		// TODO Auto-generated method stub
		bCancel.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e)
		{
			//dispose();
		}
		});
		
		bOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				emp = new Employee();
				emp.setSkills(new TreeSet<>());
				emp.setEmpId(Integer.parseInt(tfEmpId.getText()));
				emp.setGender(rbMale.isSelected()?"Gent":"Lady");
				emp.setMaternalStatus(
						tgbMarried.isSelected()?"Married":(
								tgbUnMarried.isSelected()?"UnMarried":"MBS"
									));
				emp.setName(tfEName.getText());
				emp.setPlatform(cbPlatform.getSelectedItem().toString());
				
				for(JCheckBox chb : chbSkills)
				{
					if(chb.isSelected()){
						emp.getSkills().add(chb.getText());
					}
				}
				Object[] row = new Object[6];
				row[0]=emp.getEmpId();
				row[1]=emp.getName();
				row[2]=emp.getGender();
				row[3]=emp.getPlatform();
				row[4]=emp.getMaternalStatus();
				row[5]=emp.getSkills();
				tableModel.addRow(row);
			}
		});
	}

	private void createBodyPanel() {
		 pBody = new JPanel(null);
		
		lEmpId = new JLabel("Emp Id: ");
		lEName = new JLabel("Name: ");
		lGender = new JLabel("Gender");
		lMaternalStatus = new JLabel("Maternal Status");
		lPlatform = new JLabel("Dev Platform");
		lSkills = new JLabel("Skills");
		
		tfEmpId = new JTextField();
		tfEName = new JTextField();
		
		rbMale = new JRadioButton("Gents");
		rbFemale = new JRadioButton("Lady");
		
		//bgroup radio buttons so that only one can be selected
		
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
		
		cbPlatform = new JComboBox<>(new String[]{
				"Java",".Net","BI","MainFrames","DataAnalytics"
		});
		
		String skills[] = new String[]{
			"Dev", "Operations", "analytics", 
			"project manager", "Academics"
		};
		
		chbSkills = new JCheckBox[skills.length];
		
		for(int i=0; i<skills.length;i++)
			chbSkills[i] = new JCheckBox(skills[i]);
		
		
		add(pBody, lEmpId, 20,20,125,25);
		add(pBody, tfEmpId, 155,20,125,25);
		add(pBody, lEName, 20,50,125,25);
		add(pBody, tfEName, 155,50,125,25);
		add(pBody, lGender, 20,80,125,25);
		add(pBody, rbMale, 155,80,75,25);
		add(pBody, rbFemale, 235,80,75,25);
		add(pBody, lMaternalStatus, 20,110,125,25);
		add(pBody, tgbMarried, 155,110,80,25);
		add(pBody, tgbUnMarried, 240,110,80,25);
		add(pBody, tgbMarriedButSingle, 325,110,80,25);
		add(pBody, lPlatform, 20,140,125,25);
		add(pBody, cbPlatform, 155,140,125,25);
		add(pBody, lSkills, 20,170,125,25);
		
		for(int i=0; i<chbSkills.length; i++)
			add(pBody, chbSkills[i], 155, 175+(i*30), 125, 25);
		
		
		
		
		add(pBody, "Center");
	}

	private void createButtonPanel() {
		pButtons = new JPanel (new FlowLayout(FlowLayout.RIGHT));
		bOk = new JButton("Add");
		bCancel = new JButton("Cancel");
		
		pButtons.add(bOk);
		pButtons.add(bCancel);
		
		add(pButtons, "South");
	}
	
	public void add(Container ct, JComponent cmp, int x, int y, int w, int h){
		cmp.setBounds(x,y,w,h);
		ct.add(cmp);
	}

}
