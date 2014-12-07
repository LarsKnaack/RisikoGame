package de.htwg.risiko.model.impl;

import java.util.LinkedList;
import java.util.List;

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
	public List<Country> getCountries() {
		return countries;
	}

	@Override
	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}
	
}

