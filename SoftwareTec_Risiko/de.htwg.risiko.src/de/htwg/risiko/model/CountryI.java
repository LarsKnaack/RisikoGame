package de.htwg.risiko.model;

import java.awt.Point;

/**
 * The interface "CountryI" extends the interface Comparable is implemented by "Country" in package "impl" and provides methods to set the number of soldiers
 * in one country, methods to set the name of a country, methods to set the location of the country on the gamefield
 * @author Lars Knaack, Heiko Ettwein
 *
 */

public interface CountryI extends Comparable<CountryI>{
	
	/**
	 * get the number of soldiers on the country
	 * @return number of soldiers
	 */
	int getSoldiers();
	
	/**
	 * set the number of Soldiers
	 * @param e number of soldiers (e has to be positive)
	 */
	void setSoldiers(int e);
	
	/**
	 * get the name of the country
	 * @return string, which contains the name
	 */
	String getName();
	
	/**
	 * set a country's name
	 * @param n name to set
	 */
	void setName(String n);
	
	/**
	 * set the location of a country on the gamefield
	 * @param p point of new Location
	 */
	void setLocation(Point p);
	
	/**
	 * get the location of a country on the gamefield
	 * @return Point of Location
	 */
	Point getLocation();
	
	/**
	 * compares the name of a country, in order to sort a list of countries
	 */
	int compareTo(CountryI o);
	
	

}