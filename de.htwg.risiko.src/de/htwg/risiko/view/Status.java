package de.htwg.risiko.view;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import de.htwg.risiko.controller.IGameEngine;

@SuppressWarnings("serial")
public class Status extends JPanel {
	
	private static JTextArea status = new JTextArea();
	private static IGameEngine controller = GUI.getController();
	
	public Status() {
		status.setEditable(false);
		this.setBackground(Color.RED);
		this.add(status);
	}
	
	public static void updateHistory() {
		status.setText(controller.getStatus());
	}

}
