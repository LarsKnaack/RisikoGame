package de.htwg.risiko.model;
import static org.junit.Assert.*;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;

import de.htwg.risiko.model.impl.Country;
import de.htwg.risiko.model.impl.Player;

public class PlayerTest extends TestCase {
	
	public void testGetName() {
		Player p = new Player("Player");
		assertEquals(p.getName(), "Player");
	}
	
	public void testGetCountries() {
		Player p = new Player("Player");
		List<Country> countries = new LinkedList<Country>();
		p.setCountries(countries);
		assertEquals(p.getCountries(), countries);
	}
}
