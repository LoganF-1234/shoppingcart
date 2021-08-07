package main;

import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.BorderFactory;
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
		setBackground(main.myYellow);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setBounds(100, 100, 876, 634);
		setLayout(null);
		
		JTextPane txtpnShoppingCartApp = new JTextPane();
		txtpnShoppingCartApp.setBackground(main.myYellow);
		txtpnShoppingCartApp.setFont(new Font("Monospaced", Font.BOLD, 36));
		txtpnShoppingCartApp.setText("Shopping Cart App");
		txtpnShoppingCartApp.setEditable(false);
		txtpnShoppingCartApp.setBounds(260, 49, 325, 50);
		add(txtpnShoppingCartApp);
		
		JTextPane txtpnLogin = new JTextPane();
		txtpnLogin.setBackground(main.myYellow);
		txtpnLogin.setText("Login");
		txtpnLogin.setFont(new Font("Monospaced", Font.PLAIN, 26));
		txtpnLogin.setEditable(false);
		txtpnLogin.setBounds(370, 110, 111, 50);
		add(txtpnLogin);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setBackground(Color.LIGHT_GRAY);
		textFieldUsername.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		textFieldUsername.setBounds(420, 231, 127, 29);
		add(textFieldUsername);
		textFieldUsername.setColumns(10);
		
		textFieldPassword = new JPasswordField();
		textFieldPassword.setBackground(Color.LIGHT_GRAY);
		textFieldPassword.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		textFieldPassword.setBounds(420, 271, 127, 29);
		add(textFieldPassword);
		textFieldPassword.setColumns(10);

		
		JTextPane txtpnUsername = new JTextPane();
		txtpnUsername.setText("Username:");
		txtpnUsername.setBackground(main.myYellow);
		txtpnUsername.setFont(new Font("Monospaced", Font.PLAIN, 20));
		txtpnUsername.setEditable(false);
		txtpnUsername.setBounds(293, 231, 111, 29);
		add(txtpnUsername);
		
		JTextPane txtpnPassword = new JTextPane();
		txtpnPassword.setText("Password:");
		txtpnPassword.setBackground(main.myYellow);
		txtpnPassword.setFont(new Font("Monospaced", Font.PLAIN, 20));
		txtpnPassword.setEditable(false);
		txtpnPassword.setBounds(293, 271, 111, 29);
		add(txtpnPassword);
		
		JButton signInButton = new JButton("Sign In");
		signInButton.setFont(new Font("Monospaced", Font.PLAIN, 16));
		signInButton.setBounds(352, 359, 125, 32);
		signInButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==signInButton) {
					String textUsername = textFieldUsername.getText();
					char[] textPassword = textFieldPassword.getPassword();
					String password = "";
					for(int i = 0; i< textPassword.length; i++) {
						password += textPassword[i];
					}
					if(!(textUsername.equals("")) && !(textPassword.length == 0)) {
						if(main.db.userInArray(textUsername) == true) {
							if(password.equals(main.db.getPassword(main.db.getConnection(), textUsername))) {
								if(main.db.isManager(textUsername)) {
									Seven_Manager panel = new Seven_Manager();
									main.changePanel(panel);
									main.currentUser = textUsername;
									main.currentUserPosition = "Manager";
									System.out.println("Logged in as manager: " + main.currentUser);
									return;
								} else {
									Two_ShoppingPage panel = new Two_ShoppingPage();
									main.changePanel(panel);
									main.currentUser = textUsername; // Sets static variable String currentUser to user logged in 
									System.out.println("Logged in as:" + main.currentUser);
									main.currentUserPosition = "Customer";
									return;
								}
								
							} else {
								errorField.setText("Someone forgot their password");
							}
							//System.out.println(main.db.getPassword(main.db.getConnection(), "Crayolcold"));
							
						} else {
							errorField.setText("Username not found");
							return;
						}
						
					} else {
						errorField.setText("Please enter username and password");
						return;
					}
				}
			}
		});
		add(signInButton);
		
		errorField = new JTextField();
		errorField.setBackground(main.myYellow);
		errorField.setBorder(BorderFactory.createLineBorder(new Color(228, 216, 116)));
		errorField.setFont(new Font(errorField.getFont().getName(),Font.ITALIC,errorField.getFont().getSize()));
		errorField.setBounds(293, 311, 300, 29);
		add(errorField);
		//errorField.setColumns(10);
		
		createAccountButton = new JButton("Create Account");
		createAccountButton.setFont(new Font("Monospaced", Font.PLAIN, 16));
		createAccountButton.setBounds(315, 425, 200, 32);
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