package main;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import DB.DatabaseConnection;
import main.Two_ShoppingPage.ComboListener;

import java.awt.Canvas;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Seven_Manager extends JPanel{
	private JButton button1, button2, button3,button4, button5, button6,
					button7 ,button8, button9, button10, 
					button11, button12, buttonLogOut;
	
	private JTextPane txtfieldABeautifulEgg, textPane, txtpnPerDozen, 
					  txtpnInstockLeft;
	
	private JTextField txtpnOutOfStock;
	
	String name, amount, cost;
		
	int buttonNum = 0;
	
	JOptionPane optionPane;
	
	String[] arrayItemNames;
	
	JComboBox comboItems = new JComboBox();
	
	
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
		txtpnShoppingPage.setBounds(10, 11, 400, 52);
		txtpnShoppingPage.setText("Shopping Page ~ Manager View");
		add(txtpnShoppingPage);

		JButton deleteButton = new JButton("Delete");
		deleteButton.setBounds(593, 478, 100, 23);
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==deleteButton) {
					optionPane.showMessageDialog(null, "deleted");
					//main.db.decodeInfo(main.db.setShoppingCartInfo("banana", Integer.toString(342), Integer.toString(123)) + main.db.setShoppingCartInfo("strawberry", Integer.toString(342), Integer.toString(123)));
				}
			}
		});
		add(deleteButton);
		
		JButton checkOutButton = new JButton("Check Out");
		checkOutButton.setBounds(593, 478, 100, 23);
		checkOutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==checkOutButton) {
					Four_CheckOut panel = new Four_CheckOut();
					main.changePanel(panel);
					//main.db.decodeInfo(main.db.setShoppingCartInfo("banana", Integer.toString(342), Integer.toString(123)) + main.db.setShoppingCartInfo("strawberry", Integer.toString(342), Integer.toString(123)));
				}
			}
		});
		add(checkOutButton);
	
		JButton showCartButton = new JButton("Show Cart");
		showCartButton.setBounds(700, 478, 100, 23);
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
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton_2) {
					addItem();
				}
			}
		});
		add(btnNewButton_2);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBackground(Color.GRAY);
		textArea.setLineWrap(true);
		textArea.setText("4");
		textArea.setBounds(459, 479, 46, 22);
		add(textArea);
		
		textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setText("$2.69");
		textPane.setBounds(459, 349, 46, 20);
		add(textPane);
		
		JTextPane txtpnPerDozen = new JTextPane();
		txtpnPerDozen.setEditable(false);
		txtpnPerDozen.setText("Per Dozen");
		txtpnPerDozen.setVisible(false);
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
		
		txtfieldABeautifulEgg = new JTextPane();
		txtfieldABeautifulEgg.setEditable(false);
		txtfieldABeautifulEgg.setText("A beautiful egg.");
		txtfieldABeautifulEgg.setBounds(459, 183, 370, 23);
		add(txtfieldABeautifulEgg);
		
		txtpnInstockLeft = new JTextPane();
		txtpnInstockLeft.setEditable(false);
		txtpnInstockLeft.setText("In-Stock: 240 left");
		txtpnInstockLeft.setBounds(459, 217, 205, 23);
		add(txtpnInstockLeft);
		
		txtpnOutOfStock = new JTextField();
		txtpnOutOfStock.setEditable(false);
		txtpnOutOfStock.setVisible(false);
		//btnNewButton_2.txtpnOutOfStock.setText("Out of Stock");
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
		
		arrayItemNames = main.db.itemNamesArray(main.db.getConnection());
		comboItems = new JComboBox(arrayItemNames);
		comboItems.setSelectedIndex(1);
		comboItems.setBounds(39, 147, 372, 23);
		comboItems.addActionListener(new ComboListener());
		add(comboItems);

	}
	
	public class ComboListener implements ActionListener { //ComboBox described in Two_ShoppingPage
		int itemPosition =0; 
		int itemDatabasePosition= 0;
		public void actionPerformed(ActionEvent e) {
		String itemName = (String)comboItems.getSelectedItem();
		for(int j= 0; j < arrayItemNames.length; j++ ) {
				if(arrayItemNames[j] == itemName) { 
					itemPosition = j; 
					if( itemPosition == 0 ) { 
						itemDatabasePosition = 2; 

					} else {
						itemDatabasePosition = itemPosition*6 +2 ; //
					}
					
				} 
			}
			if(itemName == arrayItemNames[itemPosition]) { 
            	String[] stuff = main.db.itemsDatabaseArray(main.db.getConnection());
                txtfieldABeautifulEgg.setText(stuff[itemDatabasePosition] + "                        " + stuff[itemDatabasePosition+3]);
                name = stuff[itemDatabasePosition];
                amount = stuff[itemDatabasePosition+2];
                cost = stuff[itemDatabasePosition+1];
                textPane.setText("$" + stuff[itemDatabasePosition+1]);
                //txtpnPerDozen.setText("Per Dozen");
                txtpnInstockLeft.setText("In-Stock: " + stuff[itemDatabasePosition+2] +" left");               
            }
        }
			
	}
	
	
	
	public void addItem() {
		String info = main.db.setShoppingCartInfo(name, cost, amount);
		main.info += info;
		main.db.updateCart(main.db.getConnection(), "Crayolcold", main.info);
	}

}
	