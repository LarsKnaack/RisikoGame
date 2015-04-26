package de.htwg.risiko.turn;

import junit.framework.TestCase;
import de.htwg.risiko.model.impl.Country;
import de.htwg.risiko.model.impl.Player;
import de.htwg.risiko.model.impl.World;

public class StartTurnTest extends TestCase{
	

	public void testPull() {
		Turn t = new Turn();
		t.setPlayer(new Player("Hans"), new Player("Herbert"));
		t.setWorld(new World());
		t.getWorld().addCountry(new Country("ghj"));
		t.getWorld().addCountry(new Country("gkk"));
		t.getWorld().addCountry(new Country("giij"));
		t.getWorld().addCountry(new Country("gsskk"));
		StartTurn s = new StartTurn();
		t.setState(s);
		s.pull(t);
		assertTrue(t.getState() instanceof InvadeTurn);
		assertTrue(!t.getPlayer().getCountries().isEmpty() && !t.getOpponent().getCountries().isEmpty());
	}

	public void testInit() {
		Turn t = new Turn();
		t.setPlayer(new Player("Hans"), new Player("Herbert"));
		t.setWorld(new World());
		t.getWorld().addCountry(new Country("ghj"));
		t.getWorld().addCountry(new Country("gkk"));
		t.getWorld().addCountry(new Country("giij"));
		t.getWorld().addCountry(new Country("gsskk"));
		t.pull();
		assertTrue(!t.getPlayer().getCountries().isEmpty() && !t.getOpponent().getCountries().isEmpty());
	}

}
