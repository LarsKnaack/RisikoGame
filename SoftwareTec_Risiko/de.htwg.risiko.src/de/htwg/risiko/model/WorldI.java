package de.htwg.risiko.model;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import de.htwg.risiko.model.impl.Country;


public interface WorldI {

	void addCountry(CountryI v);
 	void addEdge(CountryI v, CountryI w);
 	List<CountryI> getNeighbouringCountryList(CountryI v);
 	boolean isNeighbour(CountryI v, CountryI w);
 	Map<Country, LinkedList<Country>> getWorld();
}