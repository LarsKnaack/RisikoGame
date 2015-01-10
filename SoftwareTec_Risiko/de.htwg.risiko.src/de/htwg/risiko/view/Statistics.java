package de.htwg.risiko.view;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.Collections;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import de.htwg.risiko.model.CountryI;

@SuppressWarnings("serial")
public class Statistics extends JPanel {
	
	private static JTextArea player1;
	private static JTextArea player2;
	
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
		List<CountryI> countriesP1 = GUI.controller.getCurrentPlayer().getCountries();
		Collections.sort(countriesP1);
		for (CountryI c: countriesP1) {
			sbP1.append(c.getSoldiers()).append(" ").append(c.getName()).append("\n");
		}
		StringBuilder sbP2 = new StringBuilder();
		List<CountryI> countriesP2 = GUI.controller.getOpponent().getCountries();
		Collections.sort(countriesP2);
		for (CountryI c: countriesP2) {
			sbP2.append(c.getSoldiers()).append(" ").append(c.getName()).append("\n");
		}
		
		player1.setBorder(BorderFactory.createTitledBorder(GUI.controller.getCurrentPlayer().getName()));
		player2.setBorder(BorderFactory.createTitledBorder(GUI.controller.getOpponent().getName()));

		player1.setText(sbP1.toString());
		player2.setText(sbP2.toString());
	}

}
