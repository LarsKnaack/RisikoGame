package de.htwg.risiko.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;

import de.htwg.risiko.controller.IGameEngine;
import de.htwg.risiko.model.ICountry;

public class RecruitmentDialog {
	
	private ICountry current;
	private static IGameEngine controller = GUI.getController();

	public RecruitmentDialog(ICountry c) {
		
		current = c;
		
		JDialog main = new JDialog();
		String title = "Add Soldiers to " + current.getName()+ " ";
		main.setTitle(title);
		
		final JComboBox<Integer> number = new JComboBox<Integer>();
		setItems(number);
		
		
		StringBuilder sb = new StringBuilder();
		sb.append("Add Soldiers to ").append(current.getName());
		
		JLabel country = new JLabel(sb.toString());
		JButton add = new JButton("Add");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(current != null) {
					int i = (int) number.getSelectedItem();
					
					if (controller.selectRecruitment(current, i)){
						controller.recruit();
					}
					setItems(number);
				}
			}
		});
		
		main.add(country, BorderLayout.WEST);
		main.add(number, BorderLayout.EAST);
		main.add(add, BorderLayout.SOUTH);
		
		main.pack();
		main.setVisible(true);
		main.setLocationRelativeTo(null);
		
	}

	private void setItems(JComboBox<Integer> number) {
		number.removeAllItems();
		for (int i = 1; i <= controller.getMaxRecruitment(); i++) {
			number.addItem(i);
		}
	}

}
