package de.htwg.risiko.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.MouseInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Dialogs implements ActionListener{
	
	JFrame main;
	JButton mybutton;
	JLabel lTextfield;
	JTextField myTf;
	
	public Dialogs(String s) {
		String title = s + " Army";
		main = new JFrame(title);
		Container content = main.getContentPane();
		mybutton = new JButton(s);
		mybutton.addActionListener(this);
		lTextfield = new JLabel("Number of Soldiers");
		myTf = new JTextField(10);
		
		content.add(lTextfield, BorderLayout.WEST);
		content.add(myTf, BorderLayout.EAST);
		content.add(mybutton, BorderLayout.SOUTH);
		
		/*SpringLayout layout = new SpringLayout();
		layout.putConstraint(SpringLayout.WEST, content, 5, SpringLayout.WEST, lTextfield);
		layout.putConstraint(SpringLayout.EAST, content, 5, SpringLayout.EAST, myTf);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, content, 0, SpringLayout.HORIZONTAL_CENTER, mybutton);*/
		
		main.pack();
		main.setLocation(MouseInfo.getPointerInfo().getLocation().x, MouseInfo.getPointerInfo().getLocation().y);
		main.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == mybutton) {
			JOptionPane.showConfirmDialog(main, "Are you sure to do this?");
			main.dispose();
		}
	
	}
}