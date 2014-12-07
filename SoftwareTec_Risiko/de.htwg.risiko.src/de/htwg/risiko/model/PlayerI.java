package de.htwg.risiko.model;

import java.util.List;

import de.htwg.risiko.model.impl.Country;

public interface PlayerI {

	public String getName();
	public List<Country> getCountries();
	public void setCountries(List<Country> countries);

}