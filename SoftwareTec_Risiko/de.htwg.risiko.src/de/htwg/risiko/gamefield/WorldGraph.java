package de.htwg.risiko.gamefield;

import java.util.List;

import de.htwg.risiko.model.Country;

public interface WorldGraph {

	void addCountry(Country v);
 	void addEdge(Country v, Country w);
 	List<Country> getNeighbouringCountryList(Country v);
 	boolean isNeighbour(Country v, Country w);
}