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

import DB.DatabaseConnection;

public class One_CreateAccount extends JPanel{
	private JTextField firstNameText;
	private JTextField lastNameText;
	private JTextField userNameText;
	private JTextField passwordText;
	private JTextField addressText;
	private JList list;


	public One_CreateAccount() {
		
		setBackground(Color.WHITE);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		JTextArea txtrCreateAnAccount = new JTextArea();
		txtrCreateAnAccount.setEditable(false);
		txtrCreateAnAccount.setFont(new Font("Monospaced", Font.PLAIN, 17));
		txtrCreateAnAccount.setText("Create an Account");
		txtrCreateAnAccount.setBounds(261, 11, 250, 22);
		add(txtrCreateAnAccount);
		
		JTextArea txtrFirstName = new JTextArea();
		txtrFirstName.setEditable(false);
		txtrFirstName.setBackground(Color.GRAY);
		txtrFirstName.setText("First Name:");
		txtrFirstName.setBounds(77, 158, 168, 22);
		add(txtrFirstName);
		
		JTextArea txtrLastName = new JTextArea();
		txtrLastName.setEditable(false);
		txtrLastName.setText("Last Name:");
		txtrLastName.setBackground(Color.GRAY);
		txtrLastName.setBounds(77, 191, 168, 22);
		add(txtrLastName);
		
		JTextArea txtrUsername = new JTextArea();
		txtrUsername.setEditable(false);
		txtrUsername.setText("Username:");
		txtrUsername.setBackground(Color.GRAY);
		txtrUsername.setBounds(77, 224, 168, 22);
		add(txtrUsername);
		
		JTextArea txtrPassword = new JTextArea();
		txtrPassword.setEditable(false);
		txtrPassword.setText("Password:");
		txtrPassword.setBackground(Color.GRAY);
		txtrPassword.setBounds(77, 257, 168, 22);
		add(txtrPassword);
		
		JTextArea txtrAddress = new JTextArea();
		txtrAddress.setText("Address:");
		txtrAddress.setEditable(false);
		txtrAddress.setBackground(Color.GRAY);
		txtrAddress.setBounds(77, 290, 168, 22);
		add(txtrAddress);
		
		firstNameText = new JTextField();
		firstNameText.setBounds(290, 158, 250, 22);
		add(firstNameText);
		firstNameText.setColumns(10);
		
		lastNameText = new JTextField();
		lastNameText.setColumns(10);
		lastNameText.setBounds(290, 191, 250, 22);
		add(lastNameText);
		
		userNameText = new JTextField();
		userNameText.setColumns(10);
		userNameText.setBounds(290, 224, 250, 22);
		add(userNameText);
		
		passwordText = new JTextField();
		passwordText.setColumns(10);
		passwordText.setBounds(290, 257, 250, 22);
		add(passwordText);
		
		addressText = new JTextField();
		addressText.setColumns(10);
		addressText.setBounds(290, 290, 250, 22);
		add(addressText);
	
		JButton btnNewButton = new JButton("Create Account");
		btnNewButton.setBounds(560, 404, 128, 31);
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
		alreadyHaveAccount.setBounds(200, 404, 200, 31);
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
		list.setFont(new Font("Tahoma", Font.PLAIN, 14));
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Customer", "Employee", "Manager"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(560, 53, 90, 67);
		add(list);
		
		JTextArea txtrPosition = new JTextArea();
		txtrPosition.setEditable(false);
		txtrPosition.setText("Position:");
		txtrPosition.setBounds(545, 20, 95, 22);
		add(txtrPosition);
		
		
	}
}
