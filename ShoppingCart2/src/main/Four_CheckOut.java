package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DB.DatabaseConnection;

import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.JButton;

public class Four_CheckOut extends JPanel {


	public Four_CheckOut() {
		setBackground(Color.WHITE);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		JTextPane txtpnXEggs = new JTextPane();
		txtpnXEggs.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtpnXEggs.setEditable(false);
		txtpnXEggs.setText("" + main.db.decodeInfo(main.db.grabCart(main.db.getConnection()).get(1)));
		txtpnXEggs.setBackground(Color.LIGHT_GRAY);
		txtpnXEggs.setBounds(455, 132, 256, 254);
		add(txtpnXEggs);
		
		JTextPane txtpnCheckOut = new JTextPane();
		txtpnCheckOut.setEditable(false);
		txtpnCheckOut.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtpnCheckOut.setText("Check Out");
		txtpnCheckOut.setBounds(33, 30, 104, 36);
		add(txtpnCheckOut);
		
		JTextPane txtpnOrderStatus = new JTextPane();
		txtpnOrderStatus.setText("Order Status:");
		txtpnOrderStatus.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtpnOrderStatus.setEditable(false);
		txtpnOrderStatus.setBounds(33, 241, 112, 36);
		add(txtpnOrderStatus);
		
		JTextPane txtpnPending = new JTextPane();
		txtpnPending.setText("Pending");
		txtpnPending.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtpnPending.setEditable(false);
		txtpnPending.setBounds(155, 241, 112, 36);
		add(txtpnPending);
		
		JTextPane txtpnOrder = new JTextPane();
		txtpnOrder.setText("Order:");
		txtpnOrder.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtpnOrder.setEditable(false);
		txtpnOrder.setBounds(551, 85, 112, 36);
		add(txtpnOrder);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLogout.setBounds(643, 30, 112, 36);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnLogout) {
					Six_LogOut panel = new Six_LogOut();
					main.changePanel(panel);
				}
			}
		});
		add(btnLogout);
		
		JButton returnToLoginButton = new JButton("Back to Login:");
		returnToLoginButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		returnToLoginButton.setBounds(75, 366, 149, 36);
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
