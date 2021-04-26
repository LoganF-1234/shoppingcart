package main;

import java.awt.CardLayout;

import javax.swing.JPanel;

import java.awt.CardLayout;

import javax.swing.JPanel;

public class CardLayoutHelper {
	private CardLayout c1;
 	private JPanel cardPanel;
 	
	public CardLayoutHelper() {
		cardPanel = new JPanel();
		c1 = new CardLayout();
		cardPanel.setLayout(c1);
	
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

	}
	
	public void showCard(String cardName) {
		c1.show(cardPanel, cardName);
	}
	
	public JPanel getCardPanel() {
		return cardPanel;
	}
	
	public void setPanel(JPanel panel) {
		cardPanel = panel;
	}
}