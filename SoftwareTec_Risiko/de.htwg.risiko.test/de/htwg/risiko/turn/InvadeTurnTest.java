package de.htwg.risiko.turn;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.htwg.risiko.controller.GameEngine;
import de.htwg.risiko.model.CountryI;
import de.htwg.risiko.model.impl.Country;
import de.htwg.risiko.model.impl.Player;
import de.htwg.risiko.model.impl.World;

public class InvadeTurnTest extends TestCase{
	
	
	private World world;
	private Player p;
	CountryI invader;
	CountryI defender;
	List<CountryI> inv;
	InvadeTurn t;
	
	@Before
	public void setUp() {
		world = (World) GameEngine.world;
		p = new Player("Player1");
		invader = new Country("Invader");
		inv = new LinkedList<CountryI>();
		inv.add(invader);
		p.setCountries(inv);
		defender = new Country("Defender");
		world.addCountry(invader);
		world.addCountry(defender);
		world.addEdge(invader, defender);
		t = new InvadeTurn(p);
		t.setInvadingCountry(invader);
		t.setDefendingCountry(defender);
	}
	
	@After
	public void tearDown() {
		world = null;
		p = null;
	}

	public void testPull() {
		Turn s = new Turn(p);
		t.pull(s);
		assertTrue(s.getState() instanceof RecruitmentTurn);
		
		
	}
	
	public void testInvadeInvaderWins() {
		
		invader.setSoldiers(3);
		defender.setSoldiers(2);
		
		Die d = new Die();
		Random rand = new Random();
		rand.setSeed(2);
		d.setRandom(rand);
		t.setDie(d);
		CountryI res = t.winner();
		assertEquals(invader, res);
	}
	
	public void testInvadeDefenderWins() {
		
		invader.setSoldiers(2);
		defender.setSoldiers(2);
			
		Die d = new Die();
		Random rand = new Random();
		rand.setSeed(4);
		d.setRandom(rand);
		t.setDie(d);
		CountryI res = t.winner();
		assertEquals(defender, res);
	}
	
	public void testSetMaxDice() {
		
		invader.setSoldiers(3);
		defender.setSoldiers(3);
		
		t.setMaxDice();
		assertEquals(t.maxDefDice, 2);
		assertEquals(t.maxInvDice, 3);
		invader.setSoldiers(2);
		defender.setSoldiers(1);
		t.setMaxDice();
		assertEquals(t.maxDefDice, 1);
		assertEquals(t.maxInvDice, 2);
	}
	
	public void testSetInvadingCountryFails() {
		world = new World();
		Country test = new Country("test");
		t.setInvadingCountry(test);
		assertFalse(t.getInvadingCountry() == test);
	}
	
	public void testSetDefendingCountryFails() {
		Country test = new Country("test");
		t.setDefendingCountry(test);
		assertFalse(t.getDefendingCountry() == test);
	}

}
