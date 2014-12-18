package de.htwg.risiko.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

@SuppressWarnings("serial")
public class GUI extends JFrame {
	
	public GUI() {
		
		this.addMouseListener(new RiskMouseListener());
		this.setTitle("Risk Game");
		this.setResizable(true);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel mainPanel = new JPanel();
		
		JPanel gamefield = new JPanel();
		gamefield.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		gamefield.setLayout(new BoxLayout(gamefield, BoxLayout.PAGE_AXIS));
		URL img = GUI.class.getResource("Risk.jpg");
		JLabel backround = new JLabel(new ImageIcon(img));
		backround.setLayout(new FlowLayout());
		gamefield.add(backround);
		gamefield.setMinimumSize(new Dimension(697, 445));
		
		JPanel statistics = new Statistics();
		statistics.setBorder(BorderFactory.createTitledBorder("Statistics"));
		
		SpringLayout layout = new SpringLayout();
		mainPanel.setLayout(layout);
		mainPanel.add(gamefield);
		mainPanel.add(statistics);
		layout.putConstraint(SpringLayout.WEST, gamefield, 5, SpringLayout.WEST, mainPanel);
		layout.putConstraint(SpringLayout.NORTH, gamefield, 5, SpringLayout.NORTH, mainPanel);
		layout.putConstraint(SpringLayout.WEST, statistics, 5, SpringLayout.EAST, gamefield);
		layout.putConstraint(SpringLayout.NORTH, statistics, 5, SpringLayout.NORTH, mainPanel);
		
		this.setContentPane(mainPanel);
		this.setMinimumSize(new Dimension(1100, 500));
		this.pack();
		this.setLocationRelativeTo(null);
		mainPanel.setBackground(Color.RED);
		
		System.out.println(this.getWidth());
		System.out.println(this.getHeight());
		new StartDialog();
	}
}

