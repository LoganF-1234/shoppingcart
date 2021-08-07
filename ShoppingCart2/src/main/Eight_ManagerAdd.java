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
		
		setBackground(main.myYellow);
		setBounds(100, 100, 852, 634);
		setLayout(null);
		
		titlePane = new JTextPane();
		titlePane.setFont(new Font("Monospaced", Font.BOLD, 36));
		titlePane.setBackground(main.myYellow);
		titlePane.setEditable(false);
		titlePane.setText("Add Item to Inventory: ");
		titlePane.setBounds(180, 25, 600, 52);
		add(titlePane);
		
		namePane = new JTextPane();
		namePane.setBounds(200, 150, 150, 30);
		namePane.setEditable(false);
		namePane.setFont(new Font("Monospaced", Font.PLAIN, 20));
		namePane.setBackground(main.myYellow);
		namePane.setText("Name: ");
		add(namePane);
		
		typePane = new JTextPane();
		typePane.setBounds(200, 200, 150, 30);
		typePane.setEditable(false);
		typePane.setFont(new Font("Monospaced", Font.PLAIN, 20));
		typePane.setBackground(main.myYellow);
		typePane.setText("Type: ");
		add(typePane);
		
		pricePane = new JTextPane();
		pricePane.setBounds(200, 250, 150, 30);
		pricePane.setEditable(false);
		pricePane.setFont(new Font("Monospaced", Font.PLAIN, 20));
		pricePane.setBackground(main.myYellow);
		pricePane.setText("Price: ");
		add(pricePane);
		
		amountPane = new JTextPane();
		amountPane.setBounds(200, 300, 150, 30);
		amountPane.setEditable(false);
		amountPane.setText("Amount: ");
		amountPane.setFont(new Font("Monospaced", Font.PLAIN, 20));
		amountPane.setBackground(main.myYellow);
		add(amountPane);
		
		descPane = new JTextPane();
		descPane.setBounds(200, 350, 150, 30);
		descPane.setEditable(false);
		descPane.setFont(new Font("Monospaced", Font.PLAIN, 20));
		descPane.setBackground(main.myYellow);
		descPane.setText("Description: ");
		add(descPane);
		
		nameField = new JTextField();
		nameField.setBounds(390, 150, 250, 30);
		nameField.setFont(new Font("Monospaced", Font.PLAIN, 20));
		nameField.setBackground(Color.LIGHT_GRAY);
		nameField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		add(nameField);
		
		typeField = new JTextField();
		typeField.setBounds(390, 200, 250, 30);
		typeField.setFont(new Font("Monospaced", Font.PLAIN, 20));
		typeField.setBackground(Color.LIGHT_GRAY);
		typeField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		add(typeField);
		
		priceField = new JTextField();
		priceField.setBounds(390, 250, 250, 30);
		priceField.setText("");
		priceField.setFont(new Font("Monospaced", Font.PLAIN, 20));
		priceField.setBackground(Color.LIGHT_GRAY);
		priceField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		add(priceField);
		
		amountField = new JTextField();
		amountField.setBounds(390, 300, 250, 30);
		amountField.setText("");
		amountField.setFont(new Font("Monospaced", Font.PLAIN, 20));
		amountField.setBackground(Color.LIGHT_GRAY);
		amountField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		add(amountField);
		
		descField = new JTextField();
		descField.setBounds(390, 350, 250, 30);
		descField.setFont(new Font("Monospaced", Font.PLAIN, 20));
		descField.setBackground(Color.LIGHT_GRAY);
		descField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		add(descField);
		
		backButton = new JButton("Back");
		backButton.setFont(new Font("Monospaced", Font.PLAIN, 18));
		backButton.setBounds(650, 500, 151, 34);		
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
		addButton.setFont(new Font("Monospaced", Font.PLAIN, 18));
		addButton.setBounds(350, 425, 151, 34);	
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


