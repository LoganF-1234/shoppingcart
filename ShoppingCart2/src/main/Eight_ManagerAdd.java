package main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Eight_ManagerAdd extends JPanel {
	private JTextPane namePane, typePane, pricePane, descPane, amountPane, titlePane;
	private JTextField nameField, typeField, priceField, amountField, descField;
	private JButton addButton, backButton;
	
	public Eight_ManagerAdd() {
		
		setBackground(Color.WHITE);
		setBounds(100, 100, 852, 634);
		setLayout(null);
		
		titlePane = new JTextPane();
		titlePane.setFont(new Font("Tahoma", Font.PLAIN, 33));
		titlePane.setEditable(false);
		titlePane.setText("Add Item to Inventory: ");
		titlePane.setBounds(10, 11, 600, 40);
		add(titlePane);
		
		namePane = new JTextPane();
		namePane.setBounds(100, 150, 200, 30);
		namePane.setEditable(false);
		namePane.setFont(new Font("Tahoma", Font.PLAIN, 20));
		namePane.setText("Name of item: ");
		add(namePane);
		
		typePane = new JTextPane();
		typePane.setBounds(100, 200, 200, 30);
		typePane.setEditable(false);
		typePane.setFont(new Font("Tahoma", Font.PLAIN, 20));
		typePane.setText("Type of Item: ");
		add(typePane);
		
		pricePane = new JTextPane();
		pricePane.setBounds(100, 250, 200, 30);
		pricePane.setEditable(false);
		pricePane.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pricePane.setText("Price of item: ");
		add(pricePane);
		
		amountPane = new JTextPane();
		amountPane.setBounds(100, 300, 200, 30);
		amountPane.setEditable(false);
		amountPane.setText("Amount of item: ");
		amountPane.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(amountPane);
		
		descPane = new JTextPane();
		descPane.setBounds(100, 350, 200, 30);
		descPane.setEditable(false);
		descPane.setFont(new Font("Tahoma", Font.PLAIN, 20));
		descPane.setText("Description of Item: ");
		add(descPane);
		
		nameField = new JTextField();
		nameField.setBounds(300, 150, 250, 30);
		nameField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(nameField);
		
		typeField = new JTextField();
		typeField.setBounds(300, 200, 250, 30);
		typeField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(typeField);
		
		priceField = new JTextField();
		priceField.setBounds(300, 250, 250, 30);
		priceField.setText("");
		priceField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(priceField);
		
		amountField = new JTextField();
		amountField.setBounds(300, 300, 250, 30);
		amountField.setText("");
		amountField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(amountField);
		
		descField = new JTextField();
		descField.setBounds(300, 350, 250, 30);
		descField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(descField);
		
		backButton = new JButton("Back");
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		backButton.setBounds(650, 66, 151, 34);		
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == backButton) {
					Seven_Manager panel = new Seven_Manager();
					main.changePanel(panel);
				}
			}
		});
		add(backButton);
		
		addButton = new JButton("Add Item");
		addButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		addButton.setBounds(200, 425, 151, 34);	
		addButton.addActionListener(new ButtonListener());
		add(addButton);
		
	}
	
	public class ButtonListener implements ActionListener {
		int id; //need to specify since it automatically assumes the id starts at one
		String name;
		String type;
		String tempPrice;
		String tempAmount;
		String description;
		double price;
		int amount;
		public void actionPerformed(ActionEvent e) {
			id = main.db.nextUniqueID() + 1; // get the id of the last item in out items table and add one to it for a new id
			name = nameField.getText();
			type = typeField.getText();
			tempPrice = priceField.getText();
			tempAmount = amountField.getText();
			description = descField.getText();
			if(!(name.equals("") || type.equals("") || tempPrice.equals("") || tempAmount.equals("")|| description.equals(""))) {
				price = Double.parseDouble(tempPrice);
				amount = Integer.parseInt(tempAmount);
				main.db.insertitems(main.db.getConnection(), id, type, name, price, amount, description);
			} else{
				resetItems();
				System.out.println("No data inserted");
			}
		
		}
	}
	
	public void resetItems() {
		nameField.setText("");
		typeField.setText("");
		priceField.setText("");
		amountField.setText("");
		descField.setText("");

	}
}


