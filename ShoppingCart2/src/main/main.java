package main;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

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

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					frame.add(cardLayout.getCardPanel());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void changePanel(JPanel panel) {
		frame.remove(cardLayout.getCardPanel());
		frame.add(panel);
		cardLayout.setPanel(panel);
	}


	public main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 852, 634);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
