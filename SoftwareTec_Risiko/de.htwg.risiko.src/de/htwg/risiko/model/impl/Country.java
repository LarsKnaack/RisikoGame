package de.htwg.risiko.model.impl;

import de.htwg.risiko.model.CountryI;

public class Country implements CountryI {
	
	private int soldiers;
	private String name;

	public Country(String n) {
		soldiers = 0;
		name = n;
	}
	
	@Override
	public int getSoldiers() {
		return soldiers;
	}
	
	@Override
	public void setSoldiers(int e) {
		soldiers = e;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String n) {
		name = n;
	}
}
