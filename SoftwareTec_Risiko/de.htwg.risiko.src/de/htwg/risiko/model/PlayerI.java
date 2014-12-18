package de.htwg.risiko.model;

import java.util.List;

public interface PlayerI {

	public String getName();
	public void setName(String s);
	public List<CountryI> getCountries();
	public void addCountry(CountryI c);
	public void removeCountry(CountryI c);
}
