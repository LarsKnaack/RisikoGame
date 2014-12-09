package de.htwg.risiko.model;

import java.util.List;

public interface PlayerI {

	public String getName();
	public List<CountryI> getCountries();
	public void setCountries(List<CountryI> countries);

}