package de.htwg.risiko.turn;

import junit.framework.TestCase;
import de.htwg.risiko.model.impl.Country;
import de.htwg.risiko.model.impl.Player;
import de.htwg.risiko.model.impl.World;

public class TurnTest extends TestCase {

	public void testHasFinished() {
		Turn t = new Turn();
		t.startTurn();
		assertTrue(!t.hasFinished());
		t.endTurn();
		assertTrue(t.hasFinished());
	}

	public void testPull() {
		Turn t = new Turn();
		t.setPlayer(new Player("Hans"), new Player("Herbert"));
		t.setWorld(new World());
		t.getWorld().addCountry(new Country("ghj"));
		t.pull();
		assertTrue(t.getState() instanceof InvadeTurn);
	}
	
	public void testGetPlayer() {
		Player p1 = new Player("Hans");
		Player p2 = new Player("Herbert");
		Turn t = new Turn();
		t.setPlayer(p1, p2);
		assertEquals(t.getPlayer(), p1);
		t.switchPlayer(p2);
		assertEquals(t.getOpponent(), p1);
	}

	public void testGetInvader() {
		Turn t = new Turn();
		Country c = new Country("hll"); 
		t.setInvader(c);
		assertEquals(t.getInvader(), c);
	}

	public void testGetDefender() {
		Turn t = new Turn();
		Country c = new Country("hll"); 
		t.setDefender(c);
		assertEquals(t.getDefender(), c);
	}

	public void testGetRecCountry() {
		Turn t = new Turn();
		Country c = new Country("hll"); 
		t.setRecCountry(c);
		assertEquals(t.getRecCountry(), c);
	}

	public void testGetRecruitment() {
		Turn t = new Turn(); 
		t.setRecruitment(1);
		assertEquals(1, t.getRecruitment());
	}

	public void testGetMaxRecruitment() {
		Turn t = new Turn(); 
		t.setMaxRecruitment(1);
		assertEquals(1, t.getMaxRecruitment());
	}

	public void testGetStatus() {
		Turn t = new Turn();
		String s = "j";
		t.setStatus(s);
		assertEquals("\n" + s, t.getStatus());
	}

	public void testInitRecruitment() {
		Player p1 = new Player("Hans");
		Player p2 = new Player("Herbert");
		Turn t = new Turn();
		t.setPlayer(p1, p2);
		p1.addCountry(new Country("h"));
		t.initRecruitment();
		assertEquals(3, t.getMaxRecruitment());
	}
}
