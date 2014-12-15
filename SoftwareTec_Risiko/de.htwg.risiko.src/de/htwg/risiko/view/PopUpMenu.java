package de.htwg.risiko.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

@SuppressWarnings("serial")
public class PopUpMenu extends JFrame implements ActionListener {

	private JPopupMenu main;
	private JMenuItem add;
	private JMenuItem remove;
	
	public PopUpMenu() {
		main = new JPopupMenu();
		add = new JMenuItem("Add Army");
		add.addActionListener(this);
		remove = new JMenuItem("Remove Army");
		remove.addActionListener(this);
		main.add(add);
		main.add(remove);
	}
	
	public void showMenu(MouseEvent e) {
		main.show(e.getComponent(), e.getX(), e.getY());
	}
	
	public void desappearMenu() {
		main.setVisible(false);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if (source == add) {
			new Dialogs("Add");
		}
		if (source == remove) {
			new Dialogs("Remove");
		}
	}
}