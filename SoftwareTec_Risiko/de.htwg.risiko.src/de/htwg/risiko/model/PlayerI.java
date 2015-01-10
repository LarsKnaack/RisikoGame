package de.htwg.risiko.model;

import java.util.List;

public interface PlayerI {

	String getName();
	void setName(String s);
	List<CountryI> getCountries();
	void addCountry(CountryI c);
	void removeCountry(CountryI c);
}
