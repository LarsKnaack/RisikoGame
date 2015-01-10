package de.htwg.risiko.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import de.htwg.risiko.model.CountryI;

public class RecruitmentDialog implements ActionListener{
	
	private JLabel lableMaxRec;
	private JTextField recruitment;
	private JButton add;
	private CountryI current;
	private static final int LENGTH = 20;

	public RecruitmentDialog(CountryI c) {
		
		current = c;
		
		JDialog main = new JDialog();
		
		StringBuilder sb = new StringBuilder();
		sb.append("Recruitment available ").append(GUI.controller.getMaxRecruitment());
		
		lableMaxRec = new JLabel(sb.toString());
		recruitment = new JTextField(LENGTH);
		add = new JButton("Add");
		add.addActionListener(this);
		
		main.add(lableMaxRec, BorderLayout.WEST);
		main.add(recruitment, BorderLayout.EAST);
		main.add(add, BorderLayout.SOUTH);
		
		main.pack();
		main.setVisible(true);
		
		main.setLocationRelativeTo(null);
		
		// TODO Auto-generated constructor stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		int i = Integer.parseInt(recruitment.getText());
		
		if (GUI.controller.selectRecruitment(current, i)){
			GUI.controller.recruit();
			Statistics.update();
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("Recruitment available ").append(GUI.controller.getMaxRecruitment());
		lableMaxRec.setText(sb.toString());
	}

}
