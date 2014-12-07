package de.htwg.risiko.model.impl;

import de.htwg.risiko.model.CountryI;

public class Country implements CountryI {
	
	private int soldiers;
	private String name;

	public Country(String n) {
		soldiers = 0;
		name = n;
	}
	
	/* (non-Javadoc)
	 * @see de.htwg.risiko.model.CountryI#getSoldiers()
	 */
	@Override
	public int getSoldiers() {
		return soldiers;
	}
	
	/* (non-Javadoc)
	 * @see de.htwg.risiko.model.CountryI#setSoldiers(int)
	 */
	@Override
	public void setSoldiers(int e) {
		soldiers = e;
	}

	/* (non-Javadoc)
	 * @see de.htwg.risiko.model.CountryI#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see de.htwg.risiko.model.CountryI#setName(java.lang.String)
	 */
	@Override
	public void setName(String n) {
		name = n;
	}
}
