package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Three_ShoppingCart extends JPanel {


	public Three_ShoppingCart() {
		setBackground(Color.WHITE);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		JTextPane txtpnShoppingCart = new JTextPane();
		txtpnShoppingCart.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtpnShoppingCart.setEditable(false);
		txtpnShoppingCart.setText("Shopping Cart:");
		txtpnShoppingCart.setBounds(10, 11, 167, 36);
		add(txtpnShoppingCart);
		
		JTextPane txtpnCartDesc = new JTextPane();
		txtpnCartDesc.setEditable(false);
		txtpnCartDesc.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtpnCartDesc.setText("4 x Eggs");
		txtpnCartDesc.setBounds(20, 58, 390, 155);
		add(txtpnCartDesc);
		
		JButton btnCheckOut = new JButton("Back");
		btnCheckOut.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCheckOut.setBounds(300, 227, 110, 23);
		add(btnCheckOut);
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