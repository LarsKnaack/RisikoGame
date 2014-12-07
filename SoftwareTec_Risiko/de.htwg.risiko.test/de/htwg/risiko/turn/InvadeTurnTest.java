package de.htwg.risiko.turn;

import static org.junit.Assert.*;

import java.util.Random;

import junit.framework.TestCase;

import org.junit.Test;

import de.htwg.risiko.model.CountryI;
import de.htwg.risiko.model.impl.Country;

public class InvadeTurnTest extends TestCase{

	public void testPull() {
		InvadeTurn t = new InvadeTurn(new Country("a"), new Country("b"));
		Turn s = new Turn();
		t.pull(s);
		assertTrue(s.getState() instanceof RecruitmentTurn);
		
		
	}
	
	public void testInvadeInvaderWins() {
		
		CountryI invader = new Country("Invader");
		CountryI defender = new Country("Defender");
		invader.setSoldiers(3);
		defender.setSoldiers(2);
		
		InvadeTurn t = new InvadeTurn(invader, defender);
		Die d = new Die();
		Random rand = new Random();
		rand.setSeed(2);
		d.setRandom(rand);
		t.setDie(d);
		CountryI p = t.handle();
		assertEquals(invader, p);
	}
	
public void testInvadeDefenderWins() {
		
		CountryI invader = new Country("Invader");
		CountryI defender = new Country("Defender");
		invader.setSoldiers(2);
		defender.setSoldiers(2);
		
		InvadeTurn t = new InvadeTurn(invader, defender);
		Die d = new Die();
		Random rand = new Random();
		rand.setSeed(4);
		d.setRandom(rand);
		t.setDie(d);
		CountryI p = t.handle();
		assertEquals(defender, p);
	}
	
	public void testSetMaxDice() {
		CountryI invader = new Country("Invader");
		CountryI defender = new Country("Defender");
		InvadeTurn t = new InvadeTurn(invader, defender);
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

}
