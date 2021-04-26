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
		txtpnXEggs.setText("1 x Eggs \n1 x Milk \n1 x Bannanas");
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
		add(btnLogout);
		
		JButton btnBackToLogin = new JButton("Back to Login:");
		btnBackToLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBackToLogin.setBounds(75, 366, 149, 36);
		add(btnBackToLogin);
	}
	
	public class SwitchPage implements ActionListener{
		JFrame bye;
		JFrame hi;
		public SwitchPage(JFrame bye, JFrame hi) {
			this.bye = bye;
			this.hi = hi;
		}
		public void actionPerformed(ActionEvent event) {
			bye.setVisible(false);
			hi.setVisible(true);
			}
		}
	

}
