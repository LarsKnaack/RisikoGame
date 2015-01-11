package de.htwg.risiko.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;

import de.htwg.risiko.controller.IGameEngine;
import de.htwg.risiko.model.CountryI;

public class MoveDialog {
	
	private static CountryI current;
	
	private JComboBox<CountryI> neighbours;
	private JComboBox<Integer> numberOfSoldiers;
	private static IGameEngine controller = GUI.getController();
	
	public MoveDialog(CountryI c) {
		current = c;
		JDialog main = new JDialog();
		main.setTitle("Please select country");
		neighbours = new JComboBox<CountryI>();
		for (CountryI ci : controller.getNeighbours(current)) {
			neighbours.addItem(ci);
		}
		numberOfSoldiers = new JComboBox<Integer>();
		for(int i = 1; i < controller.getSoldiers(current); i++) {
			numberOfSoldiers.addItem(i);
		}
		JButton moveB = new JButton("Move");
		
		moveB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CountryI target = (CountryI) neighbours.getSelectedItem();
				int num = (int) numberOfSoldiers.getSelectedItem();
				controller.moveSoldiers(num, current, target);
				Statistics.update();
				
			}
		});
		main.add(neighbours, BorderLayout.EAST);
		main.add(numberOfSoldiers, BorderLayout.WEST);
		main.add(moveB, BorderLayout.SOUTH);
		
		main.pack();
		main.setResizable(false);
		main.setVisible(true);
		main.setLocationRelativeTo(null);
	}
}
