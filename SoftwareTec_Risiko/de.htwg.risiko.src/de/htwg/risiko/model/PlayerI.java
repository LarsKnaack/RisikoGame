package de.htwg.risiko.model;

import java.util.List;

/**
 * The Interface "PlayerI" is implemented by "Player" and provides methods to assign countries and setting the name
 * of this Player
 * @author Lars Knaack, Heiko Ettwein
 *
 */
public interface PlayerI {

	/**
	 * get the name of the player
	 * @return name
	 */
	String getName();
	
	/**
	 * Set the name of the Player, which is stored in a private variable
	 * @param s new name of the player
	 */
	void setName(String s);
	
	/**
	 * get a list of all countries, which the player owns
	 * the list is stored in a private variable
	 * @return list of all countries
	 */
	List<CountryI> getCountries();
	
	/**
	 * add a country to the list of countries
	 * this is needed for invading
	 * @param c country to add
	 */
	void addCountry(CountryI c);
	
	/**
	 * remove country from the list of countries
	 * this is needed for invading
	 * @param c country to remove
	 */
	void removeCountry(CountryI c);
}
