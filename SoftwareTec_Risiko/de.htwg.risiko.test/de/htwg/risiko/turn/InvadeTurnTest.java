package de.htwg.risiko.turn;

import java.util.Random;

import de.htwg.risiko.model.impl.Country;
import de.htwg.risiko.model.impl.Player;
import de.htwg.risiko.model.impl.World;
import junit.framework.TestCase;

public class InvadeTurnTest extends TestCase {

	public void testPull() {
		Turn t = new Turn();
		t.setPlayer(new Player("Hans"), new Player("Herbert"));
		t.setWorld(new World());
		Country c = new Country("ghj");
		Country c1 = new Country("sdfj");
		t.getWorld().addCountry(c);
		t.getWorld().addCountry(c1);
		t.setInvader(c);
		t.setDefender(c1);
		InvadeTurn i = new InvadeTurn();
		t.setState(i);

		c.setSoldiers(4);
		c1.setSoldiers(0);

		i.pull(t);
		assertTrue(t.getState() instanceof InvadeTurn);

		c.setSoldiers(4);
		c1.setSoldiers(1);
		
		Die d = new Die();
		Random rand = new Random();
		rand.setSeed(2);
		d.setRandom(rand);
		i.setDie(d);
		assertEquals(t.getInvader(), i.winner());

		c.setSoldiers(2);
		c1.setSoldiers(2);
		
		assertEquals(t.getDefender(), i.winner());

		t.endTurn();
		i.pull(t);
		assertTrue(t.getState() instanceof RecruitmentTurn);
	}
	
	public void testPullDefenderWins() {
		
		Turn t = new Turn();
		t.setPlayer(new Player("Hans"), new Player("Herbert"));
		t.setWorld(new World());
		Country c = new Country("ghj");
		Country c1 = new Country("sdfj");
		t.getWorld().addCountry(c);
		t.getWorld().addCountry(c1);
		t.setInvader(c);
		t.setDefender(c1);
		InvadeTurn i = new InvadeTurn();
		t.setState(i);

		Die d = new Die();
		Random rand = new Random();
		rand.setSeed(2);
		i.setDie(d);
		
		c.setSoldiers(2);
		c1.setSoldiers(2);

		i.pull(t);
		System.out.println(t.getStatus());
		assertTrue(t.getState() instanceof InvadeTurn);
	}
	
}
