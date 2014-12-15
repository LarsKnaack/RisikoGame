package de.htwg.risiko.view;

import java.awt.FlowLayout;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GUI extends JFrame {
	
	public GUI() {
		this.addMouseListener(new RiskMouseListener());
		this.setTitle("Risiko Game");
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel mainPanel = new JPanel();
		mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
		
		URL img = GUI.class.getResource("Risk.jpg");
		JLabel backround = new JLabel(new ImageIcon(img));
		backround.setLayout(new FlowLayout());
		mainPanel.add(backround);
		
		this.setContentPane(mainPanel);
		this.pack();
	}
}

