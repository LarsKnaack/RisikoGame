package de.htwg.risiko.model;

import java.util.List;


public interface WorldI {

	void addCountry(CountryI v);
 	void addEdge(CountryI v, CountryI w);
 	List<CountryI> getNeighbouringCountryList(CountryI v);
 	boolean isNeighbour(CountryI v, CountryI w);
}