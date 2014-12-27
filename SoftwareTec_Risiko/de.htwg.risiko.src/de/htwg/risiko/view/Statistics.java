package de.htwg.risiko.view;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.LinkedList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import de.htwg.risiko.controller.IGameEngine;
import de.htwg.risiko.model.CountryI;
import de.htwg.risiko.model.PlayerI;

@SuppressWarnings("serial")
public class Statistics extends JPanel {
	
	static JTextArea player1;
	static JTextArea player2;
	
	public Statistics() {
		this.setBackground(Color.RED);
		this.setLayout(new GridLayout(1,2));
		player1 = new JTextArea();
		player1.setEditable(false);
		
		
		player2 = new JTextArea();
		player2.setEditable(false);
		player2.setBorder(BorderFactory.createTitledBorder("Player1"));
		
		update();
		this.add(player1);
		this.add(player2);
		this.setVisible(true);
		
	}
	
	public static void update() {
		StringBuilder sbP1 = new StringBuilder();
		for (CountryI c: GUI.controller.getCurrentPlayer().getCountries()) {
			sbP1.append(c.getSoldiers()).append(" ").append(c.getName()).append("\n");
		}
		StringBuilder sbP2 = new StringBuilder();
		for (CountryI c: GUI.controller.getOpponent().getCountries()) {
			sbP2.append(c.getSoldiers()).append(" ").append(c.getName()).append("\n");
		}
		
		player1.setBorder(BorderFactory.createTitledBorder(GUI.controller.getCurrentPlayer().getName()));
		player2.setBorder(BorderFactory.createTitledBorder(GUI.controller.getOpponent().getName()));

		player1.setText(sbP1.toString());
		player2.setText(sbP2.toString());
	}

}
