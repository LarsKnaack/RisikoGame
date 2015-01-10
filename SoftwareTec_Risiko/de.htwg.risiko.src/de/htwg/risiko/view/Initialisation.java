package de.htwg.risiko.view;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

import de.htwg.risiko.controller.impl.RiskMap;
import de.htwg.risiko.model.CountryI;

public class Initialisation extends JFrame{
	
	public Initialisation() {
		this.addMouseListener(new MouseAdapter(){
			public void MouseClicked(MouseEvent e) {
				Point p = new Point(e.getX(), e.getY());
				CountryI c = RiskMap.check(p);
				if(e.getButton() == 1) {
					
				}
			}
			
		});
		this.setTitle("Select your countries");
	}

	
 
}
