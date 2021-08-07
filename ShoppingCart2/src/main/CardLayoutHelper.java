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
		cardPanel.setBackground(main.myYellow);
		c1 = new CardLayout();
		cardPanel.setLayout(c1);
	
		Zero_Login panelLogin = new Zero_Login();
		//One_CreateAccount panelCreate = new One_CreateAccount();
//		Two_ShoppingPage panelShopping = new Two_ShoppingPage();
//		Three_ShoppingCart panelCart = new Three_ShoppingCart();
//		Four_CheckOut panelCheckOut = new Four_CheckOut();
//		//Five_PendingOrders panelPending = new Five_PendingOrders();
//		Six_LogOut panelLogOut = new Six_LogOut();
		//Seven_Manager panelManager = new Seven_Manager();
		//Eight_ManagerAdd panelMAdd = new Eight_ManagerAdd();
		//Nine_ManagerRemove panelMRemove = new Nine_ManagerRemove();
		//Ten_ManagerUpdate panelMUpdate = new Ten_ManagerUpdate();
		
		cardPanel.add(panelLogin, "panelLogin");
//		cardPanel.add(panelCreate, "panelCreate");
//		cardPanel.add(panelShopping, "panelShopping");
//		cardPanel.add(panelCart, "panelCart");
//		cardPanel.add(panelCheckOut, "panelCheckOut");
//		cardPanel.add(panelLogOut, "panelLogOut");
		//cardPanel.add(panelManager, "panelManager");
		//cardPanel.add(panelMAdd, "panelMAdd");
		//cardPanel.add(panelMRemove, "panelMRemove");
		//cardPanel.add(panelMUpdate, "panelMUpdate");

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
