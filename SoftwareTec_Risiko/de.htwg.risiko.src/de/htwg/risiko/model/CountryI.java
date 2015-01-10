package de.htwg.risiko.model;

import java.awt.Point;

import de.htwg.risiko.model.impl.Country;

public interface CountryI extends Comparable<CountryI>{

	
	//get soldiers positioned in the Country (saved in global variable)
	int getSoldiers();
	//get soldiers positioned in the Country (saved in global variable)
	void setSoldiers(int e);
	//get Name of the Country
	String getName();
	//get Name of the Country
	void setName(String n);
	
	void setLocation(Point p);
	
	Point getLocation();
	
	int compareTo(Country o);
	
	

}