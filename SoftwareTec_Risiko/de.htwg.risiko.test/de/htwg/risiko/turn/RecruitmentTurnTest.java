package de.htwg.risiko.turn;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;

import de.htwg.risiko.model.CountryI;
import de.htwg.risiko.model.impl.Country;
import de.htwg.risiko.model.impl.Player;

public class RecruitmentTurnTest extends TestCase {
	
	public void pullTest() {
		Player p = new Player("Hans");
		RecruitmentTurn t = new RecruitmentTurn(p);
		Turn s = new Turn(p);
		t.pull(s);
		assertTrue(s.getState() instanceof InvadeTurn);
	}
	
	public void addRecruitmentTest() {
		Player p = new Player("Hans");
		CountryI test = new Country("test");
		List<CountryI> res = new LinkedList<CountryI>();
		res.add(test);
		p.setCountries(res);
		RecruitmentTurn t = new RecruitmentTurn(p);
		t.addRecruitment(test, 3);
		assertEquals(test.getSoldiers(), 3);
	}
	
	public void addRecruitmentTestFails() {
		Player p = new Player("Hans");
		CountryI test = new Country("test");
		List<CountryI> res = new LinkedList<CountryI>();
		res.add(test);
		p.setCountries(res);
		RecruitmentTurn t = new RecruitmentTurn(p);
		t.addRecruitment(test, 4);
		assertEquals(test.getSoldiers(), 0);
	}

}
