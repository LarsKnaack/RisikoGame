package de.htwg.risiko.turn;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Test;

import de.htwg.risiko.model.impl.Player;

public class TurnTest extends TestCase{

	public void testPull() {
		Turn t = new Turn();
		t.pull();
		assertTrue(t.getState() instanceof InvadeTurn);
	}
	
	public void testGetPlayer() {
		Player p = new Player("Hans");
		Turn t = new Turn();
		t.setPlayer(p);
		assertEquals(t.getPlayer(), p);
	}

}
