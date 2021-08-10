package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
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
	private JSeparator separator, separator_1, separator_2, separator_3, 
	   separator_4, separator_5, separator_6, separator_7;
	private JTextPane txtfieldABeautifulEgg, textPane, txtpnShoppingPage, 
		txtpnInstockLeft, itemDescPane, cartUpdatePane, amountPane;
	private JTextField txtpnOutOfStock, amountField;
	private JButton checkOutButton, showCartButton, btnNewButton_2, btnLogOut, addItemButton, deleteItemButton, updateItemButton;
	String name, amount, cost, user;
	String[] arrayItemNames, stuff;
	private JComboBox comboItems;
	static int itemDatabasePosition;	
	
	public Seven_Manager() {
		initialize();
	}
	
	private void initialize() {
		
		setBackground(main.myYellow);
		setBounds(100, 100, 852, 634);
		setLayout(null);

		newSeparator(separator, 439, 134, 387, 2, "");
		newSeparator(separator_1, 439, 134, 2, 406, "vertical");
		newSeparator(separator_2, 439, 538, 387, 2, "");
		newSeparator(separator_3, 825, 134, 2, 406, "vertical");
		newSeparator(separator_4, 29, 134, 2, 406, "vertical");
		newSeparator(separator_5, 29, 538, 393, 2, "");
		newSeparator(separator_6, 29, 134, 393, 2, "");
		newSeparator(separator_7, 421, 134, 2, 406, "vertical");
		
		txtpnShoppingPage = new JTextPane();
		textPane = new JTextPane();
		txtfieldABeautifulEgg = new JTextPane();
		itemDescPane = new JTextPane();
		txtpnInstockLeft = new JTextPane();
		cartUpdatePane = new JTextPane();
		amountPane = new JTextPane();
		
		newTextPane(txtpnShoppingPage, 20, 25, 650, 52, "Shopping Page ~ Manager View", 36, "bold"); 
		newTextPane(textPane, 459, 260, 46, 20, "", 13, "");
		newTextPane(txtfieldABeautifulEgg, 459, 140, 300, 55, "Please choose an item from the dropdown...", 20, "bold");
		newTextPane(itemDescPane, 459, 195, 350, 23, "", 15, "");
		newTextPane(txtpnInstockLeft, 459, 230, 205, 23, "", 14, "");
		newTextPane(cartUpdatePane, 459, 505, 350, 25, "", 13, "italic");
		newTextPane(amountPane, 442, 450, 140, 22, "Enter Amount: ", 12, "");

		txtpnOutOfStock = new JTextField();
		txtpnOutOfStock.setEditable(false);
		txtpnOutOfStock.setVisible(false);
		//btnNewButton_2.txtpnOutOfStock.setText("Out of Stock");
		txtpnOutOfStock.setBounds(459, 239, 159, 23);
		add(txtpnOutOfStock);
		
		amountField = new JTextField();
		amountField.setEditable(true);
		amountField.setBackground(Color.LIGHT_GRAY);
		amountField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		amountField.setText("1");
		amountField.setBounds(459, 479, 46, 22);
		add(amountField);

		checkOutButton = new JButton("Check Out");
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
		
		showCartButton = new JButton("Show Cart");
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
		
		btnNewButton_2 = new JButton("Add"); 
		btnNewButton_2.setBounds(524, 478, 59, 23);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton_2) {
					addItem(main.currentUser);
				}
			}
		});
		add(btnNewButton_2);
		
		btnLogOut = new JButton("Logout");
		btnLogOut.setFont(new Font("Monospaced", Font.PLAIN, 18));
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
		
		addItemButton = new JButton("Add Item to Inventory");
		addItemButton.setBounds(48, 494, 169, 34);
		addItemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==addItemButton) {
					Eight_ManagerAdd panel = new Eight_ManagerAdd();
					main.changePanel(panel);
				}
			}
		});		
		add(addItemButton);
		
		deleteItemButton = new JButton("Remove Item From Inventory");
		deleteItemButton.setBounds(235, 494, 169, 34);
		deleteItemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == deleteItemButton) {
					Nine_ManagerRemove panel = new Nine_ManagerRemove();
					main.changePanel(panel);
				}
			}
		});
		add(deleteItemButton);
		
		updateItemButton = new JButton("Update Stock");
		updateItemButton.setBounds(141, 455, 169, 34);
		updateItemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ten_ManagerUpdate panel = new Ten_ManagerUpdate();
				main.changePanel(panel);
			}
		});
		add(updateItemButton);
		
		arrayItemNames = main.db.itemNamesArray(main.db.getConnection());
		comboItems = new JComboBox(arrayItemNames);
		comboItems.setSelectedIndex(0);
		comboItems.setBackground(Color.LIGHT_GRAY);
		comboItems.setBounds(39, 147, 372, 30);
		comboItems.setMaximumRowCount(15);
		comboItems.setFont(new Font("Monospaced", Font.BOLD, 14));
		comboItems.setBorder(BorderFactory.createLineBorder(Color.black));
		comboItems.addActionListener(new ComboListener());
		add(comboItems);

	}
	
	public void newTextPane(JTextPane pane, int x, int y, int w, int h, String def, int font, String type) {
		pane.setEditable(false);
		pane.setBackground(main.myYellow);
		pane.setText(def);
		pane.setBounds(x, y, w, h);
		if(type.equals("bold")) {
			pane.setFont(new Font("Monospaced", Font.BOLD, font));

		} else if(type.equals("italic")) {
			pane.setFont(new Font("Monospaced", Font.ITALIC, font));

		} else {
			pane.setFont(new Font("Monospaced", Font.PLAIN, font));

		}
		add(pane);
	}
	
	public void newSeparator(JSeparator sep, int x, int y, int w, int h, String orient) {
		sep = new JSeparator();
		sep.setBackground(Color.BLACK);
		sep.setForeground(Color.BLACK);
		sep.setBounds(x, y, w, h);
		if(orient.equals("vertical")) {
			sep.setOrientation(SwingConstants.VERTICAL);
		} 
		add(sep);
	}
	
	public class ComboListener implements ActionListener { //See Two_ShoppingPage for the explanation of this code
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
            	txtfieldABeautifulEgg.setFont(new Font("Monospaced", Font.BOLD, 35));
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
			String info = main.db.setShoppingCartInfo(name, cost, amount);
			main.info += info;
			main.db.updateCart(main.db.getConnection(), user, main.info);
		} else if(Integer.parseInt(amountField.getText()) <= Integer.parseInt(stuff[itemDatabasePosition+2])) {
         	amount = amountField.getText();
         	cartUpdatePane.setText(amount + "x " + name + " added to cart.");
         	String info = main.db.setShoppingCartInfo(name, cost, amount);
    		main.info += info;
    		main.db.updateCart(main.db.getConnection(), user, main.info);
        } else {
         	System.out.println("Not enough items in stock");
         	cartUpdatePane.setText("Not enough items in stock.");
        }
		
	}

}
	

	