package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Nine_ManagerRemove extends JPanel {
	private JSeparator separator, separator_1, separator_2, separator_3, 
		separator_4, separator_5, separator_6, separator_7;
	private JTextPane txtfieldABeautifulEgg, textPane, txtpnInstockLeft, itemDescPane, itemRemoved, txtpnShoppingPage;
	private JTextField txtpnOutOfStock, textField;
	private JButton removeItem, btnBack;
	String name, amount, cost, user;
	String[] arrayItemNames, stuff;
	private JComboBox comboItems;
	static int itemDatabasePosition;

	public Nine_ManagerRemove() {
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
		itemRemoved = new JTextPane();

		newTextPane(txtpnShoppingPage, 20, 25, 400, 52, "Remove Item From Inventory", 36, "bold"); //bold
		newTextPane(textPane, 459, 260, 46, 20, "", 13, "");
		newTextPane(txtfieldABeautifulEgg, 459, 140, 300, 55, "Please choose an item to remove...", 20, "bold");
		newTextPane(itemDescPane, 459, 195, 350, 23, "", 15, "");
		newTextPane(txtpnInstockLeft, 459, 230, 205, 23, "", 14, "");
		newTextPane(itemRemoved, 458, 500, 350, 20, "", 13, "italic"); 

		textField = new JTextField();
		textField.setText("Search for an item...");
		textField.setFont(new Font("Dialog", Font.PLAIN, 15));
		textField.setBounds(29, 106, 797, 22);
		add(textField);

		txtpnOutOfStock = new JTextField();
		txtpnOutOfStock.setEditable(false);
		txtpnOutOfStock.setVisible(false);
		txtpnOutOfStock.setBounds(459, 239, 159, 23);
		add(txtpnOutOfStock);
		
		removeItem = new JButton("Remove This Item From Inventory");
		removeItem.setBounds(458, 450, 345, 40);
		removeItem.addActionListener(new ButtonListener());
		add(removeItem);

		btnBack = new JButton("Back");
		btnBack.setFont(new Font("Monospaced", Font.PLAIN, 18));
		btnBack.setBounds(675, 66, 151, 34);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnBack) {
					Seven_Manager panel = new Seven_Manager();
					main.changePanel(panel);
				}
			}
		});
		add(btnBack);

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
	
	public class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == removeItem) {
				main.db.delete(main.db.getConnection(), name);
				Nine_ManagerRemove panel = new Nine_ManagerRemove();
				main.changePanel(panel);
				panel.itemRemoved.setText(name + " Removed From Inventory.");
			}
		}
	}
	
	public class ComboListener implements ActionListener { // See Two_ShoppingPage for the explanation of this code
		int itemPosition = 0;

		public void actionPerformed(ActionEvent e) {
			itemDatabasePosition = 0;

			String itemName = (String) comboItems.getSelectedItem();

			for (int j = 0; j < arrayItemNames.length; j++) {
				if (arrayItemNames[j] == itemName) {
					itemPosition = j;
					if (itemPosition == 0) {
						itemDatabasePosition = 2;
					} else {
						itemDatabasePosition = itemPosition * 6 + 2;
					}
				}
			}
			if (itemName == arrayItemNames[itemPosition]) {
				stuff = main.db.itemsDatabaseArray(main.db.getConnection());
				txtfieldABeautifulEgg.setFont(new Font("Monospaced", Font.BOLD, 35));
				txtfieldABeautifulEgg.setText(stuff[itemDatabasePosition]);
				itemDescPane.setText(stuff[itemDatabasePosition + 3]);
				name = stuff[itemDatabasePosition];
				cost = stuff[itemDatabasePosition + 1];
				textPane.setText("$" + stuff[itemDatabasePosition + 1]);
				if (Integer.parseInt(stuff[itemDatabasePosition + 2]) != 0) {
					txtpnInstockLeft.setText("In-Stock: " + stuff[itemDatabasePosition + 2] + " left");
				} else {
					txtpnInstockLeft.setText("Out-of-stock");
				}
			}
		}

	}
}
