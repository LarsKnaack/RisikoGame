package de.htwg.risiko.model;
import static org.junit.Assert.*;

import java.awt.Color;

import junit.framework.TestCase;

import org.junit.Test;

import de.htwg.risiko.model.Country;
import de.htwg.risiko.model.Player;

public class CountryTest extends TestCase {
	
	public void testGetSoldiers() {
		Country test = new Country("Test");
		test.setSoldiers(5);
		assertEquals(test.getSoldiers(), 5);
	}
	
	public void testGetName() {
		Country test = new Country("Test");
		test.setName("Test1");
		assertEquals(test.getName(), "Test1");
	}
}
