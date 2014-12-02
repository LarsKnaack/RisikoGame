package entities;
import static org.junit.Assert.*;

import java.awt.Color;
import java.util.LinkedList;

import junit.framework.TestCase;

import org.junit.Test;

import entities.Country;
import entities.Player;

public class PlayerTest extends TestCase {
	
	public void testAddLand() {
		Country l = new Country("test");
		LinkedList<Country> test = new LinkedList();
		test.add(l);
		Player p = new Player ("p");
		p.addCountry(l);
		assertTrue(test.equals(p.getCountries()));
	}
	
	public void testRemoveLand() {
		Country l = new Country("test");
		LinkedList<Country> test = new LinkedList();
		test.add(l);
		test.remove(l);
		Player s = new Player("p");
		s.addCountry(l);
		s.removeCountry(l);
		assertTrue(test.equals(s.getCountries()));
	}
	
	public void testSetVerstaerkung() {
		Player s = new Player ("s");
		Country l1 = new Country("L1");
		s.addCountry(l1);
		s.setRecruitment();
		assertTrue(s.getRecruitment() == 3);
		s.addCountry(l1);
		s.addCountry(l1);
		s.addCountry(l1);
		s.addCountry(l1);
		s.addCountry(l1);
		s.addCountry(l1);
		s.addCountry(l1);
		s.addCountry(l1);
		s.addCountry(l1);
		s.addCountry(l1);
		s.addCountry(l1);
		s.setRecruitment();
		assertTrue(s.getRecruitment() == 4);
	}
	
	public void testGetName() {
		Player s = new Player("Hans");
		assertEquals("Hans", s.getName());
	}
	
	public void testAddEinheit() {
		Country l = new Country("l");
		Player s1 = new Player("s1");
		Player s2 = new Player("s2");
		s1.setRecruitment();
		assertEquals(s1.addSoldier(l, 4), -1);
		l.setOccupying(s2);
		assertEquals(s1.addSoldier(l, 3), -1);
		l.setOccupying(s1);
		assertEquals(s1.addSoldier(l, 3), 0);
		
		
	}
}
