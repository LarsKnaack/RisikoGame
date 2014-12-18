package de.htwg.risiko.view;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


public class RiskMouseListener implements MouseListener, MouseMotionListener {
	
	private PopUpMenu menu;

	@Override
	public void mouseClicked(MouseEvent e) {
		Point p = new Point(e.getX(), e.getY());
		if(e.getButton() == 3 && Coordinates.check(p) != null) {
			menu = new PopUpMenu();
			menu.showMenu(e);
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
