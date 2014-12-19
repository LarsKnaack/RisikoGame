package de.htwg.risiko.view;

import java.awt.GridLayout;
import java.util.LinkedList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import de.htwg.risiko.controller.IGameEngine;

@SuppressWarnings("serial")
public class Statistics extends JPanel {
	
	static JTextArea player1;
	static JTextArea player2;
	
	public Statistics() {
		this.setLayout(new GridLayout(1,2));
		player1 = new JTextArea();
		player1.setEditable(false);
		
		
		player2 = new JTextArea();
		player2.setEditable(false);
		player2.setBorder(BorderFactory.createTitledBorder(GameEngine.player2.getName()));
		
		update();
		this.add(player1);
		this.add(player2);
		this.setVisible(true);
		
	}
	
	public static void update() {
		StringBuilder sbP1 = new StringBuilder();
		StringBuilder sbP2 = new StringBuilder();
		List<String> l = new LinkedList<String>();
		l.addAll(Coordinates.getCountries());
		int i = 0;
		for(String s : l) {
			if (i % 2 == 0) {
				sbP1.append(s);
				sbP1.append("\n");
				i++;
			} else {
				sbP2.append(s);
				sbP2.append("\n");
				i++;
			}
		}
		player1.setBorder(BorderFactory.createTitledBorder(GameEngine.player1.getName()));
		player2.setBorder(BorderFactory.createTitledBorder(GameEngine.player2.getName()));

		player1.setText(sbP1.toString());
		player2.setText(sbP2.toString());
	}

}
