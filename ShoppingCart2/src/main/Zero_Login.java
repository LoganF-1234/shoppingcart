package main;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class Zero_Login extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

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
		
		textField = new JTextField();
		textField.setBackground(Color.LIGHT_GRAY);
		textField.setBounds(311, 231, 127, 29);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBackground(Color.LIGHT_GRAY);
		textField_1.setBounds(311, 271, 127, 29);
		add(textField_1);
		
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
		
		JButton btnNewButton = new JButton("Sign In");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(259, 311, 98, 29);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton) {
					Two_ShoppingPage panel = new Two_ShoppingPage();
					main.changePanel(panel);
				}
			}
		});
		add(btnNewButton);
		

		
	}

}