package de.htwg.risiko.model;
import java.awt.Point;

import junit.framework.TestCase;
import de.htwg.risiko.model.impl.Country;

public class CountryTest extends TestCase {
	
	public void testGetSoldiers() {
		ICountry test = new Country("Test");
		test.setSoldiers(5);
		assertEquals(test.getSoldiers(), 5);
	}
	
	public void testGetName() {
		ICountry test = new Country("Test");
		test.setName("Test1");
		assertEquals(test.getName(), "Test1");
	}
	
	public void testLocation() {
		ICountry test = new Country("Test", new Point (2, 3));
		assertEquals(test.getLocation(), new Point(2,3));
		test.setLocation(new Point (3,4));
		assertEquals(test.getLocation(), new Point (3,4));
	}
	
	public void testToString() {
		ICountry test = new Country("test");
		String s = test.toString();
		assertEquals(s, "test");
	}
	
	public void testCompareTo() {
		ICountry a = new Country("a");
		ICountry b = new Country("b");
		assertEquals(a.compareTo(b), "a".compareTo("b"));
	}
}
