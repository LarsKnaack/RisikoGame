package source;
import static org.junit.Assert.*;

import java.awt.Color;

import junit.framework.TestCase;

import org.junit.Test;

import  source.Country;
import source.Player;

public class CountryTest extends TestCase {
	
	public void testGetAnzahlEinheiten() {
		Country test = new Country("test");
		test.setSoldiers(5);
		assertTrue(test.getSoldiers() == 5);
	}
	
	public void testSetEinheiten() {
		Country test = new Country("test");
		test.setSoldiers(5);
		assertTrue(test.getSoldiers() == 5);
	}
		
	public void testSetBesatzer() {
		Country test = new Country("test");
		Player s3 = new Player("s3");
		test.setOccupying(s3);
		assertTrue(test.getOccupying() == s3);
	}
	
	public void testSetAngreifer() {
		Country test = new Country("test");
		test.setInvader(true);
		assertTrue(test.isInvader());
		test.setInvader(false);
		assertFalse(test.isInvader());
	}
	
	public void testSetVerteidiger() {
		Country test = new Country("test");
		test.setDefender(true);
		assertTrue(test.isDefender());
		test.setDefender(false);
		assertFalse(test.isDefender());
	}
	
	public void testSetName() {
		Country test = new Country("test");
		test.setName("NewName");
		assertEquals(test.getName(), "NewName");
	}
}
