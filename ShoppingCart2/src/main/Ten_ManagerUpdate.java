package main;

import javax.swing.*;

import main.Nine_ManagerRemove.ButtonListener;
import main.Nine_ManagerRemove.ComboListener;

import java.awt.*;
import java.awt.event.*;

public class Ten_ManagerUpdate extends JPanel {
	private JTextPane txtfieldABeautifulEgg, textPane, txtpnInstockLeft, itemDescPane, itemUpdated, enterNewStock;
	private JTextField txtpnOutOfStock, newStockField;
	private JButton updateItem;
	String name, amount, cost, user;
	String[] arrayItemNames, stuff;
	private JComboBox comboItems;
	int newStockAmount;
	static int itemDatabasePosition;

	public Ten_ManagerUpdate() {
		initialize();
	}

	private void initialize() {

		setBackground(Color.WHITE);
		setBounds(100, 100, 852, 634);
		setLayout(null);
		
		enterNewStock = new JTextPane();
		enterNewStock.setEditable(false);
		enterNewStock.setFont(new Font("Tahoma", Font.PLAIN, 11));
		enterNewStock.setText("Enter New Stock: ");
		enterNewStock.setBounds(445, 330, 95, 20);
		add(enterNewStock);
		
		newStockField = new JTextField();
		newStockField.setBounds(458, 354, 60, 27);
		add(newStockField);
		
		updateItem = new JButton("Update Stock");
		updateItem.setBounds(530, 350, 275, 35);
		updateItem.addActionListener(new ButtonListener());
		add(updateItem);
		
		itemUpdated = new JTextPane();
		itemUpdated.setFont(new Font("Tacoma", Font.ITALIC, 13));
		itemUpdated.setEditable(false);
		itemUpdated.setBounds(458, 500, 350, 20);
		add(itemUpdated);

		JTextPane txtpnShoppingPage = new JTextPane();
		txtpnShoppingPage.setEditable(false);
		txtpnShoppingPage.setFont(new Font("Tahoma", Font.PLAIN, 33));
		txtpnShoppingPage.setBounds(10, 11, 500, 52);
		txtpnShoppingPage.setText("Update Stock");
		add(txtpnShoppingPage);

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
		txtfieldABeautifulEgg.setText("Please choose an item to update...");
		txtfieldABeautifulEgg.setBounds(459, 140, 300, 55);
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

		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 18));
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
		comboItems.setBounds(39, 147, 372, 30);
		comboItems.setMaximumRowCount(15);
		comboItems.addActionListener(new ComboListener());
		add(comboItems);

	}
	
	public class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == updateItem) {
				newStockAmount = Integer.parseInt(newStockField.getText());
				main.db.update(main.db.getConnection(), name, newStockAmount);
				Ten_ManagerUpdate panel = new Ten_ManagerUpdate();
				main.changePanel(panel);
				panel.itemUpdated.setText("There are now " + newStockField.getText() + " " + name + " In Stock.");
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
				txtfieldABeautifulEgg.setFont(new Font("Tahoma", Font.BOLD, 35));
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