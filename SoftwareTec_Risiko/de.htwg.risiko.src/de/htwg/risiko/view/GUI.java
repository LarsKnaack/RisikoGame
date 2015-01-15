package de.htwg.risiko.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import com.google.inject.Inject;

import de.htwg.risiko.controller.IGameEngine;
import de.htwg.risiko.model.CountryI;
import de.htwg.risiko.util.observer.IObserver;

@SuppressWarnings("serial")
public class GUI extends JFrame implements IObserver {
	
	private static IGameEngine controller;
	
	private static final Dimension D_GAMEFIELD = new Dimension(697, 445);
	private static final Dimension D_FRAME = new Dimension(1000, 560);
	private static final int BORDER_SPRING = 5;

	@Inject
	public GUI(final IGameEngine ge) {
		
		controller = ge;
		controller.addObserver(this);
		
		this.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Point p = new Point(e.getX(), e.getY());
				CountryI country = controller.check(p);
				if(e.getButton() == 1 && controller.getCountries(controller.getCurrentPlayer()).contains(country)) {
					ControlPanel.setCurrentCountry(country);
					ControlPanel.updateTitle(country.getName());
				}
			}
		});
		
		this.setTitle("Risk Game");
		this.setResizable(true);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel mainPanel = new JPanel();
		JPanel gamefield = new JPanel();
		gamefield.setBorder(BorderFactory.createEmptyBorder());
		gamefield.setLayout(new BoxLayout(gamefield, BoxLayout.PAGE_AXIS));
		URL img = GUI.class.getResource("Risk.jpg");
		JLabel backround = new JLabel(new ImageIcon(img));
		backround.setLayout(new FlowLayout());
		gamefield.add(backround);
		gamefield.setMinimumSize(D_GAMEFIELD);
		
		JPanel statistics = new Statistics();
		statistics.setBorder(BorderFactory.createTitledBorder("Statistics"));
		
		JPanel status = new Status();
		status.setBorder(BorderFactory.createTitledBorder("Status"));
		
		JPanel control = new ControlPanel();
		
		SpringLayout layout = new SpringLayout();
		mainPanel.setLayout(layout);
		mainPanel.add(gamefield);
		mainPanel.add(statistics);
		mainPanel.add(control);
		mainPanel.add(status);
		layout.putConstraint(SpringLayout.WEST, gamefield, BORDER_SPRING, SpringLayout.WEST, mainPanel);
		layout.putConstraint(SpringLayout.NORTH, gamefield, BORDER_SPRING, SpringLayout.NORTH, mainPanel);
		layout.putConstraint(SpringLayout.WEST, statistics, BORDER_SPRING, SpringLayout.EAST, gamefield);
		layout.putConstraint(SpringLayout.NORTH, statistics, BORDER_SPRING, SpringLayout.NORTH, mainPanel);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, control, 0, SpringLayout.HORIZONTAL_CENTER, gamefield);
		layout.putConstraint(SpringLayout.NORTH, control, 0, SpringLayout.SOUTH, gamefield);
		layout.putConstraint(SpringLayout.SOUTH, control, BORDER_SPRING, SpringLayout.SOUTH, mainPanel);
		layout.putConstraint(SpringLayout.NORTH, status, BORDER_SPRING, SpringLayout.SOUTH, statistics);
		layout.putConstraint(SpringLayout.WEST, status, BORDER_SPRING, SpringLayout.EAST, gamefield);
		
		this.setContentPane(mainPanel);
		this.setMinimumSize(D_FRAME);
		this.pack();
		this.setLocationRelativeTo(null);
		mainPanel.setBackground(Color.RED);
		
		new StartDialog();
	}

	@Override
	public void update() {
		Statistics.update();
		Status.updateHistory();
	}
	
	public static IGameEngine getController() {
		return controller;
	}
}

