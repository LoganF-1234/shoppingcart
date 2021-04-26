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
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class Seven_Manager extends JPanel {

	public Seven_Manager() {
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
		
		JButton btnNewButton = new JButton("Check Out");
		btnNewButton.setBounds(593, 478, 89, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Show Cart");
		btnNewButton_1.setBounds(689, 478, 89, 23);
		add(btnNewButton_1);
		
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
		txtpnABeautifulEgg.setText("A beautiful egg.");
		txtpnABeautifulEgg.setBounds(459, 183, 205, 23);
		add(txtpnABeautifulEgg);
		
		JTextPane txtpnInstockLeft = new JTextPane();
		txtpnInstockLeft.setText("In-Stock: 240 left");
		txtpnInstockLeft.setBounds(459, 217, 205, 23);
		add(txtpnInstockLeft);
		
		JTextPane txtpnOutOfStock = new JTextPane();
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
		
		JButton btnItem = new JButton("Item Number 1");
		btnItem.setHorizontalAlignment(SwingConstants.LEFT);
		btnItem.setBounds(39, 147, 372, 23);
		add(btnItem);
		
		JButton btnItem2 = new JButton("Item Number 2");
		btnItem2.setHorizontalAlignment(SwingConstants.LEFT);
		btnItem2.setBounds(39, 183, 372, 23);
		add(btnItem2);
		
		JButton btnItem3 = new JButton("Item Number 3");
		btnItem3.setHorizontalAlignment(SwingConstants.LEFT);
		btnItem3.setBounds(39, 217, 372, 23);
		add(btnItem3);
		
		JButton btnItem4 = new JButton("Item Number 4");
		btnItem4.setHorizontalAlignment(SwingConstants.LEFT);
		btnItem4.setBounds(39, 251, 372, 23);
		add(btnItem4);
		
		JButton btnItem5 = new JButton("Item Number 5");
		btnItem5.setHorizontalAlignment(SwingConstants.LEFT);
		btnItem5.setBounds(39, 285, 372, 23);
		add(btnItem5);
		
		JButton btnItem6 = new JButton("Item Number 6");
		btnItem6.setHorizontalAlignment(SwingConstants.LEFT);
		btnItem6.setBounds(39, 319, 372, 23);
		add(btnItem6);
		
		JButton btnItem7 = new JButton("Item Number 7");
		btnItem7.setHorizontalAlignment(SwingConstants.LEFT);
		btnItem7.setBounds(39, 349, 372, 23);
		add(btnItem7);
		
		JButton btnItem8 = new JButton("Item Number 8");
		btnItem8.setHorizontalAlignment(SwingConstants.LEFT);
		btnItem8.setBounds(39, 381, 372, 23);
		add(btnItem8);
		
		JButton btnItem9 = new JButton("Item Number 9");
		btnItem9.setHorizontalAlignment(SwingConstants.LEFT);
		btnItem9.setBounds(39, 415, 372, 23);
		add(btnItem9);
		
		JButton btnItem10 = new JButton("Item Number 10");
		btnItem10.setHorizontalAlignment(SwingConstants.LEFT);
		btnItem10.setBounds(39, 448, 372, 23);
		add(btnItem10);
		
		JButton btnItem11 = new JButton("Item Number 11");
		btnItem11.setHorizontalAlignment(SwingConstants.LEFT);
		btnItem11.setBounds(39, 482, 372, 23);
		add(btnItem11);
		
		JButton btnItem12 = new JButton("Item Number 12");
		btnItem12.setHorizontalAlignment(SwingConstants.LEFT);
		btnItem12.setBounds(41, 516, 372, 23);
		add(btnItem12);
		
		JButton btnLogOut = new JButton("Logout");
		btnLogOut.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLogOut.setBounds(675, 66, 151, 34);
		add(btnLogOut);
	}
}