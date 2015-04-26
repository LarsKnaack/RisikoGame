package de.htwg.risiko.model.impl;

import java.util.LinkedList;
import java.util.List;

import de.htwg.risiko.model.ICountry;
import de.htwg.risiko.model.IPlayer;


public class Player implements IPlayer {
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
	
	public void setName(String s) {
		name = s;
	}

	@Override
	public List<ICountry> getCountries() {
		List<ICountry> res = new LinkedList<ICountry>();
		for(Country c: countries) {
			res.add(c);
		}
		return res;
	}

	@Override
	public void addCountry(ICountry c) {
		countries.add((Country) c);
	}

	@Override
	public void removeCountry(ICountry c) {
		countries.remove(c);
	}
	
}

