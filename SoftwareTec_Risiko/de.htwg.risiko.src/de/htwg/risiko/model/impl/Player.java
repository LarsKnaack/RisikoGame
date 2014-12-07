package de.htwg.risiko.model.impl;

import de.htwg.risiko.model.PlayerI;


public class Player implements PlayerI {
	private String name;
	
	public Player(String n) {
		name = n;
	}
	
	/* (non-Javadoc)
	 * @see de.htwg.risiko.model.PlayerI#getName()
	 */
	@Override
	public String getName() {
		return name;
	}
	
}

