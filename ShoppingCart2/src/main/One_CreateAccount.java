package main;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.AbstractListModel;

public class One_CreateAccount extends JPanel{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	CardLayoutHelper cardLayout = new CardLayoutHelper();
	


	public One_CreateAccount() {
		
		setBackground(Color.WHITE);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		JTextArea txtrCreateAnAccount = new JTextArea();
		txtrCreateAnAccount.setEditable(false);
		txtrCreateAnAccount.setFont(new Font("Monospaced", Font.PLAIN, 17));
		txtrCreateAnAccount.setText("Create an Account");
		txtrCreateAnAccount.setBounds(261, 11, 250, 22);
		add(txtrCreateAnAccount);
		
		JTextArea txtrFirstName = new JTextArea();
		txtrFirstName.setEditable(false);
		txtrFirstName.setBackground(Color.GRAY);
		txtrFirstName.setText("First Name:");
		txtrFirstName.setBounds(77, 158, 168, 22);
		add(txtrFirstName);
		
		JTextArea txtrLastName = new JTextArea();
		txtrLastName.setEditable(false);
		txtrLastName.setText("Last Name:");
		txtrLastName.setBackground(Color.GRAY);
		txtrLastName.setBounds(77, 191, 168, 22);
		add(txtrLastName);
		
		JTextArea txtrUsername = new JTextArea();
		txtrUsername.setEditable(false);
		txtrUsername.setText("Username:");
		txtrUsername.setBackground(Color.GRAY);
		txtrUsername.setBounds(77, 224, 168, 22);
		add(txtrUsername);
		
		JTextArea txtrPassword = new JTextArea();
		txtrPassword.setEditable(false);
		txtrPassword.setText("Password:");
		txtrPassword.setBackground(Color.GRAY);
		txtrPassword.setBounds(77, 257, 168, 22);
		add(txtrPassword);
		
		JTextArea txtrAddress = new JTextArea();
		txtrAddress.setText("Address:");
		txtrAddress.setEditable(false);
		txtrAddress.setBackground(Color.GRAY);
		txtrAddress.setBounds(77, 290, 168, 22);
		add(txtrAddress);
		
		textField = new JTextField();
		textField.setBounds(290, 158, 250, 22);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(290, 191, 250, 22);
		add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(290, 224, 250, 22);
		add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(290, 257, 250, 22);
		add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(290, 290, 250, 22);
		add(textField_4);
	
		JButton btnNewButton = new JButton("Create Account");
		btnNewButton.setBounds(560, 404, 128, 31);
		//btnNewButton.addActionListener(new SwitchPage("panelShopping"));
		add(btnNewButton);
		
		JList list = new JList();
		list.setFont(new Font("Tahoma", Font.PLAIN, 14));
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Customer", "Employee", "Manager"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(560, 53, 90, 67);
		add(list);
		
		JTextArea txtrPosition = new JTextArea();
		txtrPosition.setEditable(false);
		txtrPosition.setText("Position:");
		txtrPosition.setBounds(545, 20, 95, 22);
		add(txtrPosition);
		
		//cardLayout.getCardPanel().add(new One_CreateAccount());
		
		
	}
	
	public class SwitchPage extends CardLayoutHelper implements ActionListener{
		//CardLayoutHelper cardLayout = new CardLayoutHelper();
		String cardName;
		
		public SwitchPage(String cardName) {
			this.cardName = cardName;
		}
		
		public void actionPerformed(ActionEvent event) {
			showCard(cardName);
			}
		} 
}