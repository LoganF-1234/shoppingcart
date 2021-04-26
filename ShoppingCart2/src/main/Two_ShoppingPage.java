package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Canvas;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class Two_ShoppingPage extends JPanel{
	private JButton button1, button2, button3,button4, button5, button6, button7 ,button8, button9, button10, 
			button11, button12, buttonLogOut;
		
	public Two_ShoppingPage() {
		initialize();
	}


	private void initialize() {
		
		setBackground(Color.WHITE);
		setBounds(100, 100, 852, 634);
		setLayout(null);
		
		JTextPane txtpnShoppingPage = new JTextPane();
		txtpnShoppingPage.setEditable(false);
		txtpnShoppingPage.setFont(new Font("Tahoma", Font.PLAIN, 33));
		txtpnShoppingPage.setBounds(10, 11, 229, 52);
		txtpnShoppingPage.setText("Shopping Page");
		add(txtpnShoppingPage);


		
		JButton checkOutButton = new JButton("Check Out");
		checkOutButton.setBounds(593, 478, 89, 23);
		checkOutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==checkOutButton) {
					Four_CheckOut panel = new Four_CheckOut();
					main.changePanel(panel);
				}
			}
		});
		add(checkOutButton);
	
		JButton showCartButton = new JButton("Show Cart");
		showCartButton.setBounds(689, 478, 89, 23);
		showCartButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==showCartButton) {
					Three_ShoppingCart panel = new Three_ShoppingCart();
					main.changePanel(panel);
				}
			}
		});
		add(showCartButton);
		
		JButton btnNewButton_2 = new JButton("Add");
		btnNewButton_2.setBounds(524, 478, 59, 23);
		add(btnNewButton_2);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBackground(Color.GRAY);
		textArea.setLineWrap(true);
		textArea.setText("4");
		textArea.setBounds(459, 479, 46, 22);
		add(textArea);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setText("$2.69");
		textPane.setBounds(459, 349, 46, 20);
		add(textPane);
		
		JTextPane txtpnPerDozen = new JTextPane();
		txtpnPerDozen.setEditable(false);
		txtpnPerDozen.setText("Per Dozen");
		txtpnPerDozen.setBounds(524, 349, 64, 20);
		add(txtpnPerDozen);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		separator.setForeground(Color.BLACK);
		separator.setBounds(439, 134, 387, 2);
		add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setForeground(Color.BLACK);
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(439, 134, 2, 406);
		add(separator_1);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBackground(Color.BLACK);
		separator_2.setForeground(Color.BLACK);
		separator_2.setBounds(439, 538, 387, 2);
		add(separator_2);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBackground(Color.BLACK);
		separator_3.setForeground(Color.BLACK);
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setBounds(825, 134, 2, 406);
		add(separator_3);

		TextField textField = new TextField();
		textField.setText("Search for an item...");
		textField.setFont(new Font("Dialog", Font.PLAIN, 15));
		textField.setBounds(29, 106, 797, 22);
		add(textField);
		
		JTextPane txtpnABeautifulEgg = new JTextPane();
		txtpnABeautifulEgg.setEditable(false);
		txtpnABeautifulEgg.setText("A beautiful egg.");
		txtpnABeautifulEgg.setBounds(459, 183, 205, 23);
		add(txtpnABeautifulEgg);
		
		JTextPane txtpnInstockLeft = new JTextPane();
		txtpnInstockLeft.setEditable(false);
		txtpnInstockLeft.setText("In-Stock: 240 left");
		txtpnInstockLeft.setBounds(459, 217, 205, 23);
		add(txtpnInstockLeft);
		
		JTextPane txtpnOutOfStock = new JTextPane();
		txtpnOutOfStock.setEditable(false);
		txtpnOutOfStock.setText("Out of Stock");
		txtpnOutOfStock.setBounds(459, 239, 159, 23);
		add(txtpnOutOfStock);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBackground(Color.BLACK);
		separator_4.setForeground(Color.BLACK);
		separator_4.setOrientation(SwingConstants.VERTICAL);
		separator_4.setBounds(29, 134, 2, 406);
		add(separator_4);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setForeground(Color.BLACK);
		separator_5.setBackground(Color.BLACK);
		separator_5.setBounds(29, 538, 393, 2);
		add(separator_5);
		JSeparator separator_6 = new JSeparator();
		separator_6.setBackground(Color.BLACK);
		separator_6.setForeground(Color.BLACK);
		separator_6.setBounds(29, 134, 393, 2);
		add(separator_6);
		
		JSeparator separator_7 = new JSeparator();
		separator_7.setBackground(Color.BLACK);
		separator_7.setForeground(Color.BLACK);
		separator_7.setOrientation(SwingConstants.VERTICAL);
		separator_7.setBounds(421, 134, 2, 406);
		add(separator_7);
		
		JButton btnLogOut = new JButton("Logout");
		btnLogOut.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLogOut.setBounds(675, 66, 151, 34);
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnLogOut) {
					Six_LogOut panel = new Six_LogOut();
					main.changePanel(panel);
				}
			}
		});
		add(btnLogOut);
		
		//addButton(button1, )
		addButton(button1, "Button1", 147);
		addButton(button2, "Button1", 183);
		addButton(button3, "Button1", 217);
		addButton(button4, "Button1", 251);
		addButton(button5, "Button1", 285);
		addButton(button6, "Button1", 319);
		addButton(button7, "Button1", 349);
		addButton(button8, "Button1", 381);
		addButton(button9, "Button1", 415);
		addButton(button10, "Button1", 448);
		addButton(button11, "Button1", 482);
		addButton(button12, "Button1", 516);
		//add(btnLogOut);

	}
	
	public JButton addButton(JButton button, String name, int twobound) {
		button = new JButton(name);
		button.setHorizontalAlignment(SwingConstants.LEFT);
		button.setBounds(39, twobound, 372, 23);
		add(button);
		return button;
	}
	

}