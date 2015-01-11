package de.htwg.risiko.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import de.htwg.risiko.controller.IGameEngine;

public class StartDialog {
	
	private static IGameEngine controller = GUI.getController();
	
	private JTextField player1Tf;
	private JTextField player2Tf;
	
	private JDialog player1Dialog;
	private JDialog player2Dialog;
	private static final int LENGTH = 20;
	
	public StartDialog() {
		
		player1Dialog = new JDialog();
		player2Dialog = new JDialog();
		JLabel lPlayer1Tf = new JLabel("Name of Player 1");
		player1Tf = new JTextField(LENGTH);
		JLabel lPlayer2Tf = new JLabel("Name of Player 2");
		player2Tf = new JTextField(LENGTH);
		JButton bConfirmP2 = new JButton("Start Game");
		JButton bConfirmP1 = new JButton("Save Player 1");
		
		bConfirmP1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.startGame();
				String player1 = new String(player1Tf.getText());
				controller.getCurrentPlayer().setName(player1);
				player1Dialog.dispose();
				player2Dialog.setVisible(true);
			}
		});
		
		bConfirmP2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String player2 = new String(player2Tf.getText());
				controller.getOpponent().setName(player2);
				player2Dialog.dispose();
				Statistics.update();
			}
		});
		
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
}
