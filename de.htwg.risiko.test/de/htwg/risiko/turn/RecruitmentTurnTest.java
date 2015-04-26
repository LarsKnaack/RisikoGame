package de.htwg.risiko.turn;

import de.htwg.risiko.model.impl.Country;
import de.htwg.risiko.model.impl.Player;
import de.htwg.risiko.model.impl.World;
import junit.framework.TestCase;

public class RecruitmentTurnTest extends TestCase {

	public void testPull() {
		Turn t = new Turn();
		t.setPlayer(new Player("Hans"), new Player("Herbert"));
		t.setWorld(new World());
		Country c = new Country("ghj");
		t.getWorld().addCountry(c);
		t.setRecCountry(c);
		t.initRecruitment();
		t.setRecruitment(1);
		RecruitmentTurn r = new RecruitmentTurn();
		t.setState(r);
		r.pull(t);
		assertTrue(t.getState() instanceof RecruitmentTurn);
		assertTrue(t.getMaxRecruitment() == 2);
		t.setRecruitment(3);
		r.pull(t);
		assertTrue(t.getMaxRecruitment() == 2);
		t.setRecruitment(2);
		r.pull(t);
		assertTrue(t.getState() instanceof InvadeTurn);
	}	
}
