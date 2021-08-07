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
		setBackground(main.myYellow);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		JTextPane txtpnLoggedOut = new JTextPane();
		txtpnLoggedOut.setEditable(false);
		txtpnLoggedOut.setFont(new Font("Monospaced", Font.BOLD, 36));
		txtpnLoggedOut.setBackground(main.myYellow);
		txtpnLoggedOut.setText("Logged Out");
		txtpnLoggedOut.setBounds(305, 135, 400, 50);
		add(txtpnLoggedOut);
		
		JTextPane txtpnThankYouFor = new JTextPane();
		txtpnThankYouFor.setText("Thank you for shopping!");
		txtpnThankYouFor.setFont(new Font("Monospaced", Font.PLAIN, 12));
		txtpnThankYouFor.setBackground(main.myYellow);
		txtpnThankYouFor.setEditable(false);
		txtpnThankYouFor.setBounds(328, 198, 192, 22);
		add(txtpnThankYouFor);
		
		JTextPane txtpnyourCartWill = new JTextPane();
		txtpnyourCartWill.setText("(Your cart will be saved, don't worry)");
		txtpnyourCartWill.setFont(new Font("Monospaced", Font.PLAIN, 12));
		txtpnyourCartWill.setBackground(main.myYellow);
		txtpnyourCartWill.setEditable(false);
		txtpnyourCartWill.setBounds(283, 219, 310, 22);
		add(txtpnyourCartWill);
		
		JButton returnToLoginButton = new JButton("Return to Login");
		returnToLoginButton.setBounds(332, 271, 150, 28);
		returnToLoginButton.addActionListener(new ActionListener() { //I need to actually close the connection to the current logged in account, dont know how
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==returnToLoginButton) {
					Zero_Login panel = new Zero_Login();
					main.changePanel(panel);
				/*	try {
						main.db.closeConnection();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				*/
				}
			}
		});
		add(returnToLoginButton);
	}
	
}
