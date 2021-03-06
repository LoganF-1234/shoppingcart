package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DB.DatabaseConnection;

import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

public class Three_ShoppingCart extends JPanel {
	ArrayList<String> itemsInUserCart;
	String output = "";
	

	public Three_ShoppingCart() {
		itemsInUserCart =  main.db.decodeInfo(main.db.grabCartInfo(main.db.getConnection(), main.currentUser));
		for(int i = 0; i < itemsInUserCart.size()/3; i++) {
			output += itemsInUserCart.get(i*3 +2) + "x " + itemsInUserCart.get(i*3) + "\n";
		}
		setBackground(main.myYellow);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		JTextPane txtpnShoppingCart = new JTextPane();
		txtpnShoppingCart.setFont(new Font("Monospaced", Font.BOLD, 36));
		txtpnShoppingCart.setBackground(main.myYellow);
		txtpnShoppingCart.setEditable(false);
		txtpnShoppingCart.setText("Shopping Cart:");
		txtpnShoppingCart.setBounds(250, 25, 400, 50);
		add(txtpnShoppingCart);
		
		JTextPane txtpnCartDesc = new JTextPane();
		txtpnCartDesc.setEditable(false);
		txtpnCartDesc.setFont(new Font("Monospaced", Font.BOLD, 17));
		txtpnCartDesc.setBackground(main.myYellow);
		txtpnCartDesc.setText(output);
		txtpnCartDesc.setBounds(75, 85, 390, 350);
		add(txtpnCartDesc);
		
		JButton btnCheckOut = new JButton("Back");
		btnCheckOut.setFont(new Font("Monospaced", Font.BOLD, 16));
		btnCheckOut.setBounds(340, 450, 110, 23);
		btnCheckOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnCheckOut) {
					if(main.currentUserPosition.equals("Manager")) {
						Seven_Manager panel = new Seven_Manager();
						main.changePanel(panel);
					} else {
						Two_ShoppingPage panel = new Two_ShoppingPage();
						main.changePanel(panel);
					}
					
				}
			}
		});
		add(btnCheckOut);
	}
}
	