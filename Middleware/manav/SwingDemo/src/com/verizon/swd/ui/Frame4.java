package com.verizon.swd.ui;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Frame4 extends JFrame {

	JButton button1;
	JButton button2;
	JButton button3;
	JButton button4;
	JButton button5;
	public Frame4(){
		button1 = new JButton("BTN 1");
		button2 = new JButton("BTN 2");
		button3 = new JButton("BTN 3");
		button4 = new JButton("BTN 4");
		button5 = new JButton("BTN 5");
		setLayout(null);
		add(button1);
		button1.setBounds(25,25,150,35);
		add(button1);
		button2.setBounds(200,25,150,35);
		add(button2);
		setTitle("My Swing Screen");
		setBounds(50,50,500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
