package de.htwg.risiko.gamefield;

import java.util.List;

import de.htwg.risiko.model.CountryI;
import de.htwg.risiko.model.impl.Country;

public interface WorldI {

	void addCountry(Country v);
 	void addEdge(Country v, Country w);
 	List<Country> getNeighbouringCountryList(CountryI v);
 	boolean isNeighbour(CountryI v, CountryI w);
}