package main;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DB.*;

public class main extends JFrame {
	
	static DatabaseConnection db = new DatabaseConnection();
	private JPanel contentPane;
	static CardLayoutHelper cardLayout = new CardLayoutHelper();
	static main frame = new main();
	static public String info = "";
	static public String currentUser;
	static public String currentUserPosition;
	final static Color myYellow = new Color(228, 216, 116);


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setBackground(myYellow);
					frame.add(cardLayout.getCardPanel());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(1000, 180, 876, 634);
		contentPane = new JPanel();
		contentPane.setBackground(myYellow);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
	
	public static void changePanel(JPanel panel) {
		frame.remove(cardLayout.getCardPanel());
		frame.add(panel);
		cardLayout.setPanel(panel);
	}
	
	public static void resetOnLogout() {
		info = "";
		currentUser = "";
		currentUserPosition = "";
	}
	
	

	
}
