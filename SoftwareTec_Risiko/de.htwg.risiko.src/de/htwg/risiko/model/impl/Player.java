package de.htwg.risiko.model.impl;

import java.util.LinkedList;
import java.util.List;

import de.htwg.risiko.model.CountryI;
import de.htwg.risiko.model.PlayerI;


public class Player implements PlayerI {
	private String name;
	private List<Country> countries;
	
	public Player(String n) {
		name = n;
		countries = new LinkedList<Country>();
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public List<CountryI> getCountries() {
		List<CountryI> res = new LinkedList<CountryI>();
		for(Country c: countries) {
			res.add(c);
		}
		return res;
	}

	@Override
	public void setCountries(List<CountryI> countries) {
		this.countries.clear();
		for(CountryI c: countries) {
			this.countries.add((Country) c);
		}
	}
	
}

