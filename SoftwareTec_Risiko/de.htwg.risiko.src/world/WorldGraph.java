package world;

import java.util.List;

import source.Country;

public interface WorldGraph {

	void addCountry(Country v);
 	void addEdge(Country v, Country w);
 	List<Country> getNeighbouringCountryList(Country v);
 	boolean isNeighbour(Country v, Country w);
}