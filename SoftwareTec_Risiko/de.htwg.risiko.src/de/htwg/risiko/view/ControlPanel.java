package de.htwg.risiko.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import de.htwg.risiko.model.CountryI;

@SuppressWarnings("serial")
public class ControlPanel extends JPanel implements ActionListener {
	
	static JPanel mainPanel = new JPanel();
	
	JButton attackB;
	JButton addRecB;
	JButton moveSoldiersB;
	JButton endTurn;
	public static TitledBorder tb = BorderFactory.createTitledBorder("Land");
	private static CountryI current;
	
	public ControlPanel() {
		//mainPanel = new JPanel();
		this.setBackground(Color.RED);
		mainPanel.setBackground(Color.RED);
		mainPanel.setBorder(tb);
		attackB = new JButton("Attack ...");
		attackB.addActionListener(this);
		addRecB = new JButton("Add Recruitment");
		addRecB.addActionListener(this);
		moveSoldiersB = new JButton("Move Soldiers to ...");
		moveSoldiersB.addActionListener(this);
		endTurn = new JButton("End Turn");
		endTurn.addActionListener(this);
		mainPanel.add(attackB);
		mainPanel.add(addRecB);
		mainPanel.add(moveSoldiersB);
		mainPanel.add(endTurn);
		this.add(mainPanel);
	}
	
	public static void updateTitle(String s) {
		tb.setTitle(s);
		mainPanel.repaint();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
		if (source == endTurn) {
			GUI.controller.changePlayer();
			Statistics.update();
		} else if(source == addRecB) {
			new RecruitmentDialog(current);
		} else {
			new AttackDialog(current);
		}
	}

	public static void setCurrentCountry(CountryI country) {
		current = country;
	}
}
