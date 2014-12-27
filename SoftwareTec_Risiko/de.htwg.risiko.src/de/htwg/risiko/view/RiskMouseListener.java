package de.htwg.risiko.view;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.BorderFactory;

import de.htwg.risiko.RiskMap;
import de.htwg.risiko.model.CountryI;


public class RiskMouseListener implements MouseListener, MouseMotionListener {
	
	private PopUpMenu menu;
	private CountryI country;

	@Override
	public void mouseClicked(MouseEvent e) {
		Point p = new Point(e.getX(), e.getY());
		country = RiskMap.check(p);
		if(e.getButton() == 3 && country != null) {
			menu = new PopUpMenu();
			menu.showMenu(e);
		} else if(e.getButton() == 1 && country != null) {
			ControlPanel.setCurrentCountry(country);
			ControlPanel.updateTitle(country.getName());
			
		} else {
			if(!(menu == null)) {
				menu.desappearMenu();
			}
			
		}
	
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
	}

}
