package main;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JButton;

public class Five_PendingOrders extends JPanel {


	public Five_PendingOrders() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JTextPane txtpnPendingOrders = new JTextPane();
		txtpnPendingOrders.setEditable(false);
		txtpnPendingOrders.setFont(new Font("Tahoma", Font.PLAIN, 39));
		txtpnPendingOrders.setText("Pending Orders ");
		txtpnPendingOrders.setBounds(10, 11, 364, 51);
		add(txtpnPendingOrders);
		
		JButton btnNewButton = new JButton("Logout");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(600, 30, 102, 32);
		add(btnNewButton);
		
		JTextPane txtpnOrder = new JTextPane();
		txtpnOrder.setText("Order:");
		txtpnOrder.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnOrder.setEditable(false);
		txtpnOrder.setBackground(Color.LIGHT_GRAY);
		txtpnOrder.setBounds(160, 126, 375, 296);
		add(txtpnOrder);
		
		JButton btnApprove = new JButton("Approve");
		btnApprove.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnApprove.setBounds(545, 126, 102, 22);
		add(btnApprove);
		
		JButton btnNewButton_1_1 = new JButton("Logout");
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_1_1.setBounds(545, 155, 102, 22);
		add(btnNewButton_1_1);
		
		JButton btnUserOne = new JButton("User 1: Jake");
		btnUserOne.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnUserOne.setBounds(10, 126, 120, 32);
		add(btnUserOne);
		
		JButton btnUserDrake = new JButton("User 2: Drake");
		btnUserDrake.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnUserDrake.setBounds(10, 169, 120, 32);
		add(btnUserDrake);
		
		JButton btnUserRob = new JButton("User 3: Rob");
		btnUserRob.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnUserRob.setBounds(10, 212, 120, 32);
		add(btnUserRob);
		
		JButton btnUserJessica = new JButton("User 4: Jessica");
		btnUserJessica.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnUserJessica.setBounds(10, 255, 120, 32);
		add(btnUserJessica);
		
		JButton btnUserPeter = new JButton("User 5: Peter");
		btnUserPeter.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnUserPeter.setBounds(10, 298, 120, 32);
		add(btnUserPeter);
		
		JButton btnUserKylie = new JButton("User 6: Kylie");
		btnUserKylie.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnUserKylie.setBounds(10, 341, 120, 32);
		add(btnUserKylie);
		
		JButton btnUserRalph = new JButton("User 7: Ralph");
		btnUserRalph.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnUserRalph.setBounds(10, 384, 120, 32);
		add(btnUserRalph);

	}

}