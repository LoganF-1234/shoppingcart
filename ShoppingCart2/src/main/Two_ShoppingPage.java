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

import DB.DatabaseConnection;

import java.awt.Canvas;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class Two_ShoppingPage extends JPanel{
	private JSeparator separator, separator_1, separator_2, separator_3, 
	   separator_4, separator_5, separator_6, separator_7;
	private JTextPane txtfieldABeautifulEgg, textPane, txtpnShoppingPage, 
		txtpnInstockLeft, itemDescPane, cartUpdatePane, amountPane;
	private JTextField txtpnOutOfStock, amountField;
	private JButton checkOutButton, showCartButton, btnNewButton_2, btnLogOut;
	String name, amount, cost, user;
	String[] arrayItemNames, stuff;
	private JComboBox comboItems;
	static int itemDatabasePosition;
	int databaseAmount, newAmount;
		
	public Two_ShoppingPage() {
		initialize();
	}
	
	private void initialize() {
		
		setBackground(main.myYellow);
		setBounds(100, 100, 876, 634);
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
		
		newTextPane(txtpnShoppingPage, 20, 25, 650, 52, "Shopping Page", 36, "bold"); 
		newTextPane(textPane, 459, 260, 64, 20, "", 13, "");
		newTextPane(txtfieldABeautifulEgg, 459, 140, 350, 55, "Please choose an item from the dropdown...", 20, "bold");
		newTextPane(itemDescPane, 459, 195, 350, 23, "", 15, "");
		newTextPane(txtpnInstockLeft, 459, 230, 205, 23, "", 14, "");
		newTextPane(cartUpdatePane, 459, 505, 350, 25, "", 13, "italic");
		newTextPane(amountPane, 442, 450, 140, 22, "Enter Amount: ", 12, "");

		/*TextField textField = new TextField();
		textField.setText("Search for an item...");
		textField.setFont(new Font("Dialog", Font.PLAIN, 15));
		textField.setBounds(29, 106, 797, 22);
		add(textField);
		*/
			
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
		checkOutButton.setFont(new Font("Monospaced", Font.BOLD, 12));
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
		showCartButton.setFont(new Font("Monospaced", Font.BOLD, 12));
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
		btnNewButton_2.setFont(new Font("Monospaced", Font.BOLD, 12));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton_2) {
					addItem(main.currentUser);
				}
			}
		});
		add(btnNewButton_2);
		
		btnLogOut = new JButton("Logout");
		btnLogOut.setFont(new Font("Monospaced", Font.BOLD, 20));
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
		comboItems.setBackground(Color.LIGHT_GRAY);
		comboItems.setBounds(39, 147, 372, 30);
		comboItems.setMaximumRowCount(15);
		comboItems.setFont(new Font("Monospaced", Font.BOLD, 14));
		comboItems.setBorder(BorderFactory.createLineBorder(Color.black));
		comboItems.addActionListener(new ComboListener());
		add(comboItems);
		//System.out.println(main.db.getItemnames(main.db.getConnection()));

	//Originally I used buttons instead of a combobox and I am too proud of implementing this methods to delete them entirely		
	/*	addButton(button1, "Banana", 147, 2);
        addButton(button2, "Strawberries", 183, 8);
		addButton(button3, "Eggplant", 217, 14);	 
		addButton(button4, "Capicola", 251, 20);	
		addButton(button5, "Pizza", 285, 26);	
		addButton(button6, "Apple", 319, 32);
		addButton(button7, "Pistachio", 349, 38);
		addButton(button8, "Cashew", 381, 44);
		addButton(button9, "Walnuts", 415, 50);
		addButton(button10, "Spaghetti", 448, 56);
		addButton(button11, "Bat", 478, 62);
		addButton(button12, "Penne", 510, 68);
	
	}
	
	public JButton addButton(JButton button, String name, int twobound, int i) {
		button = new JButton(name);
		button.setHorizontalAlignment(SwingConstants.LEFT);
		button.setBounds(39, twobound, 372, 23);
		button.addActionListener(new ButtonListener(button, i));
		add(button);
		return button;
	}
	
	public class ButtonListener implements ActionListener {
        JButton button;
        int i;
        public ButtonListener(JButton button, int i) {
        	this.button = button;
        	this.i = i;
        }
		public void actionPerformed(ActionEvent e) {
        	if(e.getSource()== button) {
            	ArrayList<String> stuff = main.db.getItemnames(main.db.getConnection());
                txtfieldABeautifulEgg.setText(stuff.get(i) + "                        " + stuff.get(i+3));
                name = stuff.get(i);
                amount = stuff.get(i + 2);
                cost = stuff.get(i + 1);
                textPane.setText("$" + stuff.get(i+1));
                //txtpnPerDozen.setText("Per Dozen");
                txtpnInstockLeft.setText("In-Stock: " + stuff.get(i+2) +" left");               
            }
        }
	 END initialize() */	
		
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
	
	public class ComboListener implements ActionListener { //This action listener will need to be able to compare the array of just item names to the array of all item information in the for loop
		int itemPosition =0; 
		public void actionPerformed(ActionEvent e) {
		itemDatabasePosition= 0;
		String itemName = (String)comboItems.getSelectedItem();
		
		/* itemPosition and itemDatabasePosition will be "linked" so that the int they carry will be the respectiv eindexes of where the same item name is in the respective arrays
		 *
		 * itemPosition array => arrayItemNames: [banana, strawberries, egglpant, gabagool, frozen pizza, apple,...]
		 * itemDatabasePosition array => [1, fruit, banana, 1.0, 5, large banana, 2, fruit, strawberries, 1.69, 5, 16oz container, 3, fruit, eggplant, 1.79, 5, like the banana but purple, 4, meat, gabagool, 1.79, 5, tony sopranos favorite treat,..]
		 * 
		 * itemPosition (index) for strawberries in arrayItemNames is 1, in the second array the index (itemDatabasePosition) is 8
		 * index for eggplants is 3, then 14
		 * 
		 * So the indexes correspond as follows... 
		 * 
		 * itemDatabasePosition = (itemPosition * 6) + 2
		 * 
		 */
			
		for(int j= 0; j < arrayItemNames.length; j++ ) {
				if(arrayItemNames[j] == itemName) { // finds the items j position in the array based on its name
					itemPosition = j; // set temp varaible so j can reset
					if( itemPosition == 0 ) { //if the first item in the combobox is selected, the index for the database of all the items is set to 2 since that is where the name for the item first occurs
						itemDatabasePosition = 2; // if the item position 
					} else {
						itemDatabasePosition = itemPosition*6 +2 ; //
					}
				} 
			}
			if(itemName == arrayItemNames[itemPosition]) { //use the itemDatabasePosition from above to add items at indexes near it in the array into the corresponding text panes. See line 277.
            	stuff = main.db.itemsDatabaseArray(main.db.getConnection());
            	txtfieldABeautifulEgg.setFont(new Font("Monospaced", Font.BOLD, 33));
                txtfieldABeautifulEgg.setText(stuff[itemDatabasePosition]);
            	itemDescPane.setText(stuff[itemDatabasePosition + 3]);
                name = stuff[itemDatabasePosition];
                //amount = stuff[itemDatabasePosition+2];
                cost = stuff[itemDatabasePosition+1];
                textPane.setText("$" + stuff[itemDatabasePosition+1]);
                //txtpnPerDozen.setText("Per Dozen");
                if(Integer.parseInt(stuff[itemDatabasePosition +2]) != 0) { //only show in stock if there are any left of the item in  the database
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
	