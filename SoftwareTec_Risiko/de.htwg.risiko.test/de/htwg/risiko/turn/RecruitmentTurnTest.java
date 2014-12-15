package de.htwg.risiko.turn;

import java.util.LinkedList;
import java.util.List;

import junit.framework.TestCase;

import de.htwg.risiko.model.CountryI;
import de.htwg.risiko.model.impl.Country;
import de.htwg.risiko.model.impl.Player;

public class RecruitmentTurnTest extends TestCase {
	
	public void testPull() {
		RecruitmentTurn t = new RecruitmentTurn();
		Turn s = new Turn();
		t.pull(s);
		assertTrue(s.getState() instanceof InvadeTurn);
	}
	
	public void testAddRecruitment() {
		Player p = new Player("Hans");
		CountryI test = new Country("test");
		List<CountryI> res = new LinkedList<CountryI>();
		res.add(test);
		p.setCountries(res);
		RecruitmentTurn t = new RecruitmentTurn();
		t.addRecruitment(test, 3);
		assertEquals(test.getSoldiers(), 3);
	}
	
	public void testAddRecruitmentFails() {
		Player p = new Player("Hans");
		CountryI test = new Country("test");
		List<CountryI> res = new LinkedList<CountryI>();
		res.add(test);
		p.setCountries(res);
		RecruitmentTurn t = new RecruitmentTurn();
		t.addRecruitment(test, 4);
		assertEquals(test.getSoldiers(), 0);
	}
}
