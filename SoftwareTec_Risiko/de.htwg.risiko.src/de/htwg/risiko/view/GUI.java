package de.htwg.risiko.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import de.htwg.risiko.controller.IGameEngine;

@SuppressWarnings("serial")
public class GUI extends JFrame {
	
	public static IGameEngine controller;
	
	public GUI(IGameEngine ge) {
		
		controller = ge;
		
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
		
		JPanel control = new ControlPanel();
		
		SpringLayout layout = new SpringLayout();
		mainPanel.setLayout(layout);
		mainPanel.add(gamefield);
		mainPanel.add(statistics);
		mainPanel.add(control);
		layout.putConstraint(SpringLayout.WEST, gamefield, 5, SpringLayout.WEST, mainPanel);
		layout.putConstraint(SpringLayout.NORTH, gamefield, 5, SpringLayout.NORTH, mainPanel);
		layout.putConstraint(SpringLayout.WEST, statistics, 5, SpringLayout.EAST, gamefield);
		layout.putConstraint(SpringLayout.NORTH, statistics, 5, SpringLayout.NORTH, mainPanel);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, control, 0, SpringLayout.HORIZONTAL_CENTER, gamefield);
		layout.putConstraint(SpringLayout.NORTH, control, 0, SpringLayout.SOUTH, gamefield);
		layout.putConstraint(SpringLayout.SOUTH, control, 5, SpringLayout.SOUTH, mainPanel);
		
		this.setContentPane(mainPanel);
		this.setMinimumSize(new Dimension(1000, 560));
		this.pack();
		this.setLocationRelativeTo(null);
		mainPanel.setBackground(Color.RED);
		
		System.out.println(this.getWidth());
		System.out.println(this.getHeight());
		new StartDialog();
	}
}

