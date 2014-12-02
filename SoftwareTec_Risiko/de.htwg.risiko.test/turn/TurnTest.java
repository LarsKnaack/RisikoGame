package turn;

import static org.junit.Assert.*;

import java.util.Random;

import entities.Country;
import entities.Player;
import junit.framework.TestCase;
import turn.Die;
import turn.Turn;


public class TurnTest extends TestCase {
	
	public void testInvadeTurnInvaderWins() {
		Turn r = new Turn();
		Random rand = new Random();
		rand.setSeed(2);
		Die test = new Die();
		test.setRandom(rand);
		r.setDie(test);
		Country ang = new Country("Angreifer");
		ang.setSoldiers(5);
		Country dev = new Country("Verteidiger");
		dev.setSoldiers(1);
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		ang.setOccupying(p1);
		dev.setOccupying(p2);
		ang.setInvader(true);
		dev.setDefender(true);
		r.setMaxDice(ang);
		r.setMaxDice(dev);
		Player gewinner = r.invadeTurn(ang, dev);
		assertTrue(gewinner == p1);
	}
	
	public void testInvadeTurnDefenderWins() {
		Turn r = new Turn();
		Random rand = new Random();
		rand.setSeed(2);
		Die test = new Die();
		test.setRandom(rand);
		r.setDie(test);
		Country ang = new Country("Angreifer");
		ang.setSoldiers(2);
		Country dev = new Country("Verteidiger");
		dev.setSoldiers(2);
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		ang.setOccupying(p1);
		dev.setOccupying(p2);
		ang.setInvader(true);
		dev.setDefender(true);
		r.setMaxDice(ang);
		r.setMaxDice(dev);
		Player winner = r.invadeTurn(ang, dev);
		assertTrue(winner.equals(p2));
	}
	
	public void testSetMaxDiceAngreifer() {
		Turn test = new Turn();
		Country ang = new Country("Angreifer");
		ang.setInvader(true);
		ang.setSoldiers(5);
		assertEquals(test.setMaxDice(ang), 3);
		ang.setSoldiers(2);
		assertEquals(test.setMaxDice(ang), 2);
	}
	
	public void testSetMaxDiceVerteidiger() {
		Turn test = new Turn();
		Country dev = new Country("Verteidiger");
		dev.setDefender(true);
		dev.setSoldiers(4);
		assertEquals(test.setMaxDice(dev), 2);
		dev.setSoldiers(1);
		assertEquals(test.setMaxDice(dev), 1);
	}

}
