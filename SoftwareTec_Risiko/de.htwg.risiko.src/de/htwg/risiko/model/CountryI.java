package de.htwg.risiko.model;

import java.awt.Point;

public interface CountryI {

	
	//get soldiers positioned in the Country (saved in global variable)
	public int getSoldiers();
	//get soldiers positioned in the Country (saved in global variable)
	public void setSoldiers(int e);
	//get Name of the Country
	public String getName();
	//get Name of the Country
	public void setName(String n);
	
	public void setLocation(Point p);
	
	public Point getLocation();

}