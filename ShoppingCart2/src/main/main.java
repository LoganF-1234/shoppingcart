package main;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class main {
	public static void main(String[] args) {
		
		CardLayoutHelper cardLayout = new CardLayoutHelper();
		  
		  
		/*
		 * 
		 *  //Panel Objects
		 *
		One_CreateAccount panelCreate = new One_CreateAccount();
		Two_ShoppingPage panelShopping = new Two_ShoppingPage();
		Three_ShoppingCart panelCart = new Three_ShoppingCart();
		Four_CheckOut panelCheckOut = new Four_CheckOut();
		//Five_PendingOrders panelPending = new Five_PendingOrders();
		Six_LogOut panelLogOut = new Six_LogOut();
		
		cardPanel.add(panelCreate, "panelCreate");
		cardPanel.add(panelShopping, "panelShopping");
		cardPanel.add(panelCart, "panelCart");
		cardPanel.add(panelCheckOut, "panelCheckOut");
		cardPanel.add(panelLogOut, "panelLogOut");
		*
		*
		*/
 		JFrame frame = new JFrame("ShoppingCart");
		
		frame.add(cardLayout.getCardPanel());
		frame.setVisible(true);
		//frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 852, 634);
		


	}
	
	/*public class SwitchPage implements ActionListener{
		//cardafter
		public SwitchPage(////cardafter) {
			//this.cardafter = cardafter
		}
		public void actionPerformed(ActionEvent event) {
			//c1.show(cardafter)
			}
		} */
}
