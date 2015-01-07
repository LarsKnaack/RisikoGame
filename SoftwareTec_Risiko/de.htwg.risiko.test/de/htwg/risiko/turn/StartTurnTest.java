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
		t.pull();
		assertTrue(t.getState() instanceof InvadeTurn);
	}
	

}
