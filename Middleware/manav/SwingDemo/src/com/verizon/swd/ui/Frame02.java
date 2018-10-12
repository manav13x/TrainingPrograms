package com.verizon.swd.ui;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Frame02 extends JFrame {

	JButton button1;
	JButton button2;
	JButton button3;
	JButton button4;
	JButton button5;
	public Frame02(){
		button1 = new JButton("BTN 1");
		button2 = new JButton("BTN 2");
		button3 = new JButton("BTN 3");
		button4 = new JButton("BTN 4");
		button5 = new JButton("BTN 5");
		setLayout(new FlowLayout());
		add(button1,"North");
		add(button2,"South");
		add(button3,"East");
		add(button4,"West");
		add(button5,"Center");
		setTitle("My Swing Screen");
		setBounds(50,50,500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
