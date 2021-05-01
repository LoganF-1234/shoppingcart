package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

import DB.DatabaseConnection;

import java.awt.Canvas;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class Seven_Manager extends JPanel{
	private JButton button1, button2, button3,button4, button5, button6,
					button7 ,button8, button9, button10, 
					button11, button12, buttonLogOut;
	
	private JTextPane txtfieldABeautifulEgg, textPane, txtpnPerDozen, 
					  txtpnInstockLeft, itemDescPane, cartUpdatePane;
	
	private JTextField txtpnOutOfStock, amountField;
	
	String name, amount, cost, user;
	
	String[] arrayItemNames, stuff;
	
	private JComboBox comboItems;
	
	static int itemDatabasePosition;
		
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
		txtpnShoppingPage.setBounds(10, 11, 500, 52);
		txtpnShoppingPage.setText("Shopping Page ~ Manager View");
		add(txtpnShoppingPage);


		
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
					addItem(main.currentUser);
				}
			}
		});
		add(btnNewButton_2);
		
		JTextPane amountPane = new JTextPane();
		amountPane.setEditable(false);
		amountPane.setText("Enter Amount: ");
		amountPane.setBounds(442, 450, 100, 22);
		add(amountPane);
		
		amountField = new JTextField();
		amountField.setEditable(true);
		amountField.setBackground(Color.LIGHT_GRAY);
		//amountField.setLineWrap(true);
		amountField.setText("1");
		amountField.setBounds(459, 479, 46, 22);
		add(amountField);
		
		textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setText("");
		textPane.setBounds(459, 260, 46, 20);
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
		txtfieldABeautifulEgg.setText("Please choose an item from the dropdown...");
		txtfieldABeautifulEgg.setBounds(459, 140, 370, 55);
		add(txtfieldABeautifulEgg);
		
		itemDescPane = new JTextPane();
		itemDescPane.setEditable(false);
		itemDescPane.setBounds(459, 195, 370, 23);
		add(itemDescPane);
		
		txtpnInstockLeft = new JTextPane();
		txtpnInstockLeft.setEditable(false);
		txtpnInstockLeft.setText("");
		txtpnInstockLeft.setBounds(459, 230, 205, 23);
		add(txtpnInstockLeft);
		
		txtpnOutOfStock = new JTextField();
		txtpnOutOfStock.setEditable(false);
		txtpnOutOfStock.setVisible(false);
		//btnNewButton_2.txtpnOutOfStock.setText("Out of Stock");
		txtpnOutOfStock.setBounds(459, 239, 159, 23);
		add(txtpnOutOfStock);
		
		cartUpdatePane = new JTextPane();
		cartUpdatePane.setFont(new Font("Tacoma", Font.ITALIC, 13));
		cartUpdatePane.setText("");
		cartUpdatePane.setBounds(459, 505, 350, 25);
		add(cartUpdatePane);
		
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
					main.resetOnLogout();
					System.out.println("Logged out");
				}
			}
		});
		add(btnLogOut);
		
		
		//TRYING TO MAKE COMBO BOX ISNTEAD OF BUTTONS
		arrayItemNames = main.db.itemNamesArray(main.db.getConnection());
		//System.out.println(arrayItemNames);
		comboItems = new JComboBox(arrayItemNames);
		comboItems.setSelectedIndex(0);
		comboItems.setBounds(39, 147, 372, 30);
		comboItems.setMaximumRowCount(15);
		comboItems.addActionListener(new ComboListener());
		add(comboItems);

		JButton addItemButton = new JButton("Add Item to Inventory");
		addItemButton.setBounds(48, 494, 169, 34);
		add(addItemButton);
		
		JButton deleteItemButton = new JButton("Remove Item From Inventory");
		deleteItemButton.setBounds(235, 494, 169, 34);
		add(deleteItemButton);
	}
	
	public class ComboListener implements ActionListener { //See Two_ShoppingPage for the explanation of thiss code
		int itemPosition =0; 
		public void actionPerformed(ActionEvent e) {
		itemDatabasePosition= 0;

		String itemName = (String)comboItems.getSelectedItem();
		
		for(int j= 0; j < arrayItemNames.length; j++ ) {
				if(arrayItemNames[j] == itemName) { 
					itemPosition = j; 
					if( itemPosition == 0 ) {
						itemDatabasePosition = 2; 
					} else {
						itemDatabasePosition = itemPosition*6 +2 ; 
					}			
				} 
			}
			if(itemName == arrayItemNames[itemPosition]) { 
            	stuff = main.db.itemsDatabaseArray(main.db.getConnection());     
            	txtfieldABeautifulEgg.setFont(new Font("Tahoma", Font.BOLD, 35));
                txtfieldABeautifulEgg.setText(stuff[itemDatabasePosition]);
            	itemDescPane.setText(stuff[itemDatabasePosition + 3]);
                name = stuff[itemDatabasePosition];
                cost = stuff[itemDatabasePosition+1];
                textPane.setText("$" + stuff[itemDatabasePosition+1]);
                //txtpnPerDozen.setText("Per Dozen");
                if(Integer.parseInt(stuff[itemDatabasePosition +2]) != 0) { 
                    txtpnInstockLeft.setText("In-Stock: " + stuff[itemDatabasePosition+2] +" left");               
                } else { 
                    txtpnInstockLeft.setText("Out-of-stock");               
                }
            }
        }
			
	}
	
	public void addItem(String user) {
		if(amountField.getText().equals("")) {
			amount = "1";
			cartUpdatePane.setText("One " + name + " added to cart.");
		} else if(Integer.parseInt(amountField.getText()) <= Integer.parseInt(stuff[itemDatabasePosition+2])) {
         	amount = amountField.getText();
         	cartUpdatePane.setText(amount + "x " + name + " added to cart.");

        } else {
         	System.out.println("Not enough items in stock");
         	System.exit(1);
         }
		String info = main.db.setShoppingCartInfo(name, cost, amount);
		main.info += info;
		main.db.updateCart(main.db.getConnection(), user, main.info);
	}

}
	

	