package de.htwg.risiko.turn;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import de.htwg.risiko.controller.GameEngine;
import de.htwg.risiko.model.CountryI;
import de.htwg.risiko.model.PlayerI;
import de.htwg.risiko.model.impl.Country;
import de.htwg.risiko.model.impl.World;

public class StartTurnTest extends TestCase{
	
	private World world;
	private PlayerI p1;
	private PlayerI p2;
	StartTurn t;

	@Before
	public void setUp() throws Exception {
		t = new StartTurn();
		world = (World) GameEngine.world;
		p1 = GameEngine.player1;
		p2 = GameEngine.player2;
		CountryI invader = new Country("Invader");
		world.addCountry(invader);
		CountryI defender = new Country("Defender");
		world.addCountry(defender);
		world.addEdge(invader, defender);
	}

	public void testPull() {
		Turn s = new Turn(p1);
		t.pull(s);
		assertTrue(s.getState() instanceof InvadeTurn);
	}
	

}
