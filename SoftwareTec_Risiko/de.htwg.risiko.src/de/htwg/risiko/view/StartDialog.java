package de.htwg.risiko.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import de.htwg.risiko.controller.GameEngine;
import de.htwg.risiko.model.PlayerI;

@SuppressWarnings("serial")
public class StartDialog extends JDialog implements ActionListener {
	
	public static String player1;
	public static String player2;
	
	private JButton bConfirmP1;
	private JButton bConfirmP2;
	
	private JTextField player1Tf;
	private JTextField player2Tf;
	
	private JDialog player1Dialog;
	private JDialog player2Dialog;
	
	public StartDialog() {
		player1Dialog = new JDialog(this);
		player2Dialog = new JDialog(this);
		JLabel lPlayer1Tf = new JLabel("Name of Player 1");
		player1Tf = new JTextField(20);
		JLabel lPlayer2Tf = new JLabel("Name of Player 2");
		player2Tf = new JTextField(20);
		bConfirmP2 = new JButton("Start Game");
		bConfirmP1 = new JButton("Save Player 1");
		bConfirmP1.addActionListener(this);
		bConfirmP2.addActionListener(this);
		
		player1Dialog.add(lPlayer1Tf, BorderLayout.WEST);
		player1Dialog.add(player1Tf, BorderLayout.EAST);
		player1Dialog.add(bConfirmP1, BorderLayout.SOUTH);
		player2Dialog.add(lPlayer2Tf, BorderLayout.WEST);
		player2Dialog.add(player2Tf, BorderLayout.EAST);
		player2Dialog.add(bConfirmP2, BorderLayout.SOUTH);
		
		player1Dialog.pack();
		player1Dialog.setResizable(false);
		player1Dialog.setVisible(true);
		player1Dialog.setLocationRelativeTo(null);
		
		player2Dialog.pack();
		player2Dialog.setResizable(false);
		player2Dialog.setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
		if(source == bConfirmP1) {
			player1 = new String(player1Tf.getText());
			GameEngine.player1.setName(player1);
			player1Dialog.dispose();
			player2Dialog.setVisible(true);
		} else {
			player2 = new String(player2Tf.getText());
			player2Dialog.dispose();
			Coordinates.setCoordinates();
			GameEngine.player2.setName(player2);
			GameEngine.startGame();
			Statistics.update();
		}
	}

}
