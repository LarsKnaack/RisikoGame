package de.htwg.risiko.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import de.htwg.risiko.controller.IGameEngine;
import de.htwg.risiko.model.CountryI;

public class RecruitmentDialog {
	
	private JLabel lableMaxRec;
	private JTextField recruitment;
	private CountryI current;
	private static final int LENGTH = 20;
	private static IGameEngine controller = GUI.getController();

	public RecruitmentDialog(CountryI c) {
		
		current = c;
		
		JDialog main = new JDialog();
		
		StringBuilder sb = new StringBuilder();
		sb.append("Recruitment available ").append(controller.getMaxRecruitment());
		
		lableMaxRec = new JLabel(sb.toString());
		recruitment = new JTextField(LENGTH);
		JButton add = new JButton("Add");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int i = Integer.parseInt(recruitment.getText());
				
				if (controller.selectRecruitment(current, i)){
					controller.recruit();
				}
				
				StringBuilder sb = new StringBuilder();
				sb.append("Recruitment available ").append(controller.getMaxRecruitment());
				lableMaxRec.setText(sb.toString());
			}
		});
		
		main.add(lableMaxRec, BorderLayout.WEST);
		main.add(recruitment, BorderLayout.EAST);
		main.add(add, BorderLayout.SOUTH);
		
		main.pack();
		main.setVisible(true);
		
		main.setLocationRelativeTo(null);
		
		// TODO Auto-generated constructor stub
		
	}

}
