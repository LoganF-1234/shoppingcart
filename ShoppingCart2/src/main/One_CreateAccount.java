package main;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;

import DB.DatabaseConnection;

public class One_CreateAccount extends JPanel{
	private JTextField firstNameText;
	private JTextField lastNameText;
	private JTextField userNameText;
	private JTextField passwordText;
	private JTextField addressText;
	private JList list;


	public One_CreateAccount() {
		
		setBackground(main.myYellow);
		setBounds(100, 100, 876, 634);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		JTextArea txtrCreateAnAccount = new JTextArea();
		txtrCreateAnAccount.setEditable(false);
		txtrCreateAnAccount.setFont(new Font("Monospaced", Font.BOLD, 36));
		txtrCreateAnAccount.setBackground(main.myYellow);
		txtrCreateAnAccount.setText("Create an Account");
		txtrCreateAnAccount.setBounds(240, 11, 400, 50);
		add(txtrCreateAnAccount);
		
		JTextArea txtrFirstName = new JTextArea();
		txtrFirstName.setEditable(false);
		txtrFirstName.setText("First Name:");
		txtrFirstName.setFont(new Font("Monospaced",Font.PLAIN,22));
		txtrFirstName.setBackground(main.myYellow);
		txtrFirstName.setBounds(175, 120, 200, 28);
		add(txtrFirstName);
		
		JTextArea txtrLastName = new JTextArea();
		txtrLastName.setEditable(false);
		txtrLastName.setText("Last Name:");
		txtrLastName.setFont(new Font("Monospaced",Font.PLAIN,22));
		txtrLastName.setBackground(main.myYellow);
		txtrLastName.setBounds(175, 160, 200, 28);
		add(txtrLastName);
		
		JTextArea txtrUsername = new JTextArea();
		txtrUsername.setEditable(false);
		txtrUsername.setText("Username:");
		txtrUsername.setFont(new Font("Monospaced",Font.PLAIN,22));
		txtrUsername.setBackground(main.myYellow);
		txtrUsername.setBounds(175, 200, 200, 28);
		add(txtrUsername);
		
		JTextArea txtrPassword = new JTextArea();
		txtrPassword.setEditable(false);
		txtrPassword.setText("Password:");
		txtrPassword.setFont(new Font("Monospaced",Font.PLAIN,22));
		txtrPassword.setBackground(main.myYellow);
		txtrPassword.setBounds(175, 240, 200, 28);
		add(txtrPassword);
		
		JTextArea txtrAddress = new JTextArea();
		txtrAddress.setEditable(false);
		txtrAddress.setText("Address:");
		txtrAddress.setFont(new Font("Monospaced",Font.PLAIN,22));
		txtrAddress.setBackground(main.myYellow);
		txtrAddress.setBounds(175, 280, 200, 28);
		add(txtrAddress);
		
		firstNameText = new JTextField();
		firstNameText.setColumns(10);
		firstNameText.setBounds(382, 125, 250, 28);
		firstNameText.setBackground(Color.LIGHT_GRAY);
		firstNameText.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		add(firstNameText);
		
		lastNameText = new JTextField();
		lastNameText.setColumns(10);
		lastNameText.setBounds(382, 165, 250, 28);
		lastNameText.setBackground(Color.LIGHT_GRAY);
		lastNameText.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		add(lastNameText);
		
		userNameText = new JTextField();
		userNameText.setColumns(10);
		userNameText.setBounds(382, 205, 250, 28);
		userNameText.setBackground(Color.LIGHT_GRAY);
		userNameText.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		add(userNameText);
		
		passwordText = new JTextField();
		passwordText.setColumns(10);
		passwordText.setBounds(382, 245, 250, 28);
		passwordText.setBackground(Color.LIGHT_GRAY);
		passwordText.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		add(passwordText);
		
		addressText = new JTextField();
		addressText.setColumns(10);
		addressText.setBounds(382, 285, 250, 28);
		addressText.setBackground(Color.LIGHT_GRAY);
		addressText.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		add(addressText);
	
		JButton btnNewButton = new JButton("Create Account");
		btnNewButton.setBounds(270, 415, 250, 35);
		btnNewButton.setFont(new Font("Monospaced",Font.PLAIN,22));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton) {
					main.db.insertusers(main.db.getConnection(), firstNameText.getText(), lastNameText.getText(), list.getSelectedValue().toString(), addressText.getText(), userNameText.getText(), passwordText.getText(), 0);
					if(list.getSelectedValue().toString().equals("Customer")) {
						Two_ShoppingPage panel = new Two_ShoppingPage();
						main.changePanel(panel);
					} else {
						Seven_Manager panel = new Seven_Manager();
						main.changePanel(panel);
					}
					main.db.addShoppingCart(userNameText.getText(), "", "pending");
					
				}
			}
		});
		add(btnNewButton);
		
		JButton alreadyHaveAccount = new JButton("Already Have an Account?");
		alreadyHaveAccount.setBounds(220, 470, 350, 35);
		alreadyHaveAccount.setFont(new Font("Monospaced",Font.PLAIN,20));
		alreadyHaveAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==alreadyHaveAccount) {
					Zero_Login panel = new Zero_Login();
					main.changePanel(panel);
				}
			}
		});
		add(alreadyHaveAccount);
		
		list = new JList();
		list.setFont(new Font("Monospaced", Font.PLAIN, 14));
		list.setBackground(main.myYellow);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Customer", "Employee", "Manager"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(382, 325, 90, 67);
		add(list);
		
		JTextArea txtrPosition = new JTextArea();
		txtrPosition.setEditable(false);
		txtrPosition.setText("Position:");
		txtrPosition.setBackground(main.myYellow);
		txtrPosition.setFont(new Font("Monospaced",Font.PLAIN,22));
		txtrPosition.setBounds(175, 320, 200, 28);
		add(txtrPosition);
		
		
	}
}
