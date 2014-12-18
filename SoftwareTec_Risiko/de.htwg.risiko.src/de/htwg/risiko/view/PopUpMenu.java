package de.htwg.risiko.view;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

@SuppressWarnings("serial")
public class PopUpMenu extends JFrame implements ActionListener {

	private JPopupMenu main;
	private JLabel country;
	private JMenuItem add;
	private JMenuItem remove;
	
	public PopUpMenu() {
		main = new JPopupMenu();
		add = new JMenuItem("Add Army");
		add.addActionListener(this);
		remove = new JMenuItem("Remove Army");
		remove.addActionListener(this);
	}
	
	public void showMenu(MouseEvent e) {
		country = new JLabel(Coordinates.check(new Point(e.getX(), e.getY())).toUpperCase());
		main.add(country);
		main.addSeparator();
		main.add(add);
		main.add(remove);
		main.show(e.getComponent(), e.getX(), e.getY());
	}
	
	public void desappearMenu() {
		main.setVisible(false);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if (source == add) {
			new ArmyDialogs("Add");
		}
		if (source == remove) {
			new ArmyDialogs("Remove");
		}
	}
}