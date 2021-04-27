package main;

import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

import DB.DatabaseConnection;

public class Zero_Login extends JPanel {
	private JTextField textFieldUsername;
	private JPasswordField textFieldPassword;
	private JTextField errorField;
	private JButton createAccountButton;

	/**
	 * Create the panel.
	 */
	public Zero_Login() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JTextPane txtpnShoppingCartApp = new JTextPane();
		txtpnShoppingCartApp.setFont(new Font("Tahoma", Font.PLAIN, 36));
		txtpnShoppingCartApp.setText("Shopping Cart App");
		txtpnShoppingCartApp.setEditable(false);
		txtpnShoppingCartApp.setBounds(174, 49, 325, 50);
		add(txtpnShoppingCartApp);
		
		JTextPane txtpnLogin = new JTextPane();
		txtpnLogin.setText("Login");
		txtpnLogin.setFont(new Font("Tahoma", Font.PLAIN, 26));
		txtpnLogin.setEditable(false);
		txtpnLogin.setBounds(286, 110, 111, 50);
		add(txtpnLogin);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setBackground(Color.LIGHT_GRAY);
		textFieldUsername.setBounds(311, 231, 127, 29);
		add(textFieldUsername);
		textFieldUsername.setColumns(10);
		
		textFieldPassword = new JPasswordField();
		textFieldPassword.setBackground(Color.LIGHT_GRAY);
		textFieldPassword.setBounds(311, 271, 127, 29);
		add(textFieldPassword);
		textFieldPassword.setColumns(10);

		
		JTextPane txtpnUsername = new JTextPane();
		txtpnUsername.setText("Username:");
		txtpnUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtpnUsername.setEditable(false);
		txtpnUsername.setBounds(184, 231, 111, 29);
		add(txtpnUsername);
		
		JTextPane txtpnPassword = new JTextPane();
		txtpnPassword.setText("Password:");
		txtpnPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtpnPassword.setEditable(false);
		txtpnPassword.setBounds(184, 271, 111, 29);
		add(txtpnPassword);
		
		JButton signInButton = new JButton("Sign In");
		signInButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		signInButton.setBounds(259, 311, 98, 29);
		signInButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==signInButton) {
					String textUsername = textFieldUsername.getText();
					char[] textPassword = textFieldPassword.getPassword();
					//connection.selectUserNameForLogin(connection.getConnection(), textFieldUsername.getText());
					if(!(textUsername.equals("")) && !(textPassword.length == 0)) {
						if(main.db.userInArray(textUsername) == true) {
							Two_ShoppingPage panel = new Two_ShoppingPage();
							main.changePanel(panel);
							return;
						}
						
					} else {
						errorField.setText("Username not found");
						return;
					}
				}
			}
		});
		add(signInButton);
		
		errorField = new JTextField();
		errorField.setBackground(Color.WHITE);
		errorField.setBounds(244, 359, 127, 29);
		add(errorField);
		errorField.setColumns(10);
		
		createAccountButton = new JButton("Create Account");
		createAccountButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		createAccountButton.setBounds(235, 400, 150, 29);
		createAccountButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==createAccountButton) {
					One_CreateAccount panel = new One_CreateAccount();
					main.changePanel(panel);
				}
			}
		});
		add(createAccountButton);
		
		
		

		
	}

}