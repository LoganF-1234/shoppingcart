package main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Seven_Login extends JPanel
{

	public Seven_Login()
	{
		components();
	}
	
	
	private void components()
	{

		setBackground(Color.WHITE);
		setBounds(100, 100, 852, 634);
		setLayout(null);
		
		JTextPane loginTitle = new JTextPane();
		loginTitle.setEditable(false);
		loginTitle.setFont(new Font("Tahoma", Font.PLAIN, 33));
		loginTitle.setBounds(307, 20, 329 , 102);
		loginTitle.setText("Shopping Cart App");
		add(loginTitle);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBackground(Color.CYAN);
		textArea.setLineWrap(true);
		textArea.setText(" Username: ");
		textArea.setBounds(250, 210, 70, 20);
		add(textArea);
		
		JTextArea textArea1 = new JTextArea();
		textArea1.setEditable(false);
		textArea1.setBackground(Color.CYAN);
		textArea1.setLineWrap(true);
		textArea1.setText(" Password: ");
		textArea1.setBounds(250, 250, 70, 20);
		add(textArea1);
		
		JButton signButton = new JButton("Sign In ");
		signButton.setBounds(400,300,100,30);
		add(signButton);
		
		JButton accButton = new JButton(" Create Account ");
		accButton.setBounds(300,350,300,30);
		add(accButton);
		
		JTextField userField = new JTextField();
		userField.setBounds(350, 210, 200,20);
		add(userField);

		JTextField passField = new JTextField();
		passField.setBounds(350, 250, 200,20);
		add(passField);
		
	}
}