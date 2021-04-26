package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;

import DB.DatabaseConnection;

public class Six_LogOut extends JPanel{

	public Six_LogOut() {
		setBackground(Color.WHITE);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		JTextPane txtpnLoggedOut = new JTextPane();
		txtpnLoggedOut.setEditable(false);
		txtpnLoggedOut.setFont(new Font("Sitka Text", Font.BOLD, 30));
		txtpnLoggedOut.setText("Logged Out");
		txtpnLoggedOut.setBounds(186, 151, 192, 49);
		add(txtpnLoggedOut);
		
		JTextPane txtpnThankYouFor = new JTextPane();
		txtpnThankYouFor.setText("Thank you for shopping!");
		txtpnThankYouFor.setFont(new Font("Sitka Text", Font.PLAIN, 12));
		txtpnThankYouFor.setEditable(false);
		txtpnThankYouFor.setBounds(206, 198, 192, 22);
		add(txtpnThankYouFor);
		
		JTextPane txtpnyourCartWill = new JTextPane();
		txtpnyourCartWill.setText("(Your cart will be saved, don't worry)");
		txtpnyourCartWill.setFont(new Font("Sitka Text", Font.PLAIN, 12));
		txtpnyourCartWill.setEditable(false);
		txtpnyourCartWill.setBounds(172, 219, 226, 22);
		add(txtpnyourCartWill);
		
		JButton returnToLoginButton = new JButton("Return to Login");
		returnToLoginButton.setBounds(229, 271, 107, 22);
		returnToLoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==returnToLoginButton) {
					Zero_Login panel = new Zero_Login();
					main.changePanel(panel);
				}
			}
		});
		add(returnToLoginButton);
	}
	
}
