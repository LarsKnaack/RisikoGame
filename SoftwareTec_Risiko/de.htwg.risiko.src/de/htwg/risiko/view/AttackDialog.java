package de.htwg.risiko.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import de.htwg.risiko.controller.IGameEngine;
import de.htwg.risiko.model.ICountry;

public class AttackDialog {
	
	private JComboBox<ICountry> neighbours;
	private JDialog myDialog;
	private static IGameEngine controller = GUI.getController();

	public AttackDialog(ICountry current) {
		
		controller.selectAttacker(current);
		
		myDialog = new JDialog();
		JButton attack = new JButton("Attack");
		attack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					controller.selectTarget((ICountry) neighbours.getSelectedItem());
					controller.invade();
					
					myDialog.dispose();
					int res = JOptionPane.showConfirmDialog(new JFrame(), "Do you want to end your Invade Turn?");
					if (res == JOptionPane.YES_OPTION) {
						controller.endTurn();
					}
				} catch(IllegalArgumentException x) {
					JOptionPane.showMessageDialog(new JFrame(), x.getMessage());
				}
			}
		});
		
		neighbours = new JComboBox<ICountry>();
		for(ICountry c : controller.getCandidates(current)) {
			neighbours.addItem(c);
		}
		neighbours.setEditable(false);
		myDialog.add(neighbours, BorderLayout.NORTH);
		myDialog.add(attack, BorderLayout.SOUTH);
		
		myDialog.pack();
		myDialog.setVisible(true);
		myDialog.setLocationRelativeTo(null);
		
	}
}
