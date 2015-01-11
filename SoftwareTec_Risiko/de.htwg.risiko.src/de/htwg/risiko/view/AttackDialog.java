package de.htwg.risiko.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import de.htwg.risiko.controller.IGameEngine;
import de.htwg.risiko.model.CountryI;

@SuppressWarnings("serial")
public class AttackDialog extends JDialog implements ActionListener{
	
	private JComboBox<CountryI> neighbours;
	private JButton attack;
	private JDialog myDialog;
	private static IGameEngine controller = GUI.getController();

	public AttackDialog(CountryI current) {
		
		controller.selectAttacker(current);
		
		myDialog = new JDialog(this, "Attack");
		attack = new JButton("Attack");
		attack.addActionListener(this);
		
		neighbours = new JComboBox<CountryI>();
		for(CountryI c : controller.getCandidates(current)) {
			neighbours.addItem(c);
		}
		neighbours.setEditable(false);
		myDialog.add(neighbours, BorderLayout.WEST);
		myDialog.add(attack, BorderLayout.SOUTH);
		
		myDialog.pack();
		myDialog.setVisible(true);
		myDialog.setLocationRelativeTo(null);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		try{
			controller.selectTarget((CountryI) neighbours.getSelectedItem());
			controller.invade();
			
			Statistics.update();
			myDialog.dispose();
			int res = JOptionPane.showConfirmDialog(this, "Do you want to end your Invade Turn?");
			if (res == JOptionPane.YES_OPTION) {
				controller.endTurn();
			}
		} catch(IllegalArgumentException x) {
			JOptionPane.showMessageDialog(this, x.getMessage());
		}
	}
}
