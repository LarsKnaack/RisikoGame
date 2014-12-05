package de.htwg.risiko.turn;

import java.lang.reflect.Method;
import java.util.Random;

import junit.framework.TestCase;
import de.htwg.risiko.model.Country;
import de.htwg.risiko.model.Player;
import de.htwg.risiko.turn.InvadeTurn;

public class InvadeTurnTest extends TestCase{
	
	public void testInvadeInvaderWins() {
		
		Country invader = new Country("Invader");
		Country defender = new Country("Defender");
		invader.setSoldiers(3);
		defender.setSoldiers(2);
		
		InvadeTurn t = new InvadeTurn(invader, defender);
		Die d = new Die();
		Random rand = new Random();
		rand.setSeed(4);
		d.setRandom(rand);
		t.setDie(d);
		Country p = t.handle();
		assertEquals(invader, p);
	}
	
public void testInvadeDefenderWins() {
		
		Country invader = new Country("Invader");
		Country defender = new Country("Defender");
		invader.setSoldiers(2);
		defender.setSoldiers(2);
		
		InvadeTurn t = new InvadeTurn(invader, defender);
		Die d = new Die();
		Random rand = new Random();
		rand.setSeed(4);
		d.setRandom(rand);
		t.setDie(d);
		Country p = t.handle();
		assertEquals(defender, p);
	}
	
	public void testSetMaxDice() {
		Country invader = new Country("Invader");
		Country defender = new Country("Defender");
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
