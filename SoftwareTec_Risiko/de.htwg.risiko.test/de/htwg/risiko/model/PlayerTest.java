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
	
	public void testGetSetName() {
		Player p = new Player("Player");
		assertEquals(p.getName(), "Player");
		p.setName("Test");
		assertEquals(p.getName(), "Test");
	}
	
	public void testGetCountries() {
		Player p = new Player("Player");
		List<CountryI> countries = new LinkedList<CountryI>();
		CountryI test = new Country("test");
		countries.add(test);
		p.addCountry(test);
		assertEquals(p.getCountries(), countries);
		p.removeCountry(test);
		assertTrue(p.getCountries().isEmpty());
	}
}
